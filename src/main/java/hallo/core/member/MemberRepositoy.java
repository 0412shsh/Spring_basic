package hallo.core.member;

public interface MemberRepositoy {

    //회원 저장
    void save(Member member);

    // 회원 찾기
    Member findById(Long memberId);
}
