package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    //DB가 알아서 생성하는 방식 = identity
    //PrimaryKey 설정
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
