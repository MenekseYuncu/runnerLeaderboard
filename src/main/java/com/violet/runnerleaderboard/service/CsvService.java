package com.violet.runnerleaderboard.service;

import com.violet.runnerleaderboard.model.Pace;
import com.violet.runnerleaderboard.model.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    private static final String USER_CSV_FILE = "src/main/resources/data/users.csv";
    private static final String PACE_CSV_FILE = "src/main/resources/data/pace.csv";

    public List<User> readUsersFromCsv() throws IOException {
        List<User> users = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(USER_CSV_FILE));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())
        ) {
            for (CSVRecord record : csvParser) {
                User user = new User();
                user.setUserId((int) Long.parseLong(record.get("userid")));
                user.setUserName(record.get("username"));
                user.setAge(Integer.parseInt(record.get("age")));
                users.add(user);
            }
        }
        return users;
    }

    public List<Pace> readPaceFromCsv() throws IOException {
        List<Pace> paceList = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(PACE_CSV_FILE));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())
        ) {
            for (CSVRecord record : csvParser) {
                Pace pace = new Pace();
                pace.setUserId((int) Long.parseLong(record.get("userid")));
                pace.setTotalTime(Integer.parseInt(record.get("total_time")));
                pace.setDistance(Long.parseLong(record.get("distance")));
                paceList.add(pace);
            }
        }
        return paceList;
    }
}
