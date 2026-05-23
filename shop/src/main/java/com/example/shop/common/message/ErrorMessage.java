package com.example.shop.common.message;

public class ErrorMessage {
    //member 로그인 에러 메세지
    public static final String MEMBER_NOT_FOUND="회원을 찾을 수 없습니다.";
    public static final String MEMBER_ALREADY_EXISTS="이미 존재하는 로그인 아이디입니다.";

    //dto에러
    public static final String LOGIN_ID_NOT_NULL="아이디는 필수사항입니다.";
    public static final String LOGIN_ID_SIZE="아이디는 최소 4글자, 최대 20글자 이내로 작성해야 합니다.";
    public static final String PASSWORD_NOT_NULL="비밀번호는 필수사항입니다.";
    public static final String PASSWORD_SIZE="비밀번호는 최소 8글자, 최대 20글자 이내로 작성해야 합니다.";
    public static final String PHONENUMBER_NOT_NULL="전화번호는 필수사항입니다.";
    public static final String PHONENUMBER_WRONG_PATTERN="전화번호는 010-xxxx-xxxx으로 입력해야 합니다.";
    public static final String ADDRESS_NOT_NULL="주소는 필수사항입니다.";
    public static final String ADDRESS_SIZE="주소는 최소 4글자, 최대 255글자 이내로 작성해야 합니다.";
}
