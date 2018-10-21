package com.smalaca.testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class TestsSuiteTest {
    private static final TestScenario TEST_SCENARIO = new TestScenario();
    private static final Author AUTHOR = new Author();

    private TestsSuite testsSuite;
    private Map<Author, TestScenario> testScenarios;
    private AuthorAccess authorAccess;
    private TestScenarioValidator validator;

    @Before
    public void init() {
        validator = Mockito.mock(TestScenarioValidator.class);
        authorAccess = Mockito.mock(AuthorAccess.class);
        testScenarios = new HashMap<>();
        testsSuite = new TestsSuite(validator, authorAccess, testScenarios);
    }

    @Test
    public void shouldAddTestScenario() {
        //given
        givenCorrectTestScenario();
        givenAuthorWithPrivileges();

        //when
        testsSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.containsKey(AUTHOR));
        Assert.assertTrue(testScenarios.containsValue(TEST_SCENARIO));
    }

    @Test
    public void shouldNotAddTestScenarioWhenAuthorHasNoPrivileges() {
        //given
        givenCorrectTestScenario();
        givenAuthorHasNoPrivileges();

        //when
        testsSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.isEmpty());
    }

    private void givenAuthorHasNoPrivileges() {
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any())).willReturn(false);
    }

    private void givenCorrectTestScenario() {
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(true);
    }

    @Test
    public void shouldNotAddTestScenarioWhenTestScenarioIsNotCorrect() {
        //given
        givenIncorrectTestScenario();
        givenAuthorWithPrivileges();

        //when
        testsSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.isEmpty());
    }

    private void givenIncorrectTestScenario() {
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(false);
    }

    private void givenAuthorWithPrivileges() {
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any())).willReturn(true);
    }
}
