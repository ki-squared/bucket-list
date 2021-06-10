package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/getName")
    public String getName(HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        return user.getName();
    }
}
