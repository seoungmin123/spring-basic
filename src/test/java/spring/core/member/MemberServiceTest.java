package spring.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.core.AppConfig;

class MemberServiceTest {

    MemberService memberService ;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member memberA = new Member(1L, "memberA", Grade.BASIC);

        //when
        memberService.join(memberA);
        Member findMemer = memberService.findMember(1L);

        //then
        Assertions.assertEquals(memberA, findMemer);

    }
}
