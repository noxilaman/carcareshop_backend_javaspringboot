package com.noxilaman.carcareshop.business;


import com.noxilaman.carcareshop.entity.User;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.exception.UserException;
import com.noxilaman.carcareshop.mapper.UserMapper;
import com.noxilaman.carcareshop.model.MLoginReq;
import com.noxilaman.carcareshop.model.MUserReq;
import com.noxilaman.carcareshop.model.MUserRes;
import com.noxilaman.carcareshop.service.TokenService;
import com.noxilaman.carcareshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusiness {

    private final UserService userService;
    private final TokenService tokenService;
    private final UserMapper userMapper;

    public UserBusiness(UserService userService, TokenService tokenService, UserMapper userMapper) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.userMapper = userMapper;
    }

    public MUserRes create(MUserReq muserreq) throws BaseException{
        if (muserreq == null){
            throw UserException.userNull();
        }
        User user = userService.create(muserreq.getEmail(), muserreq.getPassword(), muserreq.getName());
        return userMapper.toMUserRes(user);
    }



    public String login(MLoginReq mLoginReq) throws BaseException{
        Optional<User> opt = userService.findByEmail(mLoginReq.getEmail());
        if(!opt.isPresent()){
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        if(!userService.matchPassword(mLoginReq.getPassword(),user.getPassword())){
            throw UserException.loginFailPasswordNotMatch();
        }



        String result = tokenService.tokenize(user);
        return result;
    }

    public Iterable<MUserRes> getAll() throws BaseException{
        return userMapper.mapListToMUserRes( userService.getAllUsers());
    }


}
