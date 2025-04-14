package com.soloproject.project.user.service;

import com.soloproject.project.user.entity.User;
import com.soloproject.project.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 유저 생성
    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 암호화 추가
        return userRepository.save(user);
    }

    // 유저 수정
    @Transactional
    public User updateUser(Long userId, User updatedUser){
        User existingUser = getUser(userId);
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setNickname(updatedUser.getNickname());
        existingUser.setBio(updatedUser.getBio());
        return existingUser;
    }


    // 유저 조회 - 단일
    public User getUser(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with userId: " + userId));
    }

    // 유저 조회 - 단체
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 유저 삭제
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
