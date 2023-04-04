package hallo.core.order;

import hallo.core.discount.DiscountPolicy;
import hallo.core.discount.FixDiscountPolicy;
import hallo.core.member.Member;
import hallo.core.member.MemberRepositoy;
import hallo.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService{

    private final MemberRepositoy memberRepositoy = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
      Member member = memberRepositoy.findById(memberId); // 회원정보 조회
      int discountPrice =  discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
