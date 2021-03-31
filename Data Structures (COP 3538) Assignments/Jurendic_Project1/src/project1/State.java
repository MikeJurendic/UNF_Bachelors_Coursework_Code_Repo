package project1;
/* 
 * ** This class is intended to be used to create an object for each of the 56 US States / Territories
 * Mentioned for the assignment. Each variable of the class utilizes a set and get method and attempts
 * to follow the best programming practices possible. ----  **
 * @author Mike Jurendic, N01181088* 
 * @version 2/1/2019 10:48 PM 
 * */


public class State {
	
	private String Name;
	private String CaptialCity; 
	private String Abbr; 
	private int Population; 
	private String Region; 
	private int USHouseSeats;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getCaptialCity() {
		return CaptialCity;
	}
	
	public void setCaptialCity(String captialCity) {
		this.CaptialCity = captialCity;
	}
	
	public String getAbbr() {
		return Abbr;
	}
	
	public void setAbbr(String abbr) {
		this.Abbr = abbr;
	}
	
	public int getPopulation() {
		return Population;
	}
	
	public void setPopulation(int population) {
		this.Population = population;
	}
	
	public String getRegion() {
		return Region;
	}
	
	public void setRegion(String region) {
		this.Region = region;
	}
	
	public int getUSHouseSeats() {
		return USHouseSeats;
	}
		
	public void setUSHouseSeats(int uSHouseSeats) {
		this.USHouseSeats = uSHouseSeats;
	}

	public State(String name, String captialCity, String abbr, int population, String region, int uSHouseSeats) {
		super();
		Name = name;
		CaptialCity = captialCity;
		Abbr = abbr;
		Population = population;
		Region = region;
		USHouseSeats = uSHouseSeats;
	}


	
	
	
	
}
