package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    /*
     생성자에  @Autowired를 사용하면, 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입한다.
     생성자가 1개만 있으면, @Autowired는 생략할 수 있다.
     */
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(final Member member) {
        validateDuplicateMember(member);
        this.memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        this.memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }

    public Optional<Member> findOne(final Long memberId) {
        return this.memberRepository.findById(memberId);
    }
}
