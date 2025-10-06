package spring.core.discount;

import spring.core.member.Member;

public interface DiscountPolicy {

    //retuen 할인 대상금액
    int discount(Member member, int price);
}
