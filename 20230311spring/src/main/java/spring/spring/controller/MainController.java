package spring.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.spring.dto.Test9;
import spring.spring.dto.UserDTO;
import spring.spring.dto.UserVO;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
        public String main(){
            return "request";
        }
    @GetMapping("/get/response1")
    // @RequestParam넘어온 데이터가 name으로 온게 있으면 받아라,
    // 보낸것(name)과 같은 변수 이름(name)이어야 한다.
    // public String getAPI1(@RequestParam("name") String name2) > 넘어온 name이란 값을 name2라는 변수에 담는다.
    public String getAPI1(@RequestParam( value = "name", required = true ) String name2, Model model){
        model.addAttribute("name", name2);
        return "response";
    }

    @GetMapping("/get/response2")
    // name을 보내도되고, 안보내도된다 required = false
    public String getAPI2(@RequestParam( value = "name", required = false ) String name2, Model model){
        model.addAttribute("name", name2);
        return "response";
    }

    // /통해 값을 보내기 그 값을 name, age로 할당해라
    // PathVariable는 경로에 age라는 부분을 abc에 넣겟다. > @PathVariable("age") String abc,
    @GetMapping("/get/response3/{name}/{age}")
    public String getAPI3(@PathVariable String name, @PathVariable String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }

    @GetMapping({"/get/response4/{name}", "/get/response4/{name}/{age}"})
    public String getAPI4(@PathVariable String name, @PathVariable(value = "age", required = false) String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }

    // post 는 PostMapping
    @PostMapping("/post/response1")
    public String postAPI1(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return  "response";
    }

    @PostMapping("/post/response2")
    public String postAPI2(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name", name);
        return  "response";
    }

    // @ResponseBody
    @PostMapping("/post/response3")
    @ResponseBody // res.send
    public String postAPI3(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name", name);
        return  "이름은 : " + name ;
    }

     //실습 1번
    @GetMapping("/introduce/{name}")
    public String testAPI1(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "response";
    }

     //실습 1-2번
    @GetMapping("/introduce/{name}/{age}")
    public String testAPI1_2(@PathVariable String name, @PathVariable String age,  Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }

     //실습 2번
    @PostMapping("/test2")
    @ResponseBody
    public String testAPI2(@RequestParam ("name") String name,
                           @RequestParam ("gender") String gender,
                           @RequestParam ("yy") String yy,
                           @RequestParam ("mm") String mm,
                           @RequestParam ("dd") String dd,
                           @RequestParam ("like") String like
                           ,Model model){
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("birth", yy +"-"+ mm +"-"+ dd);
        model.addAttribute("like", like);

        return "이름 : " + name + "<br /> 성별 : " + gender +
                "<br /> 생년월일 : " + yy +"-"+ mm +"-"+ dd + "<br /> 관심사 : " + like;
//        return "response";
    }


    // DTO
//    @GetMapping("/dto/response1")
//    @ResponseBody // 뷰파일 없이 사용할 수 있음
//    public String dtoAPI1(UserDTO userDTO){
//        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!";
//        return msg;
//    }
//    @PostMapping("/dto/response2")
//    @ResponseBody // 뷰파일 없이 사용할 수 있음
//    public String dtoAPI2(UserDTO userDTO){
//        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!";
//        return msg;
//    }
//
//    @PostMapping("/dto/response3")
//    @ResponseBody // 뷰파일 없이 사용할 수 있음
//    // 오히려 위처럼 쓰면 그냥 된다..
//    // 일반 폼전송은 @RequestBody JSON형태가 아니면 오류가 나는 것
//    public String dtoAPI3(@RequestBody UserDTO userDTO){
//        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!";
//        return msg;
//    }

    // VO
    // 리드온니 속성이라 set을 쓸 수 없습니다!!!! 중요
    @GetMapping("/vo/response1")
    @ResponseBody
    public String voAPI1(UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "나이 : " + userVO.getAge();
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voAPI2(UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "나이 : " + userVO.getAge();
        return msg;
    }

    @PostMapping("/vo/response3")
    @ResponseBody
    //@RequestBody 데이터 JSON 형태 데이터를 자바 객체로 맵핑 시키는 역할
    public String voAPI3(@RequestBody UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "나이 : " + userVO.getAge();
        return msg;
    }

    // 실습7번 axios -dto
    @GetMapping("axios/response1")
    @ResponseBody
    public String axiosAPI1(@RequestParam (value="name") String name, @RequestParam(value = "age") String age){
        String msg = "이름 : " + name + "나이 : " + age;
        return msg;
    }

//    @GetMapping("axios/response2")
//    @ResponseBody
//    public String axiosAPI2(UserDTO userDTO){
//        String msg = "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();
//        return msg;
//    }

    @PostMapping("axios/response3")
    @ResponseBody
    public String axiosAPI3(@RequestParam(value = "name")String name, @RequestParam(value = "age")String age){
        String msg = "이름 : " + name + "나이 : " + age;
        return msg;
    }

//    @PostMapping("axios/response4")
//    @ResponseBody
//    public String axiosAPI4(UserDTO userDTO){
//        String msg = "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();
//        return msg;
//    }
//
//    @PostMapping("axios/response5")
//    @ResponseBody
//    public String axiosAPI5(@RequestBody UserDTO userDTO){
//        String msg = "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();
//        return msg;
//    }

//    실습8 aixos - vo
    @GetMapping("axios/vo/response1")
    @ResponseBody
    public String axiosVOAPI1(@RequestParam(value = "name")String name, @RequestParam(value = "age")String age){
        String msg = "이름 : " + name + "나이 : " + age;
        return msg;
    }

    @GetMapping("axios/vo/response2")
    @ResponseBody
    public String axiosVOAPI2(UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "나이 : " + userVO.getAge();
        return msg;
    }

    @PostMapping("axios/vo/response3")
    @ResponseBody
    public String axiosVOAPI3(@RequestParam(value = "name")String name, @RequestParam(value = "age")String age){
        String msg = "이름 : " + name + "나이 : " + age;
        return msg;
    }

    @PostMapping("axios/vo/response4")
    @ResponseBody
    public String axiosVOAPI4(UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "나이 : " + userVO.getAge();
        return msg;
    }

    @PostMapping("axios/vo/response5")
    @ResponseBody
    public String axiosVOAPI5(@RequestBody UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "나이 : " + userVO.getAge();
        return msg;
    }

    // 실습 9번 aixos 동적폼전송 실습
    @PostMapping("axios/test9")
    @ResponseBody
    public String axios_test9(@RequestBody Test9 test9){
        String msg = "이름 : " + test9.getName() + "나이 : " + test9.getGender() + "생년월일 : " + test9.getBrith() + "관심사 : " + test9.getLike();
        return test9.getName();
    }

    // 실습 10번 회원관리 시스템
    ArrayList<UserDTO> user = new ArrayList<UserDTO>();
    @PostMapping("axios/test10/join")
    @ResponseBody
    public String axios_test10_join(@RequestBody UserDTO userDTO ){
        user.add(userDTO);
        System.out.println(userDTO.getName());
        System.out.println(user.get(0));
        String msg = "회원 가입 완료";
        return msg;
    }

    @GetMapping("/LOGIN")
    public String login(){
        return "LOGIN";
    }
}