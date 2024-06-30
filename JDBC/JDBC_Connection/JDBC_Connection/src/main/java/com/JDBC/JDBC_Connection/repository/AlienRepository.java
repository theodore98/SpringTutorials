package com.JDBC.JDBC_Connection.repository;

import com.JDBC.JDBC_Connection.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlienRepository {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien) {
        String sql = "INSERT INTO Alien(id, name, tech)VALUES(?, ?, ?)";

        int rowCount = template.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rowCount + " rows affected");
    }

    public List<Alien> getAllAliens() {
        String sql = "SELECT * FROM Alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            }
        };
        List<Alien> aliens = template.query(sql, mapper);
        return aliens;

    }


}
