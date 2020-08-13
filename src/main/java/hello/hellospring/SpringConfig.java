package hello.hellospring;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.SpringDataJpaMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;

    @Autowired
    public SpringConfig(SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(this.springDataJpaMemberRepository);
    }

    //@Bean
    //public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(this.dataSource);
        //return new JdbcTemplateMemberRepository(this.dataSource);
        //return new JpaMemberRepository(this.em);

    //}

}
