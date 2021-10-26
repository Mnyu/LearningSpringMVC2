package com.learnjava.frenemy.dao;

import com.learnjava.frenemy.model.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SignupDAOImpl implements SignupDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SignupDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public void saveUser(SignupDTO signupDTO) {
        String sql = "INSERT INTO USERS VALUES(?,?,?)";
        jdbcTemplate.update(sql, signupDTO.getUsername(), signupDTO.getPassword(), true);
        saveAuthority(signupDTO);
    }

    private void saveAuthority(SignupDTO signupDTO) {
        String sql = "INSERT INTO AUTHORITIES VALUES(?,?)";
        jdbcTemplate.update(sql, signupDTO.getUsername(), "USER");
    }
}
