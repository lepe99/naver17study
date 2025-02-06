package dao;

import util.MySQLConnect;
import dto.UsersDto;
import util.PasswordHashingUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {
    MySQLConnect db = new MySQLConnect();
    
    // 사용자 추가 (회원가입)
    public void createUser(UsersDto user) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                insert into users(login_id, password, username, salt)
                values(?, ?, ?, ?)
                """;
        
        // salt 생성 뒤 기반으로 해싱된 비밀번호 생성
        String salt = PasswordHashingUtil.generateSalt();
        String hashedPassword = PasswordHashingUtil.hashPassword(user.getPassword(), salt);
        
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLoginId());
            ps.setString(2, hashedPassword);
            ps.setString(3, user.getUsername());
            ps.setString(4, salt);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    // 사용자 조회 (로그인)
    public UsersDto getUserByLoginId(String loginId) {
        Connection conn = db.getNCloudConnection();
        UsersDto user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select user_id, login_id, password, username, salt
                from users
                where login_id = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginId);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new UsersDto();
                user.setUserId(rs.getInt("user_id"));
                user.setLoginId(rs.getString("login_id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setSalt(rs.getString("salt"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return user;
    }
    
    // 비밀번호 검증
    public boolean validateUser(String loginId, String password) {
        UsersDto user = getUserByLoginId(loginId);
        if (user != null) {
            // 비밀번호 + salt 해싱
            String hashedPassword = PasswordHashingUtil.hashPassword(password, user.getSalt());
            // db의 값과 일치여부 확인
            return hashedPassword.equals(user.getPassword());
        }
        return false;
    }
}
