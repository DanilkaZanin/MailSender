package com.example.mailsender.csvParser;

import com.example.mailsender.config.Configuration;

import java.io.File;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class CsvParser {
    public static String[] readColumn(String a) throws Exception {

        File file = new File(Configuration.csvFile);

        List<String> lines = Files.readAllLines(file.toPath(),
                StandardCharsets.UTF_8);
        String mails = "";
        String indexes = "";
        String names = "";

        for (String line : lines) {
            String[] array = line.split(",", -1);
            indexes += array[0] + " ";
            mails += array[1] + " ";
            names += array[2] + " ";

        }

        String[] mails1 = mails.split(" ");
        String[] indexes1 = indexes.split(" ");
        String[] names1 = names.split(" ");
        if(a.equals("mails")){
            return mails1;
        }
        else if(a.equals("indexes")){
            return indexes1;
        }
        else if(a.equals("names")){
            return names1;
        }
        return null;
    }
}
