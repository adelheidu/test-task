package org.example.core.entity;

public interface Interval<Type, IntervalType> extends Comparable<IntervalType> {
    Type getStarting();

    Type getEnding();

    void setStarting(Type starting);

    void setEnding(Type ending);

    int compareToMerge(IntervalType interval);

    Type max(Type ending);
}


