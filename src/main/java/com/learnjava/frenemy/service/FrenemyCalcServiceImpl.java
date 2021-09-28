package com.learnjava.frenemy.service;

import org.springframework.stereotype.Service;

@Service
public class FrenemyCalcServiceImpl implements FrenemyCalcService {

    private static final String FRIEND = "Friends";
    private static final String ENEMY = "Enemy";

    @Override
    public String findRelation(String userName, String friendName) {
        int total = userName.length() + friendName.length();
        return total % 2 == 0 ? ENEMY : FRIEND;
    }
}
