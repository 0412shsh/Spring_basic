package hallo.core;

import hallo.core.discount.DiscountPolicy;
import hallo.core.discount.FixDiscountPolicy;
import hallo.core.member.MemberRepositoy;
import hallo.core.member.MemberService;
import hallo.core.member.MemberServiceImpl;
import hallo.core.member.MemoryMemberRepository;
import hallo.core.order.OrderService;
import hallo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    } // 생성자 주입

    private MemberRepositoy memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService oderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}

