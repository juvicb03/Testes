package br.edu.utfpr.pb.tdd.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
// @WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerUnitTest {
    /*
    public static final String URL_USERS = "/users";
    @Autowired
    MockMvc mvc;
    @MockBean
    UserService userService;
    @MockBean
    UserRepository userRepository;

    @Test
    public void postUser_whenUserIsValid_receiveOk() throws Exception {
        User user = createValidUser();
        User savedUser = User.builder().username("test-user").displayName("test-display").password("P4ssword").build();

        BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(savedUser);
        String json = new ObjectMapper().writeValueAsString(user);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(URL_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc
            .perform(request)
            .andExpect( status().isOk() )
            .andExpect( jsonPath("message").value("Registro salvo.") );
    }

    private User createValidUser() {
        return User.builder()
                    .username("test-user")
                    .displayName("test-display")
                    .password("P4ssword").build();
    }
     */

}
