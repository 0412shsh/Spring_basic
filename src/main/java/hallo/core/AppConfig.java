package hallo.core;

import hallo.core.discount.DiscountPolicy;
import hallo.core.discount.FixDiscountPolicy;
import hallo.core.discount.RateDiscountPolicy;
import hallo.core.member.MemberRepositoy;
import hallo.core.member.MemberService;
import hallo.core.member.MemberServiceImpl;
import hallo.core.member.MemoryMemberRepository;
import hallo.core.order.OrderService;
import hallo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    } // 생성자 주입

    @Bean
    public MemberRepositoy memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService oderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

