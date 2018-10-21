package com.smalaca.testsuite;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class TestsSuiteTest {

    @Test
    public void shouldAddTestScenario() {
        //given
        TestScenarioValidator validator = Mockito.mock(TestScenarioValidator.class);
        AuthorAccess authorAccess = Mockito.mock(AuthorAccess.class);
        Map<Author, TestScenario> testScenarios = new HashMap<>();
        TestsSuite testsSuite = new TestsSuite(validator, authorAccess, testScenarios);

        TestScenario testScenario = new TestScenario();
        Author author = new Author();

        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(true);
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any())).willReturn(true);

        //when
        testsSuite.add(testScenario, author);

        //then
        Assert.assertTrue(testScenarios.containsKey(author));
        Assert.assertTrue(testScenarios.containsValue(testScenario));
    }

    @Test
    public void shouldNotAddTestScenarioWhenAuthorHasNoPrivileges() {
        //given
        TestScenarioValidator validator = Mockito.mock(TestScenarioValidator.class);
        AuthorAccess authorAccess = Mockito.mock(AuthorAccess.class);
        Map<Author, TestScenario> testScenarios = new HashMap<>();
        TestsSuite testsSuite = new TestsSuite(validator, authorAccess, testScenarios);

        TestScenario testScenario = new TestScenario();
        Author author = new Author();

        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(true);
        BDDMockito.given(authorAccess.hasPrivileges(ArgumentMatchers.any())).willReturn(false);

        //when
        testsSuite.add(testScenario, author);

        //then
        Assert.assertTrue(testScenarios.isEmpty());
    }
}
