package com.apple.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString // toString 함수 알아서 만들어줌 ->object (변수들)을 한눈에 보고싶을때
public class Item {
    //테이블에 어떤 새로줄(컬럼)이있을지 정해줘야한다.

    // @Column() 은 컬럼에 제약설정 가능. ->재시작해도 db에 반영안될수도있어 삭제하고 다시
    private   String title;
    private Integer price; //컬럼용 변수에는 int 보다는 Integer 강요
    //똑같은 이름 가격 이있으면 구별못하니 유니크한 번호 저장할 컬럼 만들기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //상품 저장할때마다 알아서 1씩증가
    private Long id;     //private 붙이면 getter ,setter 필요.

}
