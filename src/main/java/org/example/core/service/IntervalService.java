package org.example.core.service;

import org.example.api.Kinds;
import org.example.core.entity.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class IntervalService<T extends Interval> {

    public abstract void merge(List<List<Object>> list);

    public List<T> mergeIntervals(List<T> list){
        list.sort(Comparator.naturalOrder());
        List<T> result = new ArrayList<>();
        result.add(list.get(0));
        for (T currentInterval : list){
            T resultInterval = result.get(result.size() - 1);

            if (resultInterval.compareToMerge(currentInterval) == 1){
                resultInterval.setEnding(resultInterval.max(currentInterval.getEnding()));
            }
            else{
                result.add(currentInterval);
            }
        }
        return result;
    }

    public abstract List min();

    public abstract Kinds getKind();
}
