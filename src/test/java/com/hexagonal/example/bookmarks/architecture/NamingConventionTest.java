package com.hexagonal.example.bookmarks.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = {"com.hexagonal.example.bookmarks"})
public class NamingConventionTest {
    @ArchTest
    static ArchRule controllers_should_not_have_Gui_in_name =
            classes()
                    .that().resideInAPackage("..restAPI..")
                    .should().haveSimpleNameNotContaining("Gui");

/*
    @ArchTest
    static ArchRule controllers_should_be_suffixed =
            classes()
                    .that().resideInAPackage("..restAPI..")
                    .should().haveSimpleNameEndingWith("Resource");
*/

    @ArchTest
    static ArchRule classes_named_controller_should_never_be_in_a_restAPI_package =
            classes()
                    .that().haveSimpleNameContaining("Controller")
                    .should().resideOutsideOfPackage("..main..restAPI..");
}
