// UserBalancesDao.java
package dao;

import dto.UserBalancesDto;
import util.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBalancesDao {
    MySQLConnect db = new MySQLConnect();
    
    /**
     * 사용자 잔액 정보 조회
     * @param userId 사용자 아이디
     * @return 사용자 잔액 정보
     */
    public int getUserBalance(int userId) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select current_balance
                from user_balances
                where user_id = ?
                """;
        
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("current_balance");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return 0;
    }
    
    /**
     * 사용자 현재 잔액 업데이트
     * TransactionDao의 getAmountSum을 이용하여 사용자의 거래내역 합계를 구하고
     * 사용자의 초기 잔액과 합산하여 업데이트
     * @param dto 사용자 잔액 정보
     */
    public void updateCurrentBalance(UserBalancesDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update user_balances
                set current_balance = ?
                where user_id = ?
                """;
        
        TransactionsDao transactionsDao = new TransactionsDao();
        int amount = transactionsDao.getAmountSum(dto.getUserId());
        int currentBalance = dto.getInitBalance() + amount;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, currentBalance);
            ps.setInt(2, dto.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    /**
     * 신규 사용자 잔액 추가
     * @param userId 사용자 아이디
     */
    public void insertUserBalance(int userId) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                insert into user_balances(user_id)
                values(?)
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    /**
     * user_balances 생성 위해 login_id로 user_id 조회
     * @param loginId 로그인 아이디
     * @return 사용자 아이디
     */
    public int getUserIdByLoginId(String loginId) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select user_id
                from users
                where login_id = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginId);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return 0;
    }
}
