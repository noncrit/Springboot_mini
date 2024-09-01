package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //인터페이스만 만들어놓으면 SpringData Jpa가 구현체를 알아서 만들어서 매핑함
    //구현체까지 알아서 만들어서 Bean으로 올리는 형태
    @Override
    Optional<Member> findByName(String name);
    //SQL 생성 규칙이 있음 - 인터페이스 이름으로 결정함
    //인터페이스 이름만으로 쿼리문 생성이 가능함

}
