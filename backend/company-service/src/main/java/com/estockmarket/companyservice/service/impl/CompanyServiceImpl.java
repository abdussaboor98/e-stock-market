package com.estockmarket.companyservice.service.impl;

import org.springframework.stereotype.Service;

import com.estockmarket.companyservice.dto.CompanyDTO;
import com.estockmarket.companyservice.repo.CompanyRepo;
import com.estockmarket.companyservice.repo.SequenceRepo;
import com.estockmarket.companyservice.service.CompanyService;
import com.estockmarket.companyservice.util.RandomUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepo companyRepo;

    private SequenceRepo sequenceRepo;

    @Override
    public CompanyDTO registerNewCompany(CompanyDTO companyDto) {
        companyDto.setCompanyCode(generateNewCompanyCode(companyDto.getName()));
        log.info("Company Name: {} - New code: {}", companyDto.getName(), companyDto.getCompanyCode());
        return companyDto;
    }

    private String generateNewCompanyCode(String companyName) {
        StringBuilder newCodeBuilder = new StringBuilder();
        String[] nameSegments = companyName.toUpperCase().split("\s");
        newCodeBuilder.append(nameSegments[0].charAt(0));
        if(nameSegments.length > 1) {
            newCodeBuilder.append(nameSegments[1].charAt(0));
        } else {
            newCodeBuilder.append(RandomUtils.getRandomUpperCaseChar());
        }
        newCodeBuilder.append(String.format("%05d", sequenceRepo.getNextSequenceId(newCodeBuilder.toString())));
        return newCodeBuilder.toString();
    }
}