package com.example.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class SearchFilter {
    private final String searchInput;
    private final String searchCriteria;
}
