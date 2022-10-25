package br.edu.utfpr.pb.tdd.server;

import br.edu.utfpr.pb.tdd.server.error.ApiError;
import br.edu.utfpr.pb.tdd.server.shared.GenericResponse;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void cleanup() {
        testRestTemplate.getRestTemplate().getInterceptors().clear();
    }


    public <T> ResponseEntity<T> postSignup(Object request, Class<T> responseType) {
        return testRestTemplate.postForEntity(URL_USERS, request, responseType);
    }

    /*
    private User createValidUser() {
        User user = new User();
        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");
        return user;
    }*/
}
