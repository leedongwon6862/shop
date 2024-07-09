package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor //롬복 문법
public class ItemController {
    private final ItemRepository itemRepository;

    //쇼핑몰을 만들고싶으면  상품목록 페이지를 만들어야함

    @GetMapping("/list/test")
    public String listTest(Model model) {
        model.addAttribute("name", "이동원");
        return "list";
    }

/*    list 들어올때마다 똑같은 페이지만 보이면안됌 why? 쇼핑몰올때마다 다른상품있으니까 how?
    서버/Database의 데이터를 html 에 집어넣을수있다 ->템플릿엔진(타임리프 사용)
     ,html에 서버데이터 넣으려면 templates폴더에  .html 파일 넣어둬야함*/

    @GetMapping("/list")
    public String list(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
//        var a= new Item();
//        System.out.println(a.toString());
        return "list";
    }


}
