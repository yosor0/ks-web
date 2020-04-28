package com.jaehong.app;

import com.jaehong.app.entity.*;
import com.jaehong.app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	public final PersonRepository personRepository;
	public final SocialMediaRepository socialMediaRepository;
	public final InterestRepository interestRepository;
	public final SkillRepository skillRepository;
	public final WorkRepository workRepository;

	public AppApplication(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterestRepository interestRepository, SkillRepository skillRepository, WorkRepository workRepository) {
		this.personRepository = personRepository;
		this.socialMediaRepository = socialMediaRepository;
		this.interestRepository = interestRepository;
		this.skillRepository = skillRepository;
		this.workRepository = workRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.save(new Person("최재홍", "프론트", "hello@test.com", "010-1234-5678"));
		socialMediaRepository.save(new SocialMedia("anonymous", "anonymous",null ,null ));
		interestRepository.save(new Interest("베이스"));
		interestRepository.save(new Interest("Heroes of the Storm"));
		interestRepository.save(new Interest("LOL"));
		skillRepository.save(new Skill("C", 50));
		skillRepository.save(new Skill("JAVA", 80));
		skillRepository.save(new Skill("Python", 70));
		workRepository.save(new Work("프론트", "Nexon", "2019", "sample message"));
		workRepository.save(new Work("프론트", "Kakao", "2017", "sample message"));
	}
}