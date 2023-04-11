package hallo.core;

import hallo.core.discount.FixDiscountPolicy;
import hallo.core.member.MemberService;
import hallo.core.member.MemberServiceImpl;
import hallo.core.member.MemoryMemberRepository;
import hallo.core.order.OrderService;
import hallo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    } // 생성자 주입

    public OrderService oderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}

