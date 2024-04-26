package com.akshay.springframework.example04;

import org.springframework.stereotype.Component;

@Component
public class MysqlDBDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
}
