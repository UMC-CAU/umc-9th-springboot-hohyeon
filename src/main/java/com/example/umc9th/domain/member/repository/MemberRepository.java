package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberById(Long id);
    /*
    JPA는 ORM(Object-Relational Mapping), 즉 데이터베이스의 레코드(Row)와 Java의 객체(Object)를 1:1로 매핑하는 기술.
    findById의 임무는 "ID가 ...인 레코드를 찾아서, 완벽한 Member 객체 1개를 만들어라"
    완벽한 Member 객체를 만들기 위해서는 nickname, email 등 모든 필드에 값이 채워져 있어야 한다.
    따라서 JPA는 findById(1L)를 호출하면, 내부적으로 아래와 같은 SQL을 자동으로 생성하여 실행.
     */
}
