package com.brm.bookserver.controller;

import com.brm.bookserver.entity.Admin;
import com.brm.bookserver.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("admin")
@RestController
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

    @PostMapping
    public boolean adminCheck(@RequestBody Admin admin){
        if (adminRepo.findAdminByUsernameAndPassword(admin.username, admin.password).isPresent()){
            return true;
        }
        else {
            return false;
        }
    }

    @PostMapping("create")
    public void adminCreate(@RequestBody Admin admin){
        adminRepo.save(admin);
    }

}
