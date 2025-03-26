package com.csv.reader.impl;

import com.csv.reader.config.CSVReader;
import com.csv.reader.model.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerCSVReader implements CSVReader<Customer> {

    @Override
    public List<Customer> parseCSV(String filePath) {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {
                Customer customer = new Customer();
                customer.setId(record.get("ID").trim());
                customer.setName(record.get("Name").trim());
                customer.setEmail(record.get("Email").trim().trim());
                customer.setPhone(record.get("Phone").trim());
                customer.setAddress(record.get("Address").trim());
                customers.add(customer);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + e.getMessage(), e);
        }
        return customers;
    }
}

