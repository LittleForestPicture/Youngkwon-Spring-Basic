package com.helloJava.core;

import com.helloJava.core.member.Grade;
import com.helloJava.core.member.Member;
import com.helloJava.core.member.MemberService;
import com.helloJava.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}