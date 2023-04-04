package hallo.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepositoy memberRepositoy = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepositoy.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepositoy.findById(memberId);
    }
}
