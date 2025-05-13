package in.org.bricks.ai.lms.Bricks.services.auth;

import in.org.bricks.ai.lms.Bricks.dtos.SignupRequest;
import in.org.bricks.ai.lms.Bricks.dtos.UserDto;

public interface AuthService {


    UserDto createUser(SignupRequest signupRequest);
}
