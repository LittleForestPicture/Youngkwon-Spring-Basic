package com.helloJava.core.order;

import com.helloJava.core.discount.DiscountPolicy;
import com.helloJava.core.discount.FixDiscountPolicy;
import com.helloJava.core.member.Member;
import com.helloJava.core.member.MemberRepository;
import com.helloJava.core.member.MemoryMemberRepository;
import com.helloJava.core.order.Order;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
