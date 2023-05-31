package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("call hello basic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("call get mapping function");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("call get mapping function version 2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath = {}", data);
        return "ok";
    }

    @GetMapping("/mapping/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath, userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    // 조건부 - 쿼리 파라미터
    @GetMapping(value = "/mapping-param?mode=debug", params = "mode=debug")
    public String mappingParam(){
        log.info("statement is true");
        return "ok";
    }

    // 조건부 - 요청 헤더
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("header statement is true");
        return "ok";
    }

    // Content-Type 이 일치할 때만 가능
    @PostMapping(value = "mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(){
        log.info("consume type statement is true");
        return "ok";
    }

    // Accept header 가 일치할 때만 가능
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

}
