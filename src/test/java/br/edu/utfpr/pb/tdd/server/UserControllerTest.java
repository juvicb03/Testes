package br.edu.utfpr.pb.tdd.server;

import br.edu.utfpr.pb.tdd.server.error.ApiError;
import br.edu.utfpr.pb.tdd.server.model.User;
import br.edu.utfpr.pb.tdd.server.repository.UserRepository;
import br.edu.utfpr.pb.tdd.server.shared.GenericResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    public static final String URL_USERS = "/users";
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void cleanup() {
        userRepository.deleteAll();
        testRestTemplate.getRestTemplate().getInterceptors().clear();
    }


    @Test
    @DisplayName("Post a valid user...")
    public void postUser_whenUserIsValid_receiveOk() {
        User user = createValidUser();
        ResponseEntity<Object> response =
                testRestTemplate.postForEntity(URL_USERS, user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postUser_whenUserIsValid_userSavedToDatabase() {
        User user = createValidUser();
        ResponseEntity<Object> response =
                testRestTemplate.postForEntity(URL_USERS, user, Object.class);
        assertThat( userRepository.count() ).isEqualTo( 1 );
    }

    @Test
    public void postUser_whenUserIsValid_receiveSuccesMessage() {
        User user = createValidUser();
        ResponseEntity<GenericResponse> response =
                testRestTemplate.postForEntity(URL_USERS, user, GenericResponse.class);

        assertThat( response.getBody().getMessage() ).isEqualTo( "Salvo com sucesso!" );
    }

    @Test
    public void postUser_whenUserIsValid_passwordIsHashedInDatabase() {
        User user = createValidUser();
        ResponseEntity<GenericResponse> response =
                testRestTemplate.postForEntity(URL_USERS, user, GenericResponse.class);


        List<User> userDB = userRepository.findAll();

        System.out.println(userDB.get(0).getPassword());
        assertThat( userDB.get(0).getPassword() ).isNotEqualTo( user.getPassword() );
    }

    @Test
    public void postUser_whenUserHasNullUsername_receiveBadRequest() {
        User user = createValidUser();
        user.setUsername(null);
        ResponseEntity<Object> response =
                testRestTemplate.postForEntity(URL_USERS, user, Object.class);

        assertThat( response.getStatusCode() )
                .isEqualTo( HttpStatus.BAD_REQUEST );
    }

    public <T> ResponseEntity<T> postSignup(Object request, Class<T> responseType) {
        return testRestTemplate.postForEntity(URL_USERS, request, responseType);
    }


    private User createValidUser() {
        User user = new User();
        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");
        return user;
    }
}
