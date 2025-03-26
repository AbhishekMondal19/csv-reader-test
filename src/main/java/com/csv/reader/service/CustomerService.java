package com.csv.reader.service;

import com.csv.reader.config.CSVReader;
import com.csv.reader.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CSVReader<Customer> csvReader;
    private final String filePath;

    public CustomerService(CSVReader<Customer> csvReader, @Value("${csv.file.path}") String filePath) {
        this.csvReader = csvReader;
        this.filePath = filePath;
    }

    public List<Customer> getAllCustomers() {
        return csvReader.parseCSV(filePath);
    }
}

