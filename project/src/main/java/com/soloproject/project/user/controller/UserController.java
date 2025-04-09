package com.soloproject.project.user.controller;

import com.soloproject.project.user.entity.User;
import com.soloproject.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 유저 등록
    @PostMapping("/signup")
    public ResponseEntity<User> postUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    // 유저 수정
    @PutMapping("/{userId}")
    public ResponseEntity<User> putUser(@PathVariable Long userId, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(userId, user));
    }

    // 유저 조회 - 단건
    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    // 유저 조회 - 전체
    @GetMapping
    public ResponseEntity<List<User>> findAllFeed(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // 유저 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}