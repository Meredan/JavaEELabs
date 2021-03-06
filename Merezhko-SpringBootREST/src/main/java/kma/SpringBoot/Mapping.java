package kma.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Mapping {
   @RequestMapping("/")
    public String books() {
        return "addForm";
    }
}
