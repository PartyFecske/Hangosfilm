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
        String[] str = A();
        model.addAttribute("str", str);
        return "filmek";
    }
    String[] A(){
        String str1="";
        String str2="";
        String str3="";
        for(Feladat feladat : feladatRepo.findAll()){
            str1+= feladat.getId()+"; "+ feladat.getFilmid()+"; "+ feladat.getSzemelyid()+"; "+feladat.getMegnevezes();
            str1+="<br>";
        }
        //str+="<br>";
        for(Film film : filmRepo.findAll()){
            str2+= film.getId()+"; "+film.getCím()+"; "+ film.getGyártás()+"; "+ film.getHossz()+"; "+ film.getBemutató()+"; "+ film.getYoutube();
            str2+="<br>";
        }
        //str+="<br>";
        for(Szemely szemely : szemelyRepo.findAll()){
            str3+= szemely.getId()+"; "+ szemely.getNév()+"; "+ szemely.getNem();
            str3+="<br>";
        }
        String[] str={str1, str2, str3};
        System.out.println(str.length);
        return str;
    }
}