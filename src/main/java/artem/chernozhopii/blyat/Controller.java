package artem.chernozhopii.blyat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
public class Controller {


    private User user = null;


    @GetMapping("/")
    public String hello(){
        if (user == null){
        return "Баребух прив";}
        else  {
            return "Опять ты " + user.toString() + " мразь";
        }

    }
    @GetMapping("/bye")
    public String bye(){
        return "Баребух";
    }

    @PostMapping("/post")
    public String hiUser(@RequestBody String value){
        user = new User(value, LocalDate.now());
        return "Hi " + user.toString();
    }



}

class User{
    String name;
    LocalDate localDate;

    public User(String name, LocalDate localDate) {
        this.name = name;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return name;
    }
}
