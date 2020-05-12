package com.hexagonal.example.bookmarks.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.hexagonal.example.bookmarks")
public class HexagonalArchitectureTest {
    @ArchTest
    public static final ArchRule domain_should_not_depend_on_application =
            noClasses()
                    .that()
                    .resideInAPackage("..domain..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..application..");

    @ArchTest
    public static final ArchRule domain_should_not_depend_on_infrastructure =
            noClasses()
                    .that()
                    .resideInAPackage("..domain..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..infrastructure..");

    @ArchTest
    public static final ArchRule domain_should_not_depend_on_ui =
            noClasses()
                    .that()
                    .resideInAPackage("..domain..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..restAPI..");

    @ArchTest
    public static final ArchRule application_should_not_depend_on_infrastructure =
            noClasses()
                    .that()
                    .resideInAPackage("..application..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..infrastructure..");

    @ArchTest
    public static final ArchRule application_should_not_depend_on_restAPI =
            noClasses()
                    .that()
                    .resideInAPackage("..application..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..restAPI..");

    @ArchTest
    public static final ArchRule restAPI_should_not_depend_on_infrastructure =
            noClasses()
                    .that()
                    .resideInAPackage("..restAPI..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..infrastructure..");
}
