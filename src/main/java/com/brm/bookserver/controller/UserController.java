package com.brm.bookserver.controller;


import com.brm.bookserver.entity.Registration;
import com.brm.bookserver.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("registration")
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("code")
    public boolean onRegistration(@RequestBody Registration registration){
        if (userRepo.findByCode(registration.code).isPresent()){
            return false;
        }
        else {
            userRepo.save(registration);
            return true;
        }
    }

    @GetMapping("all")
    public ResponseEntity<List<Registration>> onAllCalled(){
        return ResponseEntity.ok().body(userRepo.findAll());
    }

    @PostMapping("complete")
    public boolean onDelete(@RequestParam("code") String code){
        if (userRepo.findByCode(code).isPresent()){
            Registration model = userRepo.findByCode(code).get();
            userRepo.delete(model);
            return true;
        }
        else {
            return false;
        }
    }
}
