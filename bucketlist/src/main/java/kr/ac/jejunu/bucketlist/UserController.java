package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/getUser")
    public User getUser(HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        return user;
    }
}
