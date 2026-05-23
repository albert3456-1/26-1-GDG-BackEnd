package com.example.shop.common.message;

public class ErrorMessage {
    //member 에러 메세지
    public static final String MEMBER_NOT_FOUND="회원을 찾을 수 없습니다.";
    public static final String MEMBER_ALREADY_EXISTS="이미 존재하는 로그인 아이디입니다:";

    //order 에러 메세지
    public static final String ORDER_NOT_FOUND="주문을 찾을 수 없습니다.";
    public static final String ORDER_ALREADY_EXISTS="이미 존재하는 주문입니다:";

    //product 에러 메세지
    public static final String PRODUCT_NOT_FOUND="싱품을 찾을 수 없습니다.";
    public static final String PRODUCT_ALREADY_EXISTS="이미 존재하는 상품입니다:";

    //dto에러-member
    public static final String LOGIN_ID_NOT_NULL="아이디는 필수사항입니다.";
    public static final String LOGIN_ID_SIZE="아이디는 최소 4글자, 최대 20글자 이내로 작성해야 합니다.";
    public static final String PASSWORD_NOT_NULL="비밀번호는 필수사항입니다.";
    public static final String PASSWORD_SIZE="비밀번호는 최소 8글자, 최대 20글자 이내로 작성해야 합니다.";
    public static final String PHONENUMBER_NOT_NULL="전화번호는 필수사항입니다.";
    public static final String PHONENUMBER_WRONG_PATTERN="전화번호는 010-xxxx-xxxx으로 입력해야 합니다.";
    public static final String ADDRESS_NOT_NULL="주소는 필수사항입니다.";
    public static final String ADDRESS_SIZE="주소는 최소 4글자, 최대 255글자 이내로 작성해야 합니다.";

    //dto에러-order
    public static final String ORDER_ID_NOT_NULL="오더 코드는 필수사항입니다.";
    public static final String ORDER_ID_SIZE="오더 코드는 최소 4글자, 최대 50글자 이내로 작성해야 합니다.";
    public static final String TOTAL_PRICE_NOT_NULL="최종 금액은 필수사항입니다.";
    public static final String TOTAL_PRICE_TOO_LOW="최종 금액은 최소 0원 이상이어야 합니다.";
    public static final String TOTAL_PRICE_TOO_HIGH="최종 금액은 최대 99999999원 이하이어야 합니다.";
    public static final String POINT_USED_NOT_NULL="포인트 사용량은 필수사항입니다.";
    public static final String POINT_USED_TOO_LOW="포인트 사용량은 최소 0원 이상이어야 합니다.";
    public static final String CASH_AMOUNT_NOT_NULL="현금 사용량은 필수사항입니다.";
    public static final String CASH_AMOUNT_TOO_LOW="현금 사용량은 최소 0원 이상이어야 합니다.";

    //dto에러-product
    public static final String NAME_NOT_NULL="이름은 필수사항입니다.";
    public static final String NAME_SIZE="이름은 최소 4글자, 최대 20글자 이내로 작성해야 합니다.";
    public static final String PRICE_NOT_NULL="가격은 필수사항입니다.";
    public static final String PRICE_TOO_LOW="가격은 최소 0원 이상이어야 합니다.";
    public static final String PRICE_TOO_HIGH="가격은 최대 99999999원 이하이어야 합니다.";
    public static final String AMOUNT_NOT_NULL="수량은 필수사항입니다.";
    public static final String AMOUNT_TOO_LOW="수량은 최소 0개 이상이어야 합니다.";
    public static final String AMOUNT_TOO_HIGH="수량은 최대 999999개 이하이어야 합니다.";
}
