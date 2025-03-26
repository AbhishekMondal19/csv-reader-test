package com.csv.reader.config;

import java.util.List;

public interface CSVReader<T> {
    List<T> parseCSV(String filePath);
}
