package org.example.core.service;

import lombok.RequiredArgsConstructor;
import org.example.api.Kinds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProviderService {
    @Autowired
    private List<IntervalService> intervalServiceList;

    public IntervalService getIntervalService(Kinds kind) {
        for (IntervalService intervalService : intervalServiceList){
            if (intervalService.getKind() == kind){
                return intervalService;
            }
        }
        throw new RuntimeException("Указан неверный тип.");
    }
}
