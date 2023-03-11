package sesac.sesac.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
@Controller
public class HelloController {

    @GetMapping("/hi") // app.get url받았던 친구
    public String getHi(Model model){
        model.addAttribute("msg", "안녕하세용!");
        // utext
        model.addAttribute("utext", "<strong>부아앙.!</strong>");
        // value
        model.addAttribute("age", 6);
//        model.addAttribute("child", "<>");
        // res.render("hi", model); ejs파일에 데이터를 보내던것과 비슷한 역할이 model
        return "hi"; // res.render("hi") hi라는 파일은 리소스/템플릿 안에 위치해야함
    }

    @GetMapping("/people")
    public String getPesrson(Model model){

        ArrayList<Person> people = new ArrayList<Person>();
        // 내 오답
//        Person person1 = new Person("수남", 10);
//        Person person2 = new Person("박하", 3);
//        Person person3 = new Person("박밤", 1);
//        Person person4 = new Person("완이", 4);
        people.add(new Person("수남", 10));
        people.add(new Person("박하", 3));
        people.add(new Person("박밤", 1));
        people.add(new Person("완이", 4));

        model.addAttribute("people", people);
        return "person";
    }
}
