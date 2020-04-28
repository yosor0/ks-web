package com.jaehong.app.controller;

import com.jaehong.app.entity.*;
import com.jaehong.app.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final PersonRepository personRepository;

    private final SocialMediaRepository socialMediaRepository;

    private final InterestRepository interestRepository;

    private final SkillRepository skillRepository;

    private final WorkRepository workRepository;

    public IndexController(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterestRepository interestRepository, InterestRepository interestRepository1, SkillRepository skillRepository, WorkRepository workRepository) {
        this.personRepository = personRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.interestRepository = interestRepository1;
        this.skillRepository = skillRepository;
        this.workRepository = workRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("person", person);
        SocialMedia socialMedia = socialMediaRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("socialMedia", socialMedia);
        List<Interest> interests = interestRepository.findAll();
        model.addAttribute("interests", interests);
        List<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills", skills);
        List<Work> works = workRepository.findAll();
        model.addAttribute("works", works);
        return "resume";
    }

}
