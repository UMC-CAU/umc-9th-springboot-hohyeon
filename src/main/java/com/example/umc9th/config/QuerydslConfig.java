package com.example.umc9th.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 1. 이 클래스가 Spring의 '설정 파일'임을 선언
public class QuerydslConfig {

    @PersistenceContext // 2. JPA의 EntityManager를 주입받기
    private EntityManager entityManager;

    @Bean // 3. 이 메서드가 반환하는 객체를 Spring Bean으로 등록
    public JPAQueryFactory jpaQueryFactory() {
        // 4. EntityManager를 넘겨주어 JPAQueryFactory를 생성하고 Bean으로 반환
        return new JPAQueryFactory(entityManager);
    }
}