package org.example.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Paths {
    public static final String MERGE = "/api/v1/intervals/merge";
    public static final String MIN = "/api/v1/intervals/min";
}
