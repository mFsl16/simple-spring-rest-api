package com.faisal.restapi.dto;

import java.util.ArrayList;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseDto<T> {
    
    private boolean status;

    private List<String> message = new ArrayList<>();

    private T payload;

    public ResponseDto(boolean status, List<String> message, T payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
    }
}
