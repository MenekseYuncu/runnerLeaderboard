package com.violet.runnerleaderboard.controller;

import com.violet.runnerleaderboard.model.Pace;
import com.violet.runnerleaderboard.model.User;
import com.violet.runnerleaderboard.payload.RunnerResponsePayload;
import com.violet.runnerleaderboard.service.CsvService;
import com.violet.runnerleaderboard.service.RunnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/csv")
public class RunnerController {

    private final CsvService csvService;
    private final RunnerService runnerService;

    public RunnerController(CsvService csvService, RunnerService runnerService) {
        this.csvService = csvService;
        this.runnerService = runnerService;
    }

    @GetMapping("/read-users")
    public List<User> readUsersFromCsv() throws IOException {
        return csvService.readUsersFromCsv();

    }

    @GetMapping("/read-paces")
    public List<Pace> readPaceFromCsv() throws IOException {
        return csvService.readPaceFromCsv();
    }

    @GetMapping("/list/{sortBy}")
    public List<RunnerResponsePayload> listRunnersByAveragePace(
            @PathVariable String sortBy
    ) throws IOException{
        return runnerService.listRunnersByAveragePace(sortBy);
    }
}
