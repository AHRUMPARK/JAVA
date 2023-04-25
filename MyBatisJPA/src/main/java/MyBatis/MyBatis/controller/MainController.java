package MyBatis.MyBatis.controller;

import MyBatis.MyBatis.domain.User;
import MyBatis.MyBatis.domain.UserEntity;
import MyBatis.MyBatis.dto.UserDTO;
import MyBatis.MyBatis.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/users")
    // 1. 메인 서비스 getusers()실행 > mainMapper.retrieveAll() > 메인메퍼 안 List<User> retrieveAll(); retrieveAll과 연결되어있는 xml 파일 안에 sql문을 실행 시킴
    // namespace에 select id="retrieveAll 인 얘를 찾는다.
    // 서비스에서 getUserList
    public String getusers(Model model) {
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getUserList();
        model.addAttribute("list", userList);
        return "user";
    }

    @GetMapping("/user/insert")
    public  String getInsertUser(@RequestParam String name, @RequestParam String nickname, Model model){
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setNickname(nickname);

        mainService.addUser(user);

        model.addAttribute("inName", name);
        model.addAttribute("list", null);
        return "user";
    }

    @GetMapping("/user")
    public String getUpdateUser(@RequestParam  String name, Model model){
        ArrayList<UserDTO> userList = mainService.getUserName(name);

        model.addAttribute("list", userList);
        return "user";
    }

    @GetMapping("/user/update")
    public String getUpdateUser(@RequestParam int id, @RequestParam String name, @RequestParam String nickname, Model model){
        User user = new User();
        user.setName(name);
        user.setId(id);
        user.setNickname(nickname);

        mainService.editUser(user);

        model.addAttribute("upName", name);
        return "user";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam int id, Model model){
        User user = new User();
        user.setId(id);

        mainService.deleteUser(user);

        model.addAttribute("id", id);
        return "user";
    }
}

