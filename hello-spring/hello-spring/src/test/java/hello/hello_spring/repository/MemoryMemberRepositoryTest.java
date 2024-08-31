package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {


    MemoryMemberRepository repository =  new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStroe();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        //Optional로 선언된 자료구조라서 .get()으로 꺼내와야함
        //테스트코드에서만 이렇게하기
        //대안 메소드 orElse 같은걸로 NULL 방지 필수

        Member result = repository.findById(member.getId()).get();
        /*
        junit.jupiter.api.Assertions 활용
        Assertions.assertEquals(member, result);
         */

        /*
        case Fail
        Assertions.assertEquals(member, null);
        */

        //org.assertj.core.api.Assertions
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //get() 이라서 꺼낼 수 있지만, get()은 테스트 코드에서만 쓸 것!
        Member result =  repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
