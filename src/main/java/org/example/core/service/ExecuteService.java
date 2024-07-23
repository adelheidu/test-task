package org.example.core.service;

import lombok.RequiredArgsConstructor;
import org.example.api.Kinds;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExecuteService {
    private final ProviderService providerService;

    public void executeMerge(Kinds kind, List<List<Object>> list) {
        providerService.getIntervalService(kind).merge(list);
    }

    public List<Object> executeMin(Kinds kind) {
        return providerService.getIntervalService(kind).min();
    }
}
