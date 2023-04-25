package MyBatis.MyBatis.repository;

import MyBatis.MyBatis.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // findByName => 이름으로 검색 name 으로 값을 보냇던것을 조건으로 건다.

    Optional<UserEntity> findByName(String name);
//
//    Optional<UserEntity> findById(int id);
//
//    Optional<UserEntity> findByName(int id, String name);
//    // select ~~ where name = #{name}; 으로 알아서 검색
//
//    boolean existsByName(String name);

    //UserEntity userEntity
    // 옵셔널이 null일수도있는 객체를 감싸는 클래스 => 자바에서 제일 많은 오류를 해결하기 위해 사용
    //Optional에는 null인지 아닌지를 확인할수있는 함수가 있음
    //Optional<UserEntity> user; user.get()
}
