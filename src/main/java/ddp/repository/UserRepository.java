package ddp.repository;

import ddp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Basic {@link User} repository class
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}