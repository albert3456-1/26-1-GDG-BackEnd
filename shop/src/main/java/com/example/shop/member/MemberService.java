package com.example.shop.member;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeInvisAnnos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //@Transtional
    public long createMember(MemberCreateRequest request){
        Member existingMember=memberRepository.findByLoginId(request.getLoginId());
        if( existingMember!=null){
            throw new RuntimeException("이미 존재하는 로그인 아이디입니다: "+request.getLoginId());
        }
        Member member=new Member(
                request.getLoginId(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getAddress()
        );
        memberRepository.save(member);

        return member.getId();
    }
    //@Transtional(readOnly=True)
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }
    //@Transtional(readOnly=True)
    public Member getMemberById(Long id) {
        Member member =memberRepository.findById(id);
        if (member==null){
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }
        return member;
    }
    //@Transtional
    public void updateMember(Long id, MemberUpdateRequest request){
        Member member=memberRepository.findById(id);
        if (member==null){
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }
        member.updateInfo(request.getPassword(),request.getPhoneNumber(),request.getAddress());
    }
    //@Transtional
    public void deletMember(Long id){
        Member member=memberRepository.findById(id);
        if (member==null){
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }
        memberRepository.deleteById(id);
    }
}
