package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/getUser")
    public User getUser(HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        return user;
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> loginInfo, HttpServletRequest req) { // RequestBody로 FE에서 보내는 JSON 데이터를 매핑
        HttpSession session = req.getSession();
        session.removeAttribute("user");   // 기존 session 값이 존재하는 error 해결
        User user = userRepository.findByEmailAndPassword(loginInfo.get("email"), loginInfo.get("password"));
        if(user != null) {
            session.setAttribute("user", user);
            return user;
        } else {
            return null;
        }
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
