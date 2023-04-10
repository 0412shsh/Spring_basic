package hallo.core.member;

public class MemberServiceImpl implements MemberService{

 //private final MemberRepositoy memberRepositoy = new MemoryMemberRepository();
    private final MemberRepositoy memberRepositoy; // 인터페이스만 존재 , 추상화 !!

    // 생성자 주입
    public MemberServiceImpl(MemberRepositoy memberRepositoy) {
        this.memberRepositoy = memberRepositoy;
    }

    @Override
    public void join(Member member) {
        memberRepositoy.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepositoy.findById(memberId);
    }
}
