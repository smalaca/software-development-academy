package com.smalaca.testsuite;

import java.util.Map;

class TestsSuite {
    private final TestScenarioValidator validator;
    private final AuthorAccess authorAccess;
    private final Map<Author, TestScenario> testScenarios;

    TestsSuite(TestScenarioValidator validator, AuthorAccess authorAccess, Map<Author, TestScenario> testScenarios) {
        this.validator = validator;
        this.authorAccess = authorAccess;
        this.testScenarios = testScenarios;
    }

    void add(TestScenario testScenario, Author author) {
        if (authorAccess.hasPrivileges(author) && validator.isCorrect(testScenario)) {
            testScenarios.put(author, testScenario);
        }
    }
}
