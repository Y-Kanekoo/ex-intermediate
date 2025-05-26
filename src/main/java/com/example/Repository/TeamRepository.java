package com.example.Repository;

import com.example.Domain.BaseballTeams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;


    /*SQLから情報を取ってきて、Baseballクラスに一行一行セットする。
        ""の中はSQLのカラムと一致するように書く
    */
    private static final RowMapper<BaseballTeams> BASEBALL_TEAMS_ROW_MAPPER
            = (rs, rowNum) -> {
        BaseballTeams baseballTeams = new BaseballTeams();
        baseballTeams.setId(rs.getInt("id"));
        baseballTeams.setLeagueName(rs.getString("league_name"));
        baseballTeams.setTeamName(rs.getString("team_name"));
        baseballTeams.setHeadquarters(rs.getString("headquarters"));
        baseballTeams.setInauguration(rs.getString("inauguration"));
        baseballTeams.setHistory(rs.getString("history"));
        return baseballTeams;
    };

    /**
     * IDに基づいて球団情報を1件取得します.
     *
     * @param id id
     * @return チーム情報
     */
    public BaseballTeams findById(Integer id){
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id =:id";

        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        try {
            BaseballTeams baseballTeams = template.queryForObject(sql, param, BASEBALL_TEAMS_ROW_MAPPER);
            return baseballTeams;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    /**
     * 発足日順に球団を取得する.
     *
     * @return 球団リスト
     */
    public List<BaseballTeams> findAllOrderByInauguration(){

        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history " +
                "FROM teams ORDER BY inauguration ASC";

        List<BaseballTeams> baseballTeamsList = template.query(sql, BASEBALL_TEAMS_ROW_MAPPER);

        return baseballTeamsList;
    }
}
