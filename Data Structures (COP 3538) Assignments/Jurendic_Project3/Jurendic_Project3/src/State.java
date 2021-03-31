
public class State {

    private String Name;
    private String CaptialCity;
    private String Abbr;
    private int Population;
    private String Region;
    private int USHouseSeats;

// method to return name of a state when called on
    public String getName() {
        return Name;
    }

// method to set name of a state when called on
    public void setName(String name) {
        this.Name = name;
    }

// method to return the captial city when called on
    public String getCaptialCity() {
        return CaptialCity;
    }

// method to set the captial city when called on
    public void setCaptialCity(String captialCity) {
        this.CaptialCity = captialCity;
    }

// method to get the intials of the state (I.e. Florida = FL)
    public String getAbbr() {
        return Abbr;
    }

// method to set the intials of the state
    public void setAbbr(String abbr) {
        this.Abbr = abbr;
    }

// method to return the population of a state
    public int getPopulation() {
        return Population;
    }

// method to set the population of a state
    public void setPopulation(int population) {
        this.Population = population;
    }

// method to return the region of a certain state
    public String getRegion() {
        return Region;
    }

// method to set the region of a certain state
    public void setRegion(String region) {
        this.Region = region;
    }

// method to return the seats in house a state holds
    public int getUSHouseSeats() {
        return USHouseSeats;
    }

// method to set the amount seats in house a state holds
    public void setUSHouseSeats(int uSHouseSeats) {
        this.USHouseSeats = uSHouseSeats;
    }

    public State(){

    }
// Constructors for the State class

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
