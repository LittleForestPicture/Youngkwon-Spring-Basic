package com.helloJava.core;

import com.helloJava.core.discount.FixDiscountPolicy;
import com.helloJava.core.member.MemberService;
import com.helloJava.core.member.MemberServiceImpl;
import com.helloJava.core.member.MemoryMemberRepository;
import com.helloJava.core.order.OrderService;
import com.helloJava.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
