package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // 해결법 1. autowired에 명을 변경해준다
// @Qualifier("rateDiscountPolicy") // 해결법 2. @Qualifier 설정 후 생성자에 등록
@Primary // 해결법 3. 우선순위 설정
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * discountPercent / 100 : 0;
    }
}
