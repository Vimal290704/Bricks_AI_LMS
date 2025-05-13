package in.org.bricks.ai.lms.Bricks.repositories;

import in.org.bricks.ai.lms.Bricks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
