import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SpaceMissionPlanner{
    //Attributes
    ArrayList<SpaceMission> missionList;
    ArrayList<Spacecraft> spacecraftList;

    //Constructor
    public SpaceMissionPlanner() {
        this.missionList = new ArrayList<SpaceMission>();
        this.spacecraftList = new ArrayList<Spacecraft>();
    }

    //Function(Mission Functions)
    public void addMission(SpaceMission mission){missionList.add(mission);}
    String getMissionDetails(SpaceMission mission){
        //Variable for return
        String details="";

        if(missionList.contains(mission)){
            details ="Name: "+mission.getMissionName()
                    +"\nID: "+mission.getMissionID()
                    +"\nDestination: "+mission.getDestination()
                    +"\nLaunch Date: "+mission.getLaunchDate()
                    +"\nMission Status: "+mission.getStatus()
                    +"\nMission Spacecraft Type: "+mission.getMissionSpacecraft().getSpacecraftType()+"\n";
        }else System.out.println("There is no mission with ID: "+mission.getMissionID()+" and name: "+ mission.getMissionName());

        return details;
    }

    //Function(Spacecraft Functions)
    public void addSpacecraft(Spacecraft spacecraft){spacecraftList.add(spacecraft);}
    String getSpacecraftDetails(Spacecraft spacecraft){
        //Variable for return
        String details="";

        if(spacecraftList.contains(spacecraft)){
            details ="Type: "+spacecraft.getSpacecraftType()
                    +"\nID: "+spacecraft.getSpacecraftID()
                    +"\nCapacity: "+spacecraft.getCapacity()
                    +"\nStatus: "+spacecraft.getStatus()+"\n";
        }else System.out.println("There is no spacecraft with ID: "+spacecraft.getSpacecraftID()+" and type: "+ spacecraft.getSpacecraftType());

        return details;
    }

    //Other Functions
    public void showMissions(){
        if(!missionList.isEmpty())
            for(SpaceMission mission:this.missionList)
                System.out.println(this.getMissionDetails(mission));
        else System.out.println("There is no available mission");
    }
    public void showSpacecrafts(){
        if(!spacecraftList.isEmpty())
            for(Spacecraft spacecraft:this.spacecraftList)
                System.out.println(this.getSpacecraftDetails(spacecraft));
        else System.out.println("There is no available spacecraft");
    }






    //Remove with ID
    public void removeMissionWithID(int ID){
        for(SpaceMission mission:missionList)
            if(mission.getMissionID() == ID){
                missionList.remove(mission);
                return;
            }
        System.out.println("There is no mission with ID: "+ID);
    }
    public void removeSpacecraftWithID(int ID){
        for(Spacecraft spacecraft:spacecraftList)
            if(spacecraft.getSpacecraftID()==ID){
                spacecraftList.remove(spacecraft);
                return;
            }
        System.out.println("There is no spacecraft with ID: "+ID);
    }
    public void showSpacecraftWithID(int ID){
        for(Spacecraft spacecraft:spacecraftList)
            if(spacecraft.getSpacecraftID()==ID){
                getSpacecraftDetails(spacecraft);
                return;
            }
        System.out.println("There is no spacecraft with ID: "+ID);
    }
    public void showMissionWithID(int ID){
        for(SpaceMission mission:missionList)
            if(mission.getMissionID()==ID){
                getMissionDetails(mission);
                return;
            }
        System.out.println("There is no mission with ID: "+ID);
    }
    public void setSpacecraftToMission(int spacecraftID,int missionID){
        for(SpaceMission mission:missionList)
            for(Spacecraft spacecraft:spacecraftList)
                if(spacecraft.getSpacecraftID()==spacecraftID&&mission.getMissionID()==missionID){
                    if(spacecraft.getStatus()==SpacecraftStatus.AVAILABLE) mission.setMissionSpacecraft(spacecraft);
                    else System.out.println("There is no mission with ID or it is not available: "+spacecraftID);
                }
    }
    Spacecraft findSpacecraft(int spacecraftID){
        for(Spacecraft spacecraft:spacecraftList)
            if(spacecraft.getSpacecraftID()==spacecraftID) return spacecraft;

        return null;
    }
    SpaceMission findMission(int missionID){
        for(SpaceMission mission:missionList)
            if(mission.getMissionID()==missionID) return mission;

        return null;
    }
    public void changeSpacecraftStatus(int spacecraftID,int userInput){

        switch(userInput){
            case 1:
                findSpacecraft(spacecraftID).setStatus(SpacecraftStatus.AVAILABLE);
                break;
            case 2:
                findSpacecraft(spacecraftID).setStatus(SpacecraftStatus.IN_TRANSIT);
                break;
            case 3:
                findSpacecraft(spacecraftID).setStatus(SpacecraftStatus.IN_OPERATION);
                break;
            case 4:
                findSpacecraft(spacecraftID).setStatus(SpacecraftStatus.MAINTENANCE);
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
    }
    public void changeMissionStatus(int missionID,int userInput){
        switch(userInput){
            case 1:
                findMission(missionID).setStatus(MissionStatus.PLANNED);
            case 2:
                findMission(missionID).setStatus(MissionStatus.IN_PROGRESS);
                break;
            case 3:
                findMission(missionID).setStatus(MissionStatus.COMPLETED);
                break;
            case 4:
                findMission(missionID).setStatus(MissionStatus.FAILED);
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
    }
    public void changeSpacecraftType(int ID,String type){findSpacecraft(ID).setSpacecraftType(type);}
}

