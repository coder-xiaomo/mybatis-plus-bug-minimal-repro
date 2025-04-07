package com.example.backend.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.backend.common.Error.BusinessErrorCode;
import com.example.backend.common.Error.BusinessException;
import com.example.backend.common.Response.CommonReturnType;
import com.example.backend.controller.base.BaseController;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class DemoController extends BaseController {

    @Resource
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/test")
    public CommonReturnType test() {
        List<User> userList = userServiceImpl.getUserList();
        List<UserDTO> collect = UserDTO.fromEntity(userList);
        return CommonReturnType.create(collect);
    }

    @RequestMapping("/testError")
    public CommonReturnType testError() {
        return CommonReturnType.create(0 / 0);
    }

    @RequestMapping("/testBusinessError")
    public CommonReturnType testBusinessError() throws BusinessException {
        throw new BusinessException(BusinessErrorCode.UNKNOWN_ERROR, "error");
    }

    @RequestMapping("/issue")
    public CommonReturnType issue() {
        CompletableFuture.runAsync(() -> {
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setId(IdWorker.getId());
                user.setUsername(Math.random() + "");
                user.setPassword(Math.random() + "");
                userList.add(user);
            }
            userServiceImpl.saveBatch(userList);
        }).whenComplete((result, ex) -> {
            ex.printStackTrace();
        });
        return CommonReturnType.create(null);
    }
}
