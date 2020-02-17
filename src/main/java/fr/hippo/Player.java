package fr.hippo;

/**
 * Created by hippo on 13/09/2016.
 */
public class Player {

    public static final char SEPARATOR = ';';

    private String id;
    private String club;
    private String firstname;
    private String lastname;
    private String position;
    private String ultraPosition;
    private String teamid;
    private String price_paid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getUltraPosition() {
		return ultraPosition;
	}

	public void setUltraPosition(String ultraPosition) {
		this.ultraPosition = ultraPosition;
	}

	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public String getPrice_paid() {
        return price_paid;
    }

    public void setPrice_paid(String price_paid) {
        this.price_paid = price_paid;
    }

    @Override
    public String toString() {
        String label = Position.findByNum(position).getLabel();
        return lastname + SEPARATOR + label + SEPARATOR + club + SEPARATOR + price_paid;
    }
}
