package spring.core.discount;

import spring.core.member.Grade;
import spring.core.member.Member;

public class FIxDiscountPolicy implements DiscountPolicy{

    private int discounFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        //vip면 1000원
        if(member.getGrade() == Grade.VIP){
            return discounFixAmount;
        }else {
            return 0;
        }
    }
}
