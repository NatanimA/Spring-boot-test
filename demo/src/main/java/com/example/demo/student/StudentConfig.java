package com.example.demo.student;

import org.apache.maven.shared.utils.cli.Commandline;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student natanim = new Student(
                    "Natanim",
                    "Natanim@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,9),
                    21
            );

            Student suad = new Student(

                    "Suad",
                    "suad@gmail.com",
                    LocalDate.of(2003, Month.JANUARY,9),
                    21
            );
            studentRepository.saveAll(List.of(
                    natanim,suad
            ));
        };
    }
}
