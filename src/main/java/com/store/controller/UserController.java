package com.store.controller;

import com.store.model.User;
import com.store.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User", description = "users crud operations")
public class UserController {

    @Autowired
    private UserService userService;

    @Secured("ROLE_ADMIN")
    @GetMapping
    @ApiOperation(value = "List of users")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(userService.list());
    }
}
