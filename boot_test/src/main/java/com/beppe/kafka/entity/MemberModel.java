package com.beppe.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MemberModel {

    private String data;
    private String channel;
    private String type;
    private String deviceId;
    private Long memberId;
}
