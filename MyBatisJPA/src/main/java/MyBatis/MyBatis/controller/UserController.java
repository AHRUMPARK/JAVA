package MyBatis.MyBatis.controller;


import MyBatis.MyBatis.dto.PersonDTO;
import MyBatis.MyBatis.service.MainService;
import MyBatis.MyBatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
//@RestController // UserController 안에 있는 모든 함수들이 @ResponseBody가 붙는것과 동일하다. 즉, rest api라고 알려주는 어노테이션
//@RequestMapping 메소드와 url을 따로 지정 (get,post가 나뉘기 전에 있던것)
//RequestMapping 아래 있는 주소에 모두 // @GetMapping("/person/register") 이런식으로 된다.
@RequestMapping("/person")
public class UserController {

    // 회원가입 객체 / 주입을 위한 Autowired
    @Autowired
    PersonService personService;

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }
    // axios 동적폼전송 요청을 보내고 받아야하니까 @ResponseBody => 결과를 리턴해주겠다라는 의미
    // dto를 받을 수 있게 but axios POST요청의 dto나 vo는 값을 받으려면, @RequsetBody를 써야합니다!
    @PostMapping("/register")
    @ResponseBody
    public String postRegister(@RequestBody PersonDTO personDTO){
        personService.insertPerson(personDTO);
        return "";
    }

    // 로그인
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    //
    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestBody PersonDTO personDTO){
        // 한명의 정보를 받아올것이라 getPerson에 dto정보를 전달 할 것임
       PersonDTO person =  personService.getPerson(personDTO);
        // 서비스에서 전달받은게 NULL이면..
        if (person == null) return false;
        else return true;
    }

    // 인포로 들어오고 dto에 값이 들어온다.
    @PostMapping("/info")
    //@RequestBody 빼줘야함 ! 이유 : 일반 폼전송이라서!!!!
    public String postInfo(PersonDTO personDTO, Model model){
        // 가져온 객체를 info에 전달
        PersonDTO person = personService.getPerson(personDTO);
        model.addAttribute("person", person);
        return "info";
    }

    @PostMapping("/info/edit")
    @ResponseBody
    public String  postInfoEdit(@RequestBody PersonDTO personDTO){
        //updatePerson > 서비스 > 매퍼한테 내가 전달받은 값을 전달하기만 하고 있다.
        personService.updatePerson(personDTO);
        return  "";
    }

    @PostMapping("/info/delete")
    @ResponseBody
    public String postInfoDelete(@RequestBody PersonDTO personDTO){
        personService.deletePerson(personDTO);
        return "";
    }
}
