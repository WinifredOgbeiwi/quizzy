package com.winningwithwynny.quizzy.service;

import com.winningwithwynny.quizzy.model.User;
import com.winningwithwynny.quizzy.repository.UserRepository;
import com.winningwithwynny.quizzy.request.UserRequest;
import com.winningwithwynny.quizzy.response.UserResponse;
import com.winningwithwynny.quizzy.support.user.UserExceptionSupplier;
import com.winningwithwynny.quizzy.support.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponse create(UserRequest userRequest){
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw UserExceptionSupplier.emailAlreadyExist(userRequest.getEmail()).get();
        }
        if(userRepository.existsByUsername(userRequest.getUsername())){
            throw UserExceptionSupplier.userAlreadyExist(userRequest.getUsername()).get();
        }
        User user = userRepository.save(userMapper.toUser(userRequest));
        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream().map(userMapper::toUserResponse).collect(Collectors.toList());
    }

    public UserResponse find(Long id){
        User user = userRepository.findById(id).orElseThrow(UserExceptionSupplier.userNotFound(id));
        return userMapper.toUserResponse(user);
    }




}
