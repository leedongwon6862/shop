package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor //롬복 문법
public class ItemController {
    private final ItemService itemService;

    //쇼핑몰을 만들고싶으면 먼저 상품목록 페이지를 만들어야함

    @GetMapping("/list/test")
    public String listTest(Model model) {
        model.addAttribute("name", "이동원");
        return "list";
    }

/*    list 들어올때마다 똑같은 페이지만 보이면안됌 why? 쇼핑몰올때마다 다른상품있으니까 how?
    서버/Database의 데이터를 html 에 집어넣을수있다 ->템플릿엔진(타임리프 사용)
     ,html에 서버데이터 넣으려면 templates폴더에  .html 파일 넣어둬야함*/

    //상품 목록 보이기
    @GetMapping("/list")
    public String list(Model model) {
        List<Item> itemList = itemService.getList();
        model.addAttribute("itemList", itemList);
//        var a= new Item();
//        System.out.println(a.toString());
        return "list";
    }

    //상품 추가 폼 보이기
    @GetMapping("/write")
    public String write(){
        return "write";
    }

    //상품 추가 하기
    @PostMapping("/add")
    public String addPost(@RequestParam String title ,@RequestParam Integer price){
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    //상품 상세 보기
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id , Model model) {
        Optional<Item> item = itemService.detailItem(id);
        if(item.isPresent()) {
            model.addAttribute("item" ,item.get());
        }else{
            return "redirect:/list";

        }
        return "detail";
    }

    //상품 수정 폼
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")Long id , Model model){
        Item item = itemService.detailItem(id).get();
        model.addAttribute("item" ,item);
        return "update";
    }


    //상품 수정 하기
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id")Long id ,String title, Integer price){
        itemService.updateItem(id,title ,price);
      return "redirect:/list";
    }


    //상품 삭제 폼
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id ,Model model){
        Item item  = itemService.detailItem(id).get();
        model.addAttribute("item" , item);
        return "delete";
    }


    //상품 삭제 하기
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id  ){
        itemService.delete(id);
        return "redirect:/list";
    }


}
