package demo.userservice.home.repo;

import demo.userservice.home.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Modifying
    @Transactional
    // @Transactional nije obavezno u ovom slucaju.
    // Koristi se kada imas vise iskaza koje treba izvrsiti u batchu.
    // Ili izvrsi sve, ili se u slucaju neuspeha vrati na pocetak.
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
