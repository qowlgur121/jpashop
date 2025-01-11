package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("테스트입니다")
    @Transactional
    @Rollback(value = false)
    public void testMember() {
        // given
        Member member = new Member();
        member.setUsername("배지혁");

        // when
        Long saveId = memberRepository.save(member);

        // then
        Member findMember = memberRepository.find(saveId);
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());

    }


}