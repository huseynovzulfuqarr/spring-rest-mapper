package com.example.springmodelmapper.service;

import com.example.springmodelmapper.dto.UserRequestDto;
import com.example.springmodelmapper.dto.UserResponseDto;
import com.example.springmodelmapper.entity.User;
import com.example.springmodelmapper.exception.UserNotFoundException;
import com.example.springmodelmapper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponseDto get(Long id){
        User user=this.userRepository.findById(id).orElseThrow(()->new UserNotFoundException());
        return modelMapper.map(user,UserResponseDto.class);
    }

    public UserResponseDto create(UserRequestDto userRequestDto){
        User user=modelMapper.map(userRequestDto,User.class);
        return modelMapper.map(this.userRepository.save(user),UserResponseDto.class);
    }

    public UserResponseDto update(Long id,UserRequestDto userRequestDto){
        User user=this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
       modelMapper.map(userRequestDto, user);
       this.userRepository.save(user);
       return modelMapper.map(user,UserResponseDto.class);
    }

    public void delete(Long id){
        this.userRepository.deleteById(id);
    }


}
