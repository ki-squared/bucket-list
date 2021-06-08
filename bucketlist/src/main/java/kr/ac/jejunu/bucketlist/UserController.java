package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("/loginCheck")
    public User login(@RequestBody String email, @RequestBody String password, HttpServletRequest req) {
        System.out.println(email);
        System.out.println(password);

        HttpSession session = req.getSession();
        User loginUser = userRepository.findByEmailAndPassword(email, password);
        System.out.println(loginUser);

        if(loginUser == null) {
            session.setAttribute("user", null);
        } else {
            session.setAttribute("user", loginUser);
        }

        return loginUser;
    }
}
