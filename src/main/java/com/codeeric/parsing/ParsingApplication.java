package com.codeeric.parsing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**@ClassName: ParsingApplication
 * @author : Enrique Tan
 * @date: May 25, 2021
 * @Description: Another implementation of csv parser with dynamic path locator via ResourceLoader
 * @Remarks: This class is not providing any data structure or model from the CSV file it captured.
 * with simple Springboot framework implementation
 */
@SpringBootApplication
public class ParsingApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ParsingApplication.class, args);
    }

    final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        //initializing and determining the dynamic path location of the csv file for reading and parsing
        //this library is built-in in springframework
        Resource resource = resourceLoader.getResource("classpath:employees.csv");
        InputStream inputStream = resource.getInputStream();
        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);
            LOGGER.info(data);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
    }


}
