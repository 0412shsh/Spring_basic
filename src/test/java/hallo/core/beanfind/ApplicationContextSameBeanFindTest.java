package hallo.core.beanfind;

import hallo.core.AppConfig;
import hallo.core.discount.DiscountPolicy;
import hallo.core.member.MemberRepositoy;
import hallo.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다. ")
    void findBeanByTypeDuplicate(){
        MemberRepositoy bean = ac.getBean(MemberRepositoy.class);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepositoy memberRepositoy1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepositoy memberRepositoy2(){
            return new MemoryMemberRepository();
        }

    }
}
