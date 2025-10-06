package spring.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP일때 정률 할인 ")
    void vip_할인성공(){
        //given
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);

        //when
        int discountPrice = discountPolicy.discount(memberA, 10000);

        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC일때 할인 안됨")
    void basic_할인안됨(){
        //given
        Long memberId = 2L;
        Member memberB = new Member(memberId, "memberB", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(memberB, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}