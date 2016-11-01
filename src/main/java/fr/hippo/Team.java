package fr.hippo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hippo on 13/09/2016.
 */
public class Team {
    private String id;
    private String name;
    private ArrayList<Player> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public List<String> toCsv() {
        return players.stream().map(player -> name.trim() + Player.SEPARATOR + player).collect(Collectors.toList());
    }
}
