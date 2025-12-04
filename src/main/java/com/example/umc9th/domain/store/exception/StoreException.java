package com.example.umc9th.domain.store.exception;

import com.example.umc9th.global.apiPayLoad.code.BaseErrorCode;
import com.example.umc9th.global.apiPayLoad.exception.GeneralException;

public class StoreException extends GeneralException {
    public StoreException(BaseErrorCode code) {
        super(code);
    }
}
