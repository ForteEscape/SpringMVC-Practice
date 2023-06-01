package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@Slf4j
public class RequestBodyJsonController {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody = {}", messageBody);

        UserData data = objectMapper.readValue(messageBody, UserData.class);

        log.info("username = {}, age = {}", data.getUsername(), data.getAge());

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException{
        UserData data = objectMapper.readValue(messageBody, UserData.class);
        log.info("username = {}, age = {}", data.getUsername(), data.getAge());
        return "ok";
    }

    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody UserData userData) throws IOException{
        log.info("username = {}, age = {}", userData.getUsername(), userData.getAge());
        return "ok";
    }

    @PostMapping("/request-body-json-v4")
    public UserData requestBodyJsonV4(@RequestBody UserData userData) throws IOException{
        log.info("username = {}, age = {}", userData.getUsername(), userData.getAge());
        return userData;
    }
}
