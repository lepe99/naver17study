package data.repository;

import data.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberRepository {
    
    /**
     * id 중복 검사
     * @param id 검사할 id
     * @return 중복되는 id가 있으면 1, 없으면 0
     */
    int checkId(String id);
    
    /**
     * 회원 가입
     * @param member 회원 정보
     */
    void insertMember(Member member);
    
    /**
     * 모든 회원 조회 (관리자)
     * @return 모든 회원 정보
     */
    List<Member> getAllMembers();
    
    /**
     * 회원 정보 삭제
     * @param num 삭제할 회원 번호
     */
    void deleteMember(int num);
    
    /** 선택한 회원 정보 삭제
     * @param nums 삭제할 회원 번호
     */
    void deleteMembers(List<Integer> nums);
    
    /**
     * 로그인 유효 조회
     * @param map 로그인 정보
     * @return 로그인 성공 시 1, 실패 시 0
     */
    int loginCheck(Map<String, String> map);
    
    /**
     * 회원 정보 조회
     * @param id 조회할 회원 id
     * @return 회원 정보
     */
    Member getMemberById(String id);
    
    /**
     * 회원 정보 조회 (회원번호)
     * @param num 조회할 회원 번호
     * @return 회원 정보
     */
    Member getMemberByNum(int num);
    
    /**
     * 회원 이미지 변경
     * @param member 회원 정보
     */
    void updateImage(Member member);
    
    /**
     * 회원 정보 변경
     * @param member 변경할 회원 정보
     */
    void updateMember(Member member);
}
