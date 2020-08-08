package proj;

import java.util.ArrayList;

public class Senator {
	
	private String name;
	private int abPoints;
	private String nNum;
	private String committee;
	public ArrayList<String> meetingsMissed = new ArrayList<String>();
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAbPoints() {
		return abPoints;
	}
	
	public void setAbPoints(int abPoints) {
		this.abPoints = abPoints;
	}
	
	public String getnNum() {
		return nNum;
	}

	public void setnNum(String nNum) {
		this.nNum = nNum;
	}

	public String getCommittee() {
		return committee;
	}

	public void setCommittee(String committee) {
		this.committee = committee;
	}
	
	public void addPoint() {
		++abPoints;
	}
	
	public void delPoint() {
		--abPoints;
	}
	
	

}
