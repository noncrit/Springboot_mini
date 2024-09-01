package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;
    
    //다른 곳에서 선언해도 같은 repository 객체를 사용하게 하기 위해 생성자로 선언
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    //단, 같은 이름의 회원은 가입 불가
    public Long join(Member member) {
        //이름 중복 회원 가입 불가
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        //조금 더 권장되는 형태(함수형 프로그래밍 형태)
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
