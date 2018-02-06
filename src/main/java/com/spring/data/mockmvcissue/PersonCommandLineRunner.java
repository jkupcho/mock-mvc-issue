package com.spring.data.mockmvcissue;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PersonCommandLineRunner implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        personRepository.save(new Person("Oliver Gierke"));
    }

}
