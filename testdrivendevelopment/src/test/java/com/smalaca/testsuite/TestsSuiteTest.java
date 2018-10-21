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
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(true);
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any())).willReturn(true);

        //when
        testsSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.containsKey(AUTHOR));
        Assert.assertTrue(testScenarios.containsValue(TEST_SCENARIO));
    }

    @Test
    public void shouldNotAddTestScenarioWhenAuthorHasNoPrivileges() {
        //given
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(true);
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any())).willReturn(false);

        //when
        testsSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.isEmpty());
    }

    @Test
    public void shouldNotAddTestScenarioWhenTestScenarioIsNotCorrect() {
        //given
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(false);
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any())).willReturn(true);

        //when
        testsSuite.add(TEST_SCENARIO, AUTHOR);

        //then
        Assert.assertTrue(testScenarios.isEmpty());
    }
}
