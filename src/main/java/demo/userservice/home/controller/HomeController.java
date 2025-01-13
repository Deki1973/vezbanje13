package demo.userservice.home.controller;

import demo.userservice.home.dto.UserDto;
import demo.userservice.home.model.User;
import demo.userservice.home.repo.UserRepo;
import demo.userservice.home.service.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    // proba proba
    @Autowired
    private UserSrv userSrv;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String hello(){
        return "hello world!";
    }

    @GetMapping("/getall")
    public List<User> getAll(){

       return userSrv.getAll();
    }

    @PutMapping("/upd/{id}")
    public int updateUser(@PathVariable Long id){
        System.out.println("pozvan je kontroller upadteUser");
        //return userRepo.promoteUser(id);
        return userSrv.promoteUser(id);

    }
    @PutMapping("/deg/{id}")
    public int degradeUser(@PathVariable Long id){
        System.out.println("pozvan je kontroler degrade user...");
        //return degradeUser(id);

        //return userRepo.degradeUser(id);
        return userSrv.degradeUser(id);
    }

    @PutMapping("/{id}")
    public int updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        System.out.println("pozvan je kontroller degradeUser");
        return userSrv.updateUser(id,userDto.getActive(),userDto.getRole());
       //return userRepo.updateUser(id,userDto.getActive(),userDto.getRole());



    }
}
