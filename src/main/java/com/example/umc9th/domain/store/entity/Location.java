package com.example.umc9th.domain.store.entity;


import jakarta.persistence.*;
/*
import jakarta.persistence.*;:
**JPA(Java Persistence API)**의 핵심 기능들을 가져옵니다.
@Entity, @Id, @Column 등 데이터베이스와 관련된 대부분의 어노테이션이 여기에 포함되어 있습니다.
(javax.persistence.*에서 이름이 변경되었습니다.)
 */
import jakarta.persistence.criteria.Fetch;
import lombok.*;
/*
import lombok.*;:
Lombok 라이브러리의 기능들을 가져옵니다.
@Getter, @Builder 등 반복적인 코드를 줄여주는 어노테이션들이 포함되어 있습니다.
 */

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)

@Table(name = "location")

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
