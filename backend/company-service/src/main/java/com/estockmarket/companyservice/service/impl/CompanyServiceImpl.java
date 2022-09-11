package com.estockmarket.companyservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estockmarket.companyservice.dto.CompanyDTO;
import com.estockmarket.companyservice.entity.Company;
import com.estockmarket.companyservice.mapper.impl.CompanyMapper;
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

    private CompanyMapper companyMapper;

    @Override
    public CompanyDTO registerNewCompany(CompanyDTO companyDto) {

        Company newCompany = companyMapper.converToEntity(companyDto);
        newCompany.setCompanyCode(generateNewCompanyCode(companyDto.getName()));
        // TODO: Perform validations
        Company savedCompany = companyRepo.save(newCompany);
        log.info("New Company saved | Company Name: {} ~ New code: {}", savedCompany.getName(), savedCompany.getCompanyCode());
        return companyMapper.convertToDTO(savedCompany);
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

    @Override
    public List<CompanyDTO> getAllCompanies() {
       return companyMapper.convertToDTOList(companyRepo.findAll());
    }
}