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
        //given correct test scenario
        TestScenario testScenario = new TestScenario();
        TestScenarioValidator validator = Mockito.mock(TestScenarioValidator.class);
        BDDMockito.given(validator.isCorrect(ArgumentMatchers.any())).willReturn(true);
        //given author with priviliges
        AuthorAccess authorAccess = Mockito.mock(AuthorAccess.class);
        BDDMockito.given(authorAccess.hasPriviliges(ArgumentMatchers.any())).willReturn(true);
        Author author = new Author();
        //given map to store scenarios and authors
        Map<Author, TestScenario> testScenarios = new HashMap<>();

        //given tests suite
        TestsSuite testsSuite = new TestsSuite(validator, authorAccess, testScenarios);

        //when
        testsSuite.add(testScenario, author);

        //then
        Assert.assertTrue(testScenarios.containsKey(author));
        Assert.assertTrue(testScenarios.containsValue(testScenario));
    }
}
