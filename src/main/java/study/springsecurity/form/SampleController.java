package study.springsecurity.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {
    /*
        누구나 접근 가능
        * 로그인 한 사용자와 로그인 안한 사용자를 구분하는 페이지
     */
    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if(principal.getName() == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Hello, " + principal.getName());
        }
        return "index";
    }
    /*
        누구나 접근 가능
     */
    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "Info");
        return "info";
    }
    /*
        로그인 사용자만 접근 가능
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "DashBoard" + principal.getName());
        return "dashboard";
    }
    /*
        Admin(로그인) 사용자만 접근 가능
     */
    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Admin" + principal.getName());
        return "admin";
    }
}
