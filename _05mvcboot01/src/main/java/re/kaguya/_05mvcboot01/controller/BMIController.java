package re.kaguya._05mvcboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {
    @GetMapping("/bmi")
    @ResponseBody
    public String bmi(double s, double t) {
        double a = t / (s * s);
        if (a < 18.5) {
            return "偏瘦,bmi="+a;
        } else if(a < 24 && a > 18.5){
            return "正常,bmi="+a;
        } else if (a < 27 && a > 24) {
            return "偏胖,bmi="+a;
        } else if (a >= 27) {
            return "虎式坦克,bmi="+a;
        }
        return "404";
    }
}
