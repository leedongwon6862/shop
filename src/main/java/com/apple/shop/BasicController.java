package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "안녕하세요";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about(){
        return "싸이트 소개글 입니다.";
    }

    @GetMapping("/mypage")
    @ResponseBody
    public String mypage(){
        return "마이페이지 입니다.";
    }

    // 문자말고 html 보내주고싶을때
    @GetMapping("/html")
    @ResponseBody
    public String html(){
        return "<h4>html 로 보내드립니다.</h4>";
    }

    //보통 html 로 보낼때 길고 자동완성 안해주니깐  다른곳에 html 파일만들어두고 전송해줄수있다.
    @GetMapping("/send")
    public String send(){
        return "index";
    }

    //위 코드같은것들이 API 이다.



}
