package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        this.repository.save(member);

        Member findMember = this.repository.findById(member.getId()).orElse(null);

        assertThat(member).isEqualTo(findMember);
    }

}
