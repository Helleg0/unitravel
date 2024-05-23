package com.example.user_service.services;

import com.example.user_service.model.dtos.UserRequest;
import com.example.user_service.model.dtos.UserResponse;
import com.example.user_service.model.entities.User;
import com.example.user_service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class    UserService {

    private  final UserRepository userRepository;
    public void addUser(UserRequest userRequest){
        var user = User.builder()
                .id(userRequest.getId())
                .idRol(userRequest.getId_rol())
                .name(userRequest.getName())
                .document(userRequest.getDocument())
                .address(userRequest.getAddress())
                .phone(userRequest.getPhone()).build();

        userRepository.save(user);

        log.info("user added: {}",user);
    }

    public List<UserResponse> getAllUsers(){
        var users = userRepository.findAll();

        return users.stream().map(this::mapToUserResponse).toList();
    }

    private UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .id_rol(user.getIdRol())
                .name(user.getName())
                .document(user.getDocument())
                .address(user.getAddress())
                .phone(user.getPhone())
                .build();
    }

    public void updateUser(UserRequest userRequest){
        Optional<User> optionalUser = userRepository.findById(userRequest.getId());

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setIdRol(userRequest.getId_rol());
            user.setName(userRequest.getName());
            user.setDocument(userRequest.getDocument());
            user.setAddress(userRequest.getAddress());
            user.setPhone(userRequest.getPhone());

            userRepository.save(user);

            log.info("User updated: {}", user);

        }else {
            log.error("User with ID {} not found", userRequest.getId());
        }
    }

    public void deleteUser(Long userId){

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()){
            userRepository.deleteById(userId);
        }else {
            throw new NoSuchElementException("User with ID"+userId+"not found");
        }
    }
}
