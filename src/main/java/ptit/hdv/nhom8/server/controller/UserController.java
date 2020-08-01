package ptit.hdv.nhom8.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptit.hdv.nhom8.server.entity.UserEntity;
import ptit.hdv.nhom8.server.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity userEntity) {
        UserEntity userEntity2 = userRepository.getByUsername(userEntity.getUsername());
        if (userEntity2 != null && userEntity2.getPassword().equals(userEntity.getPassword()))
            return new ResponseEntity<UserEntity>(userEntity2, HttpStatus.OK);
        else return null;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserEntity userEntity) {
        UserEntity userEntity2 = userRepository.getByUsername(userEntity.getUsername());
        if (userEntity2 != null) {
            return "not ok";
        }
        try {
            userRepository.save(userEntity);
            return "ok";
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "not ok";
    }

    @PostMapping("/editProfile")
    public String editProfile(@RequestBody UserEntity userEntity) {
        try {
            System.out.println(userEntity);
            userRepository.save(userEntity);
            return "ok";
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "not ok";
    }
}
