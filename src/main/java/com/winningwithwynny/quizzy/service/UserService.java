package com.winningwithwynny.quizzy.service;

import com.winningwithwynny.quizzy.model.User;
import com.winningwithwynny.quizzy.repository.UserRepository;
import com.winningwithwynny.quizzy.request.UserRequest;
import com.winningwithwynny.quizzy.response.UserResponse;
import com.winningwithwynny.quizzy.support.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponse create(UserRequest userRequest){
        User user = userRepository.save(userMapper.toUser(userRequest));
        return userMapper.toUserResponse(user);
    }

}
