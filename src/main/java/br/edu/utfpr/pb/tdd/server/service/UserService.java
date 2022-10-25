package br.edu.utfpr.pb.tdd.server.service;


import br.edu.utfpr.pb.tdd.server.model.User;
import br.edu.utfpr.pb.tdd.server.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user) {
        user.setPassword( passwordEncoder.encode(user.getPassword()) );
        return userRepository.save(userRepository.save(user));
    }
}
