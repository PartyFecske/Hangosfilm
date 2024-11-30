package org.example.hangosfilm2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FilmController {
    // Dependency injection:
    @Autowired private FeladatRepo feladatRepo;
    @Autowired private FilmRepo filmRepo;
    @Autowired private SzemelyRepo szemelyRepo;
    @GetMapping("/filmek")
    public String Fooldal(Model model) {
        String str = A();
        model.addAttribute("str", str);
        return "filmek";
    }
    String A(){
        String str="";
        for(Feladat feladat : feladatRepo.findAll()){
            str+= feladat.getId()+"; "+ feladat.getFilmid()+"; "+ feladat.getSzemelyid()+"; "+feladat.getMegnevezes();
            str+="<br>";
        }
        str+="<br>";
        for(Film film : filmRepo.findAll()){
            str+= film.getId()+"; "+film.getCím()+"; "+ film.getGyártás()+"; "+ film.getHossz()+"; "+ film.getBemutató()+"; "+ film.getYoutube();
            str+="<br>";
        }
        str+="<br>";
        for(Szemely szemely : szemelyRepo.findAll()){
            str+= szemely.getId()+"; "+ szemely.getNév()+"; "+ szemely.getNem();
            str+="<br>";
        }
        return str;
    }
}