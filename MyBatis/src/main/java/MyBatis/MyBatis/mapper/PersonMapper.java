package MyBatis.MyBatis.mapper;

import MyBatis.MyBatis.domain.Person;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PersonMapper {


    @Insert("insert into person(id,pw,name) values(#{id}, #{pw}, #{name})")
    void insertPerson(Person person);

    // limit 1 한명만 찾겠다. => 여러명을 검색하면 list에 담겨오는데,
    // 한사람일 경우 Person이란 도메인에 한사람의 정보를 전달 받을 수 있다.
    @Select("select * from person where id=#{id} and pw=#{pw} limit 1")
    Person getPerson(String id, String pw);

    @Update("update person set pw=#{pw}, name=#{name} where id=#{id}")
    void updatePerson(Person person);

    // 메퍼로 > 서비스
    @Delete("delete from person where id=#{id}")
    void deletePerson(String id);
}
