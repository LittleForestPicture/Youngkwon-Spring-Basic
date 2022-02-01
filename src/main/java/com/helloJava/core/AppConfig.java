package com.helloJava.core;

import com.helloJava.core.discount.DiscountPolicy;
import com.helloJava.core.discount.FixDiscountPolicy;
import com.helloJava.core.member.MemberService;
import com.helloJava.core.member.MemberServiceImpl;
import com.helloJava.core.member.MemoryMemberRepository;
import com.helloJava.core.order.OrderService;
import com.helloJava.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
