package com.stringperm;

import static com.stringperm.Constants.EMPTY_INPUT;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringPermServiceImplTest {
  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  private static final String SPECIAL_CHARACTERS = ": ! @ # & ( ) – [ { } ] : ; ', ? / *";
  private static final StringPermService STRING_PERM_SERVICE = new StringPermServiceImpl();

  // Set up streams to test stdout
  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;

  @BeforeClass
  public static void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void resetStreams() {
    // Reset streams after every test case
    outContent.reset();
  }

  @AfterClass
  public static void restoreStreams() {
    System.setOut(originalOut);
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testFindAndPrintPermutations() {
    STRING_PERM_SERVICE.findAndPrintPermutations("sep");
    Assert.assertEquals("\"sep\", \"esp\", \"pse\", \"spe\", \"eps\", \"pes\"",
        outContent.toString().trim());
  }

  @Test
  public void testFindAndPrintPermutationsCard() {
    STRING_PERM_SERVICE.findAndPrintPermutations("card");
    Assert.assertEquals("\"card\", \"acrd\", \"rcad\", \"crad\", \"arcd\", \"racd\","
        + " \"dacr\", \"adcr\", \"cdar\", \"dcar\", \"acdr\", \"cadr\", \"crda\", \"rcda\", \"dcra\""
        + ", \"cdra\", \"rdca\", \"drca\", \"drac\", \"rdac\", \"adrc\", \"darc\", \"radc\","
        + " \"ardc\"", outContent.toString().trim());
  }

  @Test
  public void testFindAndPrintPermutationMaster() throws IOException {
    // Import large expectations from resources.
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    File file = new File(classLoader.getResource("master.txt").getFile());
    String content = new String(Files.readAllBytes(file.toPath()));

    STRING_PERM_SERVICE.findAndPrintPermutations("master");
    Assert.assertEquals(content.trim(), outContent.toString().trim());
  }

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