package com.example.springmodelmapper.controller;

import com.example.springmodelmapper.dto.UserRequestDto;
import com.example.springmodelmapper.dto.UserResponseDto;
import com.example.springmodelmapper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.userService.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createStudent(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(this.userService.create(userRequestDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateStudent(@PathVariable("id") Long id,
                                                         @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(this.userService.update(id, userRequestDto));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable("id") Long id){
        this.userService.delete(id);
    }


}
