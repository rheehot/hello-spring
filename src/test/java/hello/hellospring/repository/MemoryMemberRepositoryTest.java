package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        this.repository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        this.repository.save(member);

        Member findMember = this.repository.findById(member.getId()).orElse(null);

        assertThat(member).isEqualTo(findMember);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        this.repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        this.repository.save(member2);

        Member findMember = this.repository.findByName("spring1").orElse(null);

        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        this.repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        this.repository.save(member2);

        List<Member> findMembers = this.repository.findAll();

        assertThat(findMembers.size()).isEqualTo(2);
    }

}
