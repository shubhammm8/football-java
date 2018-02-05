package in.mindtree;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Team {
	
	@Id
	@GeneratedValue
	@Column(name="tid")
	private int tid;
	
	@Column(name="teamName")
	private String teamName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="nid")
	private Nation nation;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}


	
	
	
}
