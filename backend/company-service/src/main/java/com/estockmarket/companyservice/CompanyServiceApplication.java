package com.estockmarket.companyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.estockmarket.companyservice.repo.SequenceRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CompanyServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CompanyServiceApplication.class, args);

		// ISequenceRepo repo = ctx.getBean(ISequenceRepo.class);
		// log.info("{}", repo.getNextSequenceId("BA"));
	}

}
