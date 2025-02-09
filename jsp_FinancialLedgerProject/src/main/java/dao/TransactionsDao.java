// TransactionsDao.java
package dao;

import dto.TransactionsDto;
import util.MySQLConnect;

import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                (user_id, recurring_id, transaction_date, amount, description, transaction_type, category_id)
                values (?, ?, ?, ?, ?, ?, ?)
                """;
        
        String transactionType = dto.getTransactionType();
        int amount = transactionType.equals("income") ? dto.getAmount() : -dto.getAmount();
        int recurringId = dto.getRecurringId() == 0 ? 1 : dto.getRecurringId();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getUserId());
            ps.setInt(2, recurringId);
            ps.setDate(3, dto.getTransactionDate());
            ps.setInt(4, amount);
            ps.setString(5, dto.getDescription());
            ps.setString(6, transactionType);
            ps.setInt(7, dto.getCategoryId());
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
     * 카테고리명 조인하여 특정 일의 거래내역 조회
     * @param userId 사용자 아이디
     * @param date 조회할 날짜
     * @return Map 거래내역 목록
     */
    public Map<Integer, Map<String, Object>> getDailyTransactionWithCategory(int userId, Date date) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<Integer, Map<String, Object>> mapList = new HashMap<>();
        
        String sql = """
                select t.id, t.recurring_id, t.amount, t.description, t.transaction_type, c.name
                from transactions t
                join categories c on t.category_id = c.id
                where t.user_id = ?
                and t.transaction_date = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, date);
            rs = ps.executeQuery();
            
            Integer key = 0;
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map = new HashMap<>();
                map.put("id", rs.getInt("id"));
                map.put("recurringId", rs.getInt("recurring_id"));
                map.put("amount", rs.getInt("amount"));
                map.put("description", rs.getString("description"));
                map.put("transactionType", rs.getString("transaction_type"));
                map.put("categoryName", rs.getString("name"));
                mapList.put(++key, map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return mapList;
    }
    
    /**
     * 현재일까지의 수입 합계 조회
     * @param userId 사용자 아이디
     * @return amount 수입 합계
     */
    public int getIncomeSum(int userId) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select sum(amount) as amount
                from transactions
                where user_id = ? and transaction_date <= ? and transaction_type = 'income'
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
     * 현재일까지의 지출 합계 조회
     * @param userId 사용자 아이디
     * @return amount 지출 합계
     */
    public int getExpenseSum(int userId) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select sum(amount) as amount
                from transactions
                where user_id = ? and transaction_date <= ? and transaction_type = 'expense'
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
    public int getIncomeSumByMonth(int userId, int year, int month) {
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
    public int getExpenseSumByMonth(int userId, int year, int month) {
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
    public int getIncomeSumExpected(int userId, int year, int month) {
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
    public int getExpenseSumExpected(int userId, int year, int month) {
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
