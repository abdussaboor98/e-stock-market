package com.estockmarket.companyservice.repo;

public interface SequenceRepo {
    
    long getNextSequenceId(String sequenceKey);
}
