package com.raisetechwork.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(@RequestParam("country") String country) {
        Date date = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat();

        switch (country) {
            case "jp":
                TimeZone timeZoneJP = TimeZone.getTimeZone("Asia/Tokyo");
                fmt.setTimeZone(timeZoneJP);
                return "こんにちは！" + fmt.format(date);

            case "us":
                TimeZone timeZoneUS = TimeZone.getTimeZone("America/Chicago");
                fmt.setTimeZone(timeZoneUS);
                return "Hello World from U.S.A" + fmt.format(date);

            default:
                return "Hello World";
        }


//        if (Objects.equals(country, "jp")) {
//            return "こんにちは！";
//        } else if (Objects.equals(country, "us")) {
//            return "Hello World from U.S.A";
//        } else {
//            return "Hello World";
//
//        }
    }
}