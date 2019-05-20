package com.stringperm;

import static com.stringperm.Constants.EMPTY_INPUT;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringPermServiceImplTest {
  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  private static final String SPECIAL_CHARACTERS = ": ! @ # & ( ) – [ { } ] : ; ', ? / *";
  private static final StringPermService STRING_PERM_SERVICE = new StringPermServiceImpl();

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();




  @Test
  public void testValidateInput() throws Exception {
    String result = STRING_PERM_SERVICE.validateInput(ALPHABET);
    Assert.assertEquals(ALPHABET, result);

    result = STRING_PERM_SERVICE.validateInput(SPECIAL_CHARACTERS);
    Assert.assertEquals(SPECIAL_CHARACTERS, result);
  }

  @Test
  public void testValidateInputEmptyInput() throws Exception {
    expectedEx.expect(Exception.class);
    expectedEx.expectMessage(EMPTY_INPUT);
    STRING_PERM_SERVICE.validateInput("");
  }

  @Test
  public void testValidateInputNull() throws Exception {
    expectedEx.expect(Exception.class);
    expectedEx.expectMessage(EMPTY_INPUT);
    STRING_PERM_SERVICE.validateInput("");
  }

  @Test
  public void testValidateInputWhiteSpace() throws Exception {
    String result = STRING_PERM_SERVICE.validateInput("     " + ALPHABET + "     ");
    Assert.assertEquals(ALPHABET, result);
  }
}