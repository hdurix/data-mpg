package fr.hippo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hippo on 13/09/2016.
 */
public class PlayerList {
    private String current_mpg_team;
    private HashMap<String, Team> teams;
    private ArrayList<TeamId> teamsid;

    public String getCurrent_mpg_team() {
        return current_mpg_team;
    }

    public void setCurrent_mpg_team(String current_mpg_team) {
        this.current_mpg_team = current_mpg_team;
    }

    public HashMap<String, Team> getTeams() {
        return teams;
    }

    public void setTeams(HashMap<String, Team> teams) {
        this.teams = teams;
    }

    public ArrayList<TeamId> getTeamsid() {
        return teamsid;
    }

    public void setTeamsid(ArrayList<TeamId> teamsid) {
        this.teamsid = teamsid;
    }

    public void printCsv() {
        teams.values().forEach(t -> System.out.println(String.join("\n", t.toCsv())));
    }

    public List<String> toCsv() {
        return teams.values().stream().map(Team::toCsv).flatMap(List::stream).sorted().collect(Collectors.toList());
    }
}
