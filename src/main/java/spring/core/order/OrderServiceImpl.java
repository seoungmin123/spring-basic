package spring.core.order;

import spring.core.discount.DiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemoryMemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl (MemoryMemberRepository memberRepositor,DiscountPolicy discountPolicy){
        this.memberRepository = memberRepositor;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
