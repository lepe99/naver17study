// TransactionsDao.java
package dao;

import dto.TransactionsDto;
import util.MySQLConnect;

import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDao {
    MySQLConnect db = new MySQLConnect();
    
    /**
     * 거래내역 추가
     * 거래 유형이 expense인 경우 금액은 음수로 저장
     * @param dto 거래내역 정보
     */
    public void insertTransaction(TransactionsDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                insert into transactions
                (user_id, transaction_date, amount, description, transaction_type, category_id)
                values (?, ?, ?, ?, ?, ?)
                """;
        
        String transactionType = dto.getTransactionType();
        int amount = transactionType.equals("income") ? dto.getAmount() : -dto.getAmount();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getUserId());
            ps.setDate(2, dto.getTransactionDate());
            ps.setInt(3, amount);
            ps.setString(4, dto.getDescription());
            ps.setString(5, transactionType);
            ps.setInt(6, dto.getCategoryId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    /**
     * 거래내역 수정
     * @param dto 거래내역 정보
     */
    public void updateTransaction(TransactionsDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update transactions
                set transaction_date = ?, amount = ?, description = ?, transaction_type = ?, category_id = ?
                where id = ?
                """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, dto.getTransactionDate());
            ps.setInt(2, dto.getAmount());
            ps.setString(3, dto.getDescription());
            ps.setString(4, dto.getTransactionType());
            ps.setInt(5, dto.getCategoryId());
            ps.setInt(6, dto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    /**
     * 거래내역 삭제
     * @param id 거래내역 아이디
     */
    public void deleteTransaction(int id) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                delete from transactions
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
    
    /**
     * 월별 거래내역 조회
     * @param userId 사용자 아이디
     * @param year 년도
     * @param month 월
     * @return list 거래내역 목록
     */
    public List<TransactionsDto> getMonthlyTransactions(int userId, int year, int month) {
        Connection conn = db.getNCloudConnection();
        List<TransactionsDto> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select *
                from transactions
                where user_id = ?
                and transaction_date >= ?
                and transaction_date <= ?
                """;
        
        
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(firstDay));
            ps.setDate(3, Date.valueOf(lastDay));
            rs = ps.executeQuery();
            
            while (rs.next()) {
                TransactionsDto dto = new TransactionsDto();
                dto.setId(rs.getInt("id"));
                dto.setUserId(rs.getInt("user_id"));
                dto.setRecurringId(rs.getInt("recurring_id"));
                dto.setTransactionDate(rs.getDate("transaction_date"));
                dto.setAmount(rs.getInt("amount"));
                dto.setDescription(rs.getString("description"));
                dto.setTransactionType(rs.getString("transaction_type"));
                dto.setCategoryId(rs.getInt("category_id"));
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
        return list;
    }
    
    /**
     * 현재일까지의 입출금 합계 조회
     * @param userId 사용자 아이디
     * @return amount 입출금 합계
     */
    public int getAmountSum(int userId) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select sum(amount) as amount
                from transactions
                where user_id = ? and transaction_date <= ?
                """;
        
        LocalDate today = LocalDate.now();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(today));
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return 0;
    }
    
    /**
     * 월별 수입 합계 조회
     * @param userId 사용자 아이디
     * @param year 년도
     * @param month 월
     * @return amount 입금 합계
     */
    public int getIncomeSum(int userId, int year, int month) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select sum(amount) as amount
                from transactions
                where user_id = ?
                  and transaction_date >= ? and transaction_date <= ?
                  and transaction_type = 'income'
                """;
        
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(firstDay));
            ps.setDate(3, Date.valueOf(lastDay));
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return 0;
    }
    
    /**
     * 월별 지출 합계 조회
     * @param userId 사용자 아이디
     * @param year 년도
     * @param month 월
     * @return amount 지출 합계
     */
    public int getExpenseSum(int userId, int year, int month) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select sum(amount) as amount
                from transactions
                where user_id = ?
                and transaction_date >= ? and transaction_date <= ?
                and transaction_type = 'expense'
                """;
        
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(firstDay));
            ps.setDate(3, Date.valueOf(lastDay));
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return 0;
    }
    
    /**
     * 다음 일부터 설정 월까지의 수입 합계 조회
     * @param userId 사용자 아이디
     * @param year 년도
     * @param month 월
     * @return amount 수입 합계
     */
    public int getIncomeSumUntil(int userId, int year, int month) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select sum(amount) as amount
                from transactions
                where user_id = ?
                and transaction_date > ? and transaction_date <= ?
                and transaction_type = 'income'
                """;
        
        LocalDate today = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate lastDay = yearMonth.atEndOfMonth();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(today));
            ps.setDate(3, Date.valueOf(lastDay));
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return 0;
    }
    
    /**
     * 다음 일부터 설정 월까지의 지출 합계 조회
     * @param userId 사용자 아이디
     * @param year 년도
     * @param month 월
     * @return amount 지출 합계
     */
    public int getExpenseSumUntil(int userId, int year, int month) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select sum(amount) as amount
                from transactions
                where user_id = ?
                and transaction_date > ? and transaction_date <= ?
                and transaction_type = 'expense'
                """;
        
        LocalDate today = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate lastDay = yearMonth.atEndOfMonth();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(today));
            ps.setDate(3, Date.valueOf(lastDay));
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return 0;
    }
}
