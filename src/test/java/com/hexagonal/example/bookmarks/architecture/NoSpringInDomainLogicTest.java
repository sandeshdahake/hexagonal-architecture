package com.hexagonal.example.bookmarks.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = {"com.hexagonal.example.bookmarks", "org.springframework"})
public class NoSpringInDomainLogicTest {

    @ArchTest
    public static final ArchRule model_should_not_depend_on_spring =
            noClasses()
                    .that()
                    .resideInAPackage(
                            "..bookmarks..domain..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("org.springframework..");
}