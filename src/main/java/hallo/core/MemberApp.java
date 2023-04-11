package hallo.core;

import hallo.core.member.Grade;
import hallo.core.member.Member;
import hallo.core.member.MemberService;
import hallo.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        // MemberService 인터페이스 받아오기
        // ==> 생성자로 Impl를 생성해서 MemberService안에는 MemberServiceImpl가 들어가 있음
        // MemberServiceImpl를 만들고 나는 MemoryMemberRepository를 사용할거야라고 주입 !
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        // 기존에는 MemberApp의 메인메서드에서 ServiceImpl을 직접 생성해주었음
        // MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = "+member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
