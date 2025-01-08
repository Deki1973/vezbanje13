package demo.userservice.home.service;

import demo.userservice.home.dto.UserDto;
import demo.userservice.home.model.User;
import demo.userservice.home.repo.UserRepo;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UserSrv {

    //@Autowired
    private UserRepo userRepo;
    public UserSrv(UserRepo userRepo){
        this.userRepo=userRepo;
    }




    public List<User> getAll() {
        return userRepo.findAll();
    }

    public int promoteUser(Long id){
        return userRepo.promoteUser(id);
    }

    public int degradeUser(Long id){
        return userRepo.degradeUser(id);
    }

    public int updateUser(Long id, Boolean userActive, String userRole){
        return userRepo.updateUser(id,userActive,userRole);
    }
}
