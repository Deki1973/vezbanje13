package demo.userservice.home.repo;

import demo.userservice.home.model.User;
import org.apache.catalina.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE users SET role='ADMIN' WHERE id=:userId")
    int promoteUser(Long userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE users SET role='USER' WHERE id=:userId")
    int degradeUser(Long userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE users SET role=:userRole, active=:userActive WHERE id=:userId"
    )
    int updateUser(Long userId, Boolean userActive, String userRole);


}
