package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class RequestParamController2 {
    @RequestMapping("request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age
    ){
        log.info("controller = request-param-require, username = {}, age = {}", username, age);

        return "ok";
    }

    @RequestMapping("request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age
    ){
        log.info("controller = request-param-default, username = {}, age = {}", username, age);

        return "ok";
    }

    @RequestMapping("request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap
    ){
        String username = (String) paramMap.get("username");
        Integer age = Integer.parseInt((String) paramMap.get("age"));

        log.info("controller = request-param-map, username = {}, age = {}", username, age);

        return "ok";
    }
}
