package hallo.core;

import hallo.core.member.Grade;
import hallo.core.member.Member;
import hallo.core.member.MemberService;
import hallo.core.member.MemberServiceImpl;
import hallo.core.order.Order;
import hallo.core.order.OrderService;
import hallo.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"ItemA",10000);

        System.out.println("order = "+order);
    }
}
