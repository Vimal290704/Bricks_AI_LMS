package in.org.bricks.ai.lms.Bricks.services.auth;

import in.org.bricks.ai.lms.Bricks.dtos.SignupRequest;
import in.org.bricks.ai.lms.Bricks.dtos.UserDto;
import in.org.bricks.ai.lms.Bricks.entities.User;
import in.org.bricks.ai.lms.Bricks.enums.Gender;
import in.org.bricks.ai.lms.Bricks.enums.UserRole;
import in.org.bricks.ai.lms.Bricks.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(SignupRequest signupRequest){
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.STUDENT);
        User createdUser = userRepository.save(user);
        UserDto createduserDto = new UserDto();
        createduserDto.setId(createdUser.getId());
        createduserDto.setName(createdUser.getName());
        createduserDto.setEmail(createdUser.getEmail());
        createduserDto.setRole(createdUser.getRole());
        createduserDto.setPassword(createdUser.getPassword());
        return createduserDto;
    }
}
