package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    //상품 리스트 보여 주기
    public List<Item> getList() {
        return itemRepository.findAll();
    }


    //상품 추가 하기
    public void saveItem(String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    //상품 상세 보기
    public Optional<Item> detailItem(Long id) {
        return itemRepository.findById(id);
    }

    //상품 수정하기
    public Item updateItem(Long id, String title, Integer price) {

            Item item = itemRepository.findById(id).get();
            item.setTitle(title);
            item.setPrice(price);
            return itemRepository.save(item);
  }
  //상품 삭제하기
    public void delete(Long id){
        Item item= itemRepository.findById(id).get();
         itemRepository.delete(item);
    }

}
