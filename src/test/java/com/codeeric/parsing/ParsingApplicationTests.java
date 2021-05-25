package com.codeeric.parsing;

import com.codeeric.parsing.model.Employee;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest

/**
 * @ClassName: ParsingApplicationTest
 * @author: Enrique Tan
 * @date: May 25, 2021
 * @Description: This class is part of TDD - Test Driven Development contains sample Unit Test of ReadCSVWithScanner class
 * for reading the actual cvs file, this will pass the test if the BufferReader class has some value provided,
 * will fail the test if no value or the path is broken;
 * @Remarks:
 */
class ParsingApplicationTests {

    CSVRetriever underTest = new CSVRetriever(); //initializing the class where in to be tested.

    ParsingApplicationTests() throws IOException {
    }

    @Test
    void itShouldReadCSVFile() throws IOException {
        // Given ***
        boolean isAvailable = true;
        boolean notAvailable = false;

        // When ***
        boolean result = underTest.reader.readLine() != null;

        // Then ***
        boolean expected = isAvailable; //will pass the test
        //boolean expected = notAvailable; //will NOT pass the test
        assertThat(result).isEqualTo(expected); //assertThat keyword use from the library to validate the logic
    }

    class CSVRetriever {
        String csvPath = "C:\\Users\\eric\\Desktop\\parsing\\parsing\\src\\main\\resources\\employees.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvPath));

        CSVRetriever() throws FileNotFoundException {
        }
    }
}