package com.apple.shop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item , Long> {

}
    // <엔티티명 , id 타입>
