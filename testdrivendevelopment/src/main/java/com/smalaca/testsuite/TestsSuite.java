package com.smalaca.testsuite;

import java.util.Map;

class TestsSuite {
    private final Map<Author, TestScenario> testScenarios;

    TestsSuite(TestScenarioValidator validator, AuthorAccess authorAccess, Map<Author, TestScenario> testScenarios) {
        this.testScenarios = testScenarios;
    }

    void add(TestScenario testScenario, Author author) {
        testScenarios.put(author, testScenario);
    }
}
