package com.helloJava.core;

import com.helloJava.core.member.Grade;
import com.helloJava.core.member.Member;
import com.helloJava.core.member.MemberService;
import com.helloJava.core.member.MemberServiceImpl;
import com.helloJava.core.order.Order;
import com.helloJava.core.order.OrderService;
import com.helloJava.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}