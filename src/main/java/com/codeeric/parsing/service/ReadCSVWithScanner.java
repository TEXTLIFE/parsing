package com.codeeric.parsing.service;

import com.codeeric.parsing.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**@ClassName: ReadCSVWithScanner
 * @author : Enrique Tan
 * @date: May 25, 2021
 * @Description: This class will execute by itself when called no other 3rd party parser or library is used,
 * the data storage is thru List and ArrayList pumping the data class structure from Employee class,
 * I didn't put any database layer here.
 * @Remarks: dependent to Employee class for data structure, the keys corresponding to the column is provided by the
 * Employee class model
 */
public class ReadCSVWithScanner {

/*    @Autowired - optional implementation
    private static ResourceLoader resourceLoader;*/

    public static void main(String[] args) throws IOException {
        /**location path of the CSV to be read, can be manually change this is Windows OS format
         if MAC the format will be changed to like this

         I didn't implement the Resource Loader class here for simplicity purposes
         Example:
         initializing and determining the DYNAMIC path location of the csv file for reading and parsing
         this library is built-in in springframework, I might break the Exam Instruction. But here it is:

         Resource resource = resourceLoader.getResource("classpath:employees.csv");
         InputStream inputStream = resource.getInputStream();
         */

        //CSV LOCATION
        String csvPath = "C:\\Users\\eric\\Desktop\\parsing\\parsing\\src\\main\\resources\\employees.csv";

        // read file line by line and initialing it to null and zero
        String line = null;
        Scanner scanner = null;
        int index = 0;

        List<Employee> empList = new ArrayList<>();

        //Errorhandler Entry
        try {
            /** open file input stream, Not an external parser library,
             I'm NOT using any 3rd party parser library LIKE OpenCSV, etc as instructed */

            BufferedReader reader = new BufferedReader(new FileReader(csvPath));
            /** For dyanamic path implementation
             BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(inputStream))); */

            while ((line = reader.readLine()) != null) {
                Employee emp = new Employee(); //create an instance of object Employee from model package as instructed
                scanner = new Scanner(line);
                scanner.useDelimiter(";"); //semi-colon as parser separator.

                //looping and assigning data to the instance of object (Employee class model) from csv file
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0)
                        emp.setId(Integer.parseInt(data));
                    else if (index == 1)
                        emp.setName(data);
                    else if (index == 2)
                        emp.setRole(data);
                    else if (index == 3)
                        emp.setSalary(Float.parseFloat(data));
                    else
                        System.out.println("invalid data::" + data);
                    index++;
                }
                index = 0;
                empList.add(emp);
            }
            //close reader
            reader.close();
            System.out.println(empList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

