package utils;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateRelatedActions {
    public String getCurrentDate()
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime date = LocalDateTime.now();
        return dateFormat.format(date);
    }

    public int getTotalOfDate(String date)
    {
        date = date.trim();
        String[] splitedDate = date.split("/");
        int total =0;
        total = (Integer.parseInt(splitedDate[0])*30)+Integer.parseInt(splitedDate[1])+(Integer.parseInt(splitedDate[2])*365);
        return total;
    }
}
