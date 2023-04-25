package MyBatis.MyBatis.mapper;

import MyBatis.MyBatis.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MainMapper {

    // mapper 참고하기 > MainMapper.xml 을 참고해라
    List<User> retrieveAll();

    List<User> selectName();

    // 인설트 유저를 실행할 때 위에있는 sql문 실행
    // #{name}과 전달받은 User 객체가 맵핑 되어 셋한 값이 들어가게 될 것
    // mybatis에 있는 @Insert 뒤에있는 문장이 sql문이라고 알려주는 어노테이션입니다.
    @Insert("insert into user(name, nickname) values(#{name}, #{nickname})")
    // 유저라는 객체를 받아서
    void  insertUser(User user);

    // 업데이트
    @Update("update user set name = #{name}, nickname = #{nickname} where id = #{id}")
    void updateUser(User user);

    // 삭제
    @Delete("delete from user where id = #{id}")
    void deleteUser(User user);
}
