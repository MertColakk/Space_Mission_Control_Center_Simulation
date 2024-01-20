public class SpaceMission {
    //Attributes
    private int missionID;
    private String missionName,launchDate,destination;
    private MissionStatus status;
    private Spacecraft missionSpacecraft;

    //Constructor
    public SpaceMission(int missionID, String missionName, String launchDate, String destination ){
        this.missionID = missionID;
        this.missionName = missionName;
        this.launchDate = launchDate;
        this.destination = destination;
        this.status = MissionStatus.PLANNED;
        this.missionSpacecraft = new Spacecraft(0,0,"NULL");
    }

    //Getter and Setters
    public int getMissionID(){return missionID;}
    public String getMissionName(){return missionName;}
    public void setMissionName(String missionName){this.missionName = missionName;}
    public String getLaunchDate(){return launchDate;}
    public void setLaunchDate(String launchDate){this.launchDate = launchDate;}
    public String getDestination(){return destination;}
    public void setDestination(String destination){this.destination = destination;}
    public MissionStatus getStatus(){return status;}
    public void setStatus(MissionStatus status){this.status = status;}
    public Spacecraft getMissionSpacecraft(){return missionSpacecraft;}
    public void setMissionSpacecraft(Spacecraft missionSpacecraft){this.missionSpacecraft = missionSpacecraft;}
}
