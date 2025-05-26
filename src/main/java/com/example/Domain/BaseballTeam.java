package com.example.Domain;

import java.time.LocalDate;

public class BaseballTeam {

    private Long id;

    private String leagueName;

    private String teamName;

    private String headquarters;

    private String inauguration;

    private String history;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getInauguration() {
        return inauguration;
    }

    public void setInauguration(String inauguration) {
        this.inauguration = inauguration;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "BaseballTeam{" +
                "id=" + id +
                ", leagueName='" + leagueName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", headquarters='" + headquarters + '\'' +
                ", inauguration='" + inauguration + '\'' +
                ", history='" + history + '\'' +
                '}';
    }
}
