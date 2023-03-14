package MyBatis.MyBatis.service;

import MyBatis.MyBatis.domain.User;
import MyBatis.MyBatis.dto.UserDTO;
import MyBatis.MyBatis.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    private MainMapper mainMapper;

    public List<UserDTO> getUserList() {
        // db와 연결된 mainMapper > xml 파일에서 값 가져오기
        List<User> result = mainMapper.retrieveAll();
        List<UserDTO> users = new ArrayList<UserDTO>();

        // db에서 가져온 User 값을 UserDTO 객체인 users 에 넣고있다.
        for (int i = 0; i < result.size(); i++) {
            UserDTO user = new UserDTO();
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setNickname(result.get(i).getNickname());
            user.setNo(i + 1);

            users.add(user);
        }
        return users;
    }

//    public List<UserDTO> getUserName(){
//        List<User> result = mainMapper.selectName();
//        List<UserDTO> users = new ArrayList<UserDTO>();
//
//        UserDTO user = new UserDTO();
//        user.setId(result.get(0).getId());
//        user.setNickname(result.get(0).setNickname(nickname));
//
//        return users;
//    }

    // mainMapper의 insertUser는 @Insert sql문을 실행하는 것
    // db에서 받아온 User란 값을 변수 user에 넣고, MainMapper의 @insert sql문을 실행한다. > name과 nickname을 user테이블에 추가
    public void addUser(User user) { mainMapper.insertUser(user);}

    public void editUser(User user) { mainMapper.updateUser(user);}

    public void deleteUser(User user) { mainMapper.deleteUser(user);}
}
