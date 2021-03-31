

package project2;

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

    public State(){

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

    @Override
    public String toString() {
        return Name +" , "+  CaptialCity +" , "+ Abbr +" , "+ Population +" , "+  Region +" , "+  USHouseSeats;
    }

    
}
