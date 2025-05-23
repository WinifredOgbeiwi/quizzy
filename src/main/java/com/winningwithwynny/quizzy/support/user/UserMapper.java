package com.winningwithwynny.quizzy.support.user;

import com.winningwithwynny.quizzy.model.User;
import com.winningwithwynny.quizzy.request.UserRequest;
import com.winningwithwynny.quizzy.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserRequest userRequest){
        return new User(userRequest.getUsername(),userRequest.getEmail(),userRequest.getPassword(), userRequest.getInstitution(), userRequest.getSemester(),userRequest.getPicture());
    }

    public UserResponse toUserResponse(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(),user.getInstitution(),user.getSemester(),user.getPicture());
    }

}
