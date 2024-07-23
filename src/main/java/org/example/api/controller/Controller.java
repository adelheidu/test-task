package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.Kinds;
import org.example.core.service.ExecuteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.api.Paths.MERGE;
import static org.example.api.Paths.MIN;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ExecuteService executeService;
    @PostMapping(MERGE)
    public void merge(@RequestParam(required = true) Kinds kind, @RequestBody List<List<Object>> intervals){
        executeService.executeMerge(kind, intervals);
    }

    @GetMapping(MIN)
    public List min(@RequestParam(required = true) Kinds kind){
        return executeService.executeMin(kind);
    }
}
