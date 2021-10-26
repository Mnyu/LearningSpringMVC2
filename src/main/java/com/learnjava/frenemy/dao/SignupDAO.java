package com.learnjava.frenemy.dao;

import com.learnjava.frenemy.model.SignupDTO;

public interface SignupDAO {

    void saveUser(SignupDTO signupDTO);
}
