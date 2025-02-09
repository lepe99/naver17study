// RecurringTransactionsDao.java
package dao;

import dto.RecurringTransactionsDto;
import dto.TransactionsDto;
import util.MySQLConnect;

import java.sql.*;
import java.time.LocalDate;

public class RecurringTransactionsDao {
    MySQLConnect db = new MySQLConnect();
    
    /**
     * 반복 거래 정보 추가
     * 추가한 반복 거래 정보를 기반으로 거래 정보를 추가
     *
     * @param dto 반복 거래 정보
     */
    public void insertRecurringTransactions(RecurringTransactionsDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                insert into recurring_transactions
                (user_id, amount, description, transaction_type, start_date, end_date, frequency, interval_value, category_id)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        
        String sqlSelect = """
                select max(id) as id
                from recurring_transactions
                where user_id = ?
                """;
        
        int userId = dto.getUserId();
        int amount = dto.getAmount();
        String description = dto.getDescription();
        String transactionType = dto.getTransactionType();
        int categoryId = dto.getCategoryId();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, amount);
            ps.setString(3, description);
            ps.setString(4, transactionType);
            ps.setDate(5, dto.getStartDate());
            ps.setDate(6, dto.getEndDate());
            ps.setString(7, dto.getFrequency());
            ps.setInt(8, dto.getIntervalValue());
            ps.setInt(9, dto.getCategoryId());
            ps.executeUpdate();
            
            ps = conn.prepareStatement(sqlSelect);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            int recurringId = 1;
            if (rs.next()) {
                recurringId = rs.getInt("id");
            }
            
            TransactionsDto transactionsDto = new TransactionsDto();
            transactionsDto.setUserId(userId);
            transactionsDto.setRecurringId(recurringId);
            transactionsDto.setAmount(amount);
            transactionsDto.setDescription(description);
            transactionsDto.setTransactionType(transactionType);
            transactionsDto.setCategoryId(categoryId);
            
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            try {
                addRecurringTransactionsToTransactions(transactionsDto, dto);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("반복 거래를 transactions 에 추가하는 중 오류 발생", e);
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
    }
    
    /**
     * 반복 거래 정보를 거래 정보에 추가
     *
     * @param dto  거래 정보
     * @param rDto 반복 거래 정보
     */
    public void addRecurringTransactionsToTransactions(TransactionsDto dto, RecurringTransactionsDto rDto) {
        TransactionsDao dao = new TransactionsDao();
        
        // 시작 일자
        LocalDate startDate = rDto.getStartDate().toLocalDate();
        // 종료 일자
        LocalDate endDate = rDto.getEndDate().toLocalDate();
        // 주기
        String frequency = rDto.getFrequency();
        // 주기 값
        int intervalValue = rDto.getIntervalValue();
        
        LocalDate currentDate = startDate;
        
        while (!currentDate.isAfter(endDate)) {
            // dto의 날짜를 현재 날짜로 설정
            dto.setTransactionDate(Date.valueOf(currentDate));
            // 거래 정보 추가
            dao.insertTransaction(dto);
            
            // 다음 날짜 계산
            switch (frequency) {
                case "daily" -> currentDate = currentDate.plusDays(intervalValue);
                case "weekly" -> currentDate = currentDate.plusWeeks(intervalValue);
                case "monthly" -> currentDate = currentDate.plusMonths(intervalValue);
                case "yearly" -> currentDate = currentDate.plusYears(intervalValue);
            }
        }
    }
    
    /**
     * 반복 거래 정보 삭제
     *
     * @param id 반복 거래 아이디
     */
    public void deleteRecurringTransactions(int id) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                delete from recurring_transactions
                where id = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
}