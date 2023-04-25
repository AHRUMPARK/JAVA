package MyBatis.MyBatis.domain;

import javax.persistence.*;

@Entity // 해당 클래스가 Entity 클래스라는 것을 알려준다.
@Table(name="user") // 테이블 이름 명시
public class UserEntity {

    //  @Id => private  int id;가 pk 키 // @GeneratedValue는 auto_increment와 같다.
    // id primary key auto_increment,
    @Id
    @GeneratedValue
    private  int id;

    @Column(length =20, nullable = false)
    // name varchar(20) not null
    private String name;

    @Column(length =20, nullable = false)
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
