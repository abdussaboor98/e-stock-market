package com.estockmarket.companyservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "sequence")
@Data
@Builder
public class SequenceId {
    @Id
    private String id;
    private long seq;
}
