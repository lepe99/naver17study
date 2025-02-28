package data.service;

import data.domain.Member;
import data.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    
    @Autowired
    MemberRepository memberRepository;
    
    public boolean checkId(String id) {
        return memberRepository.checkId(id) == 1;
    }
    
    public void insertMember(Member member) {
        memberRepository.insertMember(member);
    }
    
    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
    
    public void deleteMember(int num) {
        memberRepository.deleteMember(num);
    }
    
    public void deleteMembers(List<Integer> nums) {
        memberRepository.deleteMembers(nums);
    }
    
    public boolean loginCheck(String id, String passwd) {
        Map<String, String> map = Map.of("id", id, "passwd", passwd);
        return memberRepository.loginCheck(map) == 1;
    }
    
    public Member getMemberById(String id) {
        return memberRepository.getMemberById(id);
    }
    
    public Member getMemberByNum(int num) {
        return memberRepository.getMemberByNum(num);
    }
    
    public void updateImage(String image, int num) {
        Member member = new Member();
        member.setNum(num);
        member.setImage(image);
        memberRepository.updateImage(member);
    }
    
    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }
}
