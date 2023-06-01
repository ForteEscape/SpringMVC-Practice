package hello.springmvc.basic.request;

import hello.springmvc.basic.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ModelAttributeController {

    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(
            @RequestParam String username,
            @RequestParam int age
    ){
        UserData userData = new UserData();
        userData.setAge(age);
        userData.setUsername(username);

        log.info("controller = model-attribute-v1, userData = {}", userData.toString());

        return "ok";
    }

    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(@ModelAttribute UserData userData){
        log.info("controller = model-attribute-v2, userData = {}", userData.toString());

        return "ok";
    }

    @RequestMapping("/model-attribute-v3")
    public String modelAttributeV3(UserData userData){
        log.info("controller = model-attribute-v3, userData = {}", userData.toString());

        return "ok";
    }
}
