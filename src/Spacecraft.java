public class Spacecraft {
    //Attributes
    private int spacecraftID,capacity;
    private String spacecraftType;
    private SpacecraftStatus status;

    //Constructor
    public Spacecraft(int spacecraftID, int capacity, String spacecraftType){
        this.spacecraftID = spacecraftID;
        this.capacity = capacity;
        this.spacecraftType = spacecraftType;
        this.status = SpacecraftStatus.AVAILABLE;
    }

    //Getters and Setters
    public int getSpacecraftID() {return spacecraftID;}
    public int getCapacity() {return capacity;}
    public String getSpacecraftType() {return spacecraftType;}
    public void setSpacecraftType(String spacecraftType){this.spacecraftType = spacecraftType;}
    public SpacecraftStatus getStatus() {return status;}
    public void setStatus(SpacecraftStatus status) {this.status = status;}

}