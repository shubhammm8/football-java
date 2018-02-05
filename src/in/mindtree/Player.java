package in.mindtree;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private int pid;
	
	@Column(name="playerName")
	private String playerName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="footballStuds")
	private String footballStuds;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tid")
	private Team team;
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFootballStuds() {
		return footballStuds;
	}

	public void setFootballStuds(String footballStuds) {
		this.footballStuds = footballStuds;
	}
	
	
	
	
	
}
