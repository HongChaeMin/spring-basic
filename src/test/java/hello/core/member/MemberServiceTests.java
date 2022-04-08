package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTests {

    // !!!!! 실제 할당 부분이 구현제를 의존 !!!!!
    // !!!!! 구현 객체를 변경하려면 클라이언트 코드를 변경해야 한다 !!!!!
    // DIP 위반, OCP 위반
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
