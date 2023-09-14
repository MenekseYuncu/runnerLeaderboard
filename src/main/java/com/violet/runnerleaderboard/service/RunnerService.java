package com.violet.runnerleaderboard.service;

import com.violet.runnerleaderboard.model.Pace;
import com.violet.runnerleaderboard.model.User;
import com.violet.runnerleaderboard.payload.RunnerResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RunnerService {

    @Autowired
    private CsvService csvService;

    public List<RunnerResponsePayload> listRunnersByAveragePace(String sortBy) throws IOException {
        ArrayList<RunnerResponsePayload> runners = new ArrayList<>();

        List<User> users = csvService.readUsersFromCsv();
        List<Pace> paceList = csvService.readPaceFromCsv();

        // Calculate average pace for each runner
        for (User user : users) {
            int userId = user.getUserId();

            // Find the Pace object for the current user
            Pace pace = paceList.stream()
                    .filter(p -> p.getUserId() == userId)
                    .findFirst()
                    .orElse(new Pace(userId, 0, 0L)); // Default to 0 values if not found

            // Add null checks to avoid potential division by zero
            double averagePace = pace.getTotalTime() != 0
                    ? (double) pace.getDistance() / pace.getTotalTime()
                    : 0.0;

            RunnerResponsePayload runner = new RunnerResponsePayload(user, pace, averagePace);
            runners.add(runner);
        }

        // Sort runners based on the specified criteria
        switch (sortBy) {
            case "age" -> runners.sort(Comparator.comparingInt(RunnerResponsePayload::getAge));
            case "username" -> runners.sort(Comparator.comparing(RunnerResponsePayload::getUsername));
            case "distance" -> runners.sort(Comparator.comparingLong(RunnerResponsePayload::getDistance));
            case "totalTime" -> runners.sort(Comparator.comparingInt(RunnerResponsePayload::getTotalTime));
            case "avgPace" -> runners.sort(Comparator.comparingDouble(RunnerResponsePayload::getAvgPace));
            default -> runners.sort(Comparator.comparingDouble(RunnerResponsePayload::getAvgPace));
        }

        return runners;
    }

}

