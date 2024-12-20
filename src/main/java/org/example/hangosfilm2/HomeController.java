
package org.example.hangosfilm2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/home")
    public String user() {
        return "user";
    }
    @GetMapping("/admin/home")
    public String admin() {
        return "admin";
    }
    @GetMapping("/regisztral")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "regisztral";
    }
    @Autowired private UserRepository userRepo;
    @PostMapping("/regisztral_feldolgoz")
    public String Regisztráció(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "A regisztrációs email már foglalt!");
                return "reghiba";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_Vendeg");
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "regjo";
    }
    @GetMapping("/kapcsolat")
    public String kapcsolatForm(Model model) {
        model.addAttribute("kapcs", new Kapcsolat());
        return "kapcsolat";
    }
    @Autowired private KapcsolatRepository kapcsRepo;
    @PostMapping("/kapcsolat_feldolgoz")
    public String Kapcsolat(@ModelAttribute Kapcsolat kapcsolat, Model model) {
        int db=0;
        for (User felhasznalo3: userRepo.findAll())
            if (felhasznalo3.getEmail().equals(kapcsolat.getEmail()))
                db++;
        if (db==0) {
            model.addAttribute("üzenet", "A megadott email nem található");
            return "kapcs_hiba";
        }
        kapcsRepo.save(kapcsolat);
        model.addAttribute("id", kapcsolat.getId());
        return "kapcs_jo";
    }
}