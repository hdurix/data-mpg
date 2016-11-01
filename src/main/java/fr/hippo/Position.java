package fr.hippo;

/**
 * Created by hippo on 16/09/2016.
 */
public enum Position {
    GARDIEN("1", "Gardien"),
    DEFENSEUR("2", "Défenseur"),
    MILIEU("3", "Milieu"),
    ATTAQUANT("4", "Attaquant");

    private String label;
    private String num;

    Position(String num, String label) {
        this.label = label;
        this.num = num;
    }

    public String getLabel() {
        return label;
    }

    public String getNum() {
        return num;
    }

    public static Position findByNum(String num) {
        for (Position p : values()) {
            if (p.num.equals(num)) {
                return p;
            }
        }
        return null;
    }

}
