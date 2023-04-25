package MyBatis.MyBatis.service;


import MyBatis.MyBatis.domain.Person;
import MyBatis.MyBatis.dto.PersonDTO;
import MyBatis.MyBatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;
    //회원가입
    // 컨트롤러에서 이것을 실행할 수 있도록 객체를 만듭니다.
    public void insertPerson(PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setPw(personDTO.getPw());
        person.setName(personDTO.getName());

        personMapper.insertPerson(person);
    }

    // 컨트롤러에서 갑승ㄹ 받음
    public PersonDTO getPerson(PersonDTO personDTO){
        // 메퍼의 getPerson을 실행 시킬 것
        // 메퍼에서는 아이디와 pw를 받도록 하는 select문 만들기
      Person person =  personMapper.getPerson(personDTO.getId(), personDTO.getPw());

      //만약 검색 값이 없을 때
        if( person == null ) return null;
        // 값이 있을때 DTO에 담아서 DTO에 전달하는 코드
        PersonDTO info = new PersonDTO();
        info.setId(person.getId());
        info.setPw(person.getPw());
        info.setName(person.getName());
        info.setNickname(person.getId() + person.getName());

        return info;
    }

    public void updatePerson(PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setPw(personDTO.getPw());
        person.setName(personDTO.getName());

        personMapper.updatePerson(person);
    }

    public void deletePerson(PersonDTO personDTO){
        // 아이디를 전달받아서  deletePerson에 보내서 mapper 실행
        personMapper.deletePerson(personDTO.getId());
    }
}
