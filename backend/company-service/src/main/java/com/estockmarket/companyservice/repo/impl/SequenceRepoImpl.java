package com.estockmarket.companyservice.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.estockmarket.companyservice.entity.SequenceId;
import com.estockmarket.companyservice.repo.SequenceRepo;

@Repository
public class SequenceRepoImpl implements SequenceRepo {

    @Autowired
    private MongoOperations operations;

    @Override
    public long getNextSequenceId(String sequenceKey) {
        Query query = new Query(Criteria.where("_id").is(sequenceKey));
        Update update = new Update().inc("seq", 1);
        FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(Boolean.TRUE).upsert(Boolean.TRUE);
        SequenceId sequenceId = operations.findAndModify(query, update, options, SequenceId.class);
        if(sequenceId != null)
            return sequenceId.getSeq();
        else return 1;
    }
    
}
