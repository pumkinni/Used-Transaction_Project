package com.example.usedtransaction.exception;

public class MemberException extends RuntimeException{
  private final ErrorCode errorCode;

  public MemberException(ErrorCode errorCode){
    super(errorCode.getDetail());
    this.errorCode = errorCode;
  }

}
