package com.noxilaman.carcareshop.api;

import com.noxilaman.carcareshop.business.UserBusiness;
import com.noxilaman.carcareshop.entity.User;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.model.MLoginReq;
import com.noxilaman.carcareshop.model.MUserReq;
import com.noxilaman.carcareshop.model.MUserRes;
import com.noxilaman.carcareshop.repository.UserRepository;
import com.noxilaman.carcareshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserBusiness userBusiness;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;


    public UserApi(UserBusiness userBusiness, UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.userBusiness = userBusiness;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/")
    public @ResponseBody Iterable<MUserRes> getallusers() throws BaseException{
        return userBusiness.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<MUserRes> create(@RequestBody MUserReq mUserReq) throws BaseException{

        MUserRes result = userBusiness.create(mUserReq);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MLoginReq mLoginReq) throws BaseException{

        String result = userBusiness.login(mLoginReq);

        return ResponseEntity.ok(result);
    }

    @GetMapping(path="/addnew")
    public ResponseEntity<String> newuser() {
        User user = new User();
        user.setId(null);
        user.setEmail("pong@test.com");
        user.setPassword(passwordEncoder.encode("12345678"));
        user.setName("Pong");
        userRepository.save(user);
        return ResponseEntity.ok("SAVE");
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<String> refreshToken() throws BaseException {
        String response = userBusiness.refreshToken();
        return ResponseEntity.ok(response);
    }
}
