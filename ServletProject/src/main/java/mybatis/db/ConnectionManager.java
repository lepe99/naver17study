package mybatis.db;

import java.io.IOException;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionManager {
    private static ConnectionManager instance;
    
    /**
     * ConnectionManager 객체를 생성하여 반환
     * @return ConnectionManager 객체
     */
    public static ConnectionManager getInstance() {
        if (instance == null)
            // ConnectionManager 객체를 생성하여 instance에 저장
            instance = new ConnectionManager();
        
        return instance;
    }
    
    // SqlSessionFactory: MyBatis의 핵심 클래스로 데이터베이스와의 연결과 SQL 실행에 대한 모든 기능을 가지고 있다.
    private SqlSessionFactory sqlSessionFactory;
    
    /**
     * ConnectionManager 생성자
     */
    private ConnectionManager() {
        String resource = "mybatis/db/Configuration.xml";
        try {
            // Configuration.xml 파일을 읽어서 SqlSessionFactory 객체를 생성
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Configuration.xml을 읽을 수 없습니다.", e);
        }
    }
    
    /**
     * SqlSession 객체를 생성하여 반환
     * @return SqlSession 객체
     */
    public SqlSession openSession() {
        // SqlSession: MyBatis의 핵심 클래스로 SQL 실행 메서드를 제공한다.
        return sqlSessionFactory.openSession(true);
    }
    
}