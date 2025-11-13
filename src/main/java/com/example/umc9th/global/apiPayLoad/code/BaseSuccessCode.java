package com.example.umc9th.global.apiPayLoad.code;

import org.springframework.http.HttpStatus;
// Spring 프레임워크가 기본으로 제공하는 HttpStatus 클래스를 가져옵니다.
// HttpStatus는 404 NOT_FOUND, 200 OK 같은 표준 HTTP 상태 코드를 모아둔 '열거형(Enum)'입니다.

public interface BaseSuccessCode {

    HttpStatus getStatus();
    // 규칙 1: "너는 반드시 HttpStatus (200, 404 등)를 반환할 수 있어야 해."
    // 역할: 클라이언트에게 실제 HTTP 응답 상태를 알려주기 위해 필요합니다.
    String getCode();
    // 규칙 2: "너는 반드시 String 형태의 고유한 '커스텀 코드'(MEMBER4001 등)를 반환할 수 있어야 해."
    // 역할: 클라이언트(앱) 개발자가 성공/에러의 원인을 if (code == "MEMBER4001")처럼 명확하게 분기 처리할 수 있도록 도와줍니다.
    String getMessage();
    // 규칙 3: "너는 반드시 String 형태의 **'설명 메시지'**를 반환할 수 있어야 해."
    // 역할: 클라이언트(앱)가 에러 팝업창 등에 "사용자를 찾을 수 없습니다."와 같은 메시지를 사용자에게 바로 보여줄 수 있게 합니다.
}
