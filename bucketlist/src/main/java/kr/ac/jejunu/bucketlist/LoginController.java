package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository userRepository;
    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> loginInfo, HttpServletRequest req, Model model) { // RequestBody로 FE에서 보내는 JSON 데이터를 매핑
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
}
