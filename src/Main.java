import java.util.Scanner; //For user input

public class Main {
    public static void main(String[] args){
        //Variables
        SpaceMissionPlanner spaceMissionPlanner = new SpaceMissionPlanner();
        Scanner scanner = new Scanner(System.in);
        boolean exit=false;
        String userStringInput;

        while(!exit){
            menu();
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                case 1:
                    clearScreen();
                    spaceMissionPlanner.addMission(newMission());
                    break;
                case 2:
                    clearScreen();
                    spaceMissionPlanner.showMissions();
                    System.out.println("Enter mission ID for remove: ");
                    userInput = scanner.nextInt();
                    scanner.nextLine();

                    spaceMissionPlanner.removeMissionWithID(userInput);
                    break;
                case 3:
                    clearScreen();
                    spaceMissionPlanner.showSpacecrafts();
                    spaceMissionPlanner.addSpacecraft(newSpacecraft());
                    break;
                case 4:
                    clearScreen();
                    System.out.println("Enter spacecraft ID for remove: ");
                    userInput = scanner.nextInt();
                    scanner.nextLine();

                    spaceMissionPlanner.removeSpacecraftWithID(userInput);
                    break;
                case 5:
                    clearScreen();
                    spaceMissionPlanner.showSpacecrafts();
                    break;
                case 6:
                    clearScreen();
                    spaceMissionPlanner.showMissions();
                    break;
                case 7:
                    clearScreen();
                    System.out.println("Enter spacecraft ID for show information: ");
                    userInput = scanner.nextInt();
                    scanner.nextLine();

                    spaceMissionPlanner.showSpacecraftWithID(userInput);
                    break;
                case 8:
                    clearScreen();
                    System.out.println("Enter spacecraft ID for show information: ");
                    userInput = scanner.nextInt();
                    scanner.nextLine();

                    spaceMissionPlanner.showMissionWithID(userInput);
                    break;
                case 9:
                    clearScreen();
                    operationsMenu();

                    userInput = scanner.nextInt();
                    scanner.nextLine();

                    switch(userInput){
                        case 1:
                            clearScreen();
                            spaceMissionPlanner.showSpacecrafts();
                            System.out.println("Enter spacecraft ID for assign: ");
                            userInput = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter mission ID for assign: ");
                            int missionInput = scanner.nextInt();
                            scanner.nextLine();

                            spaceMissionPlanner.setSpacecraftToMission(userInput,missionInput);
                            break;
                        case 2:
                            clearScreen();
                            System.out.println("Enter spacecraft ID for change statue: ");
                            userInput = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter spacecraft status\n1-Available 2-In Transit 3-In Operation 4-Maintenance\nSelect: ");
                            int statueType = scanner.nextInt();
                            scanner.nextLine();

                            spaceMissionPlanner.changeSpacecraftStatus(userInput,statueType);
                            break;
                        case 3:
                            clearScreen();
                            System.out.println("Enter mission ID for change statue: ");
                            userInput = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter spacecraft status\n1-Planned 2-In Progress 3-Completed 4-Failed\nSelect: ");
                            int statue = scanner.nextInt();
                            scanner.nextLine();

                            spaceMissionPlanner.changeMissionStatus(userInput,statue);
                            break;
                        case 4:
                            spacecraftMenu();
                            userInput = scanner.nextInt();
                            scanner.nextLine();

                            switch(userInput){
                                case 1:
                                    clearScreen();
                                    System.out.println("Enter mission ID for change statue: ");
                                    userInput = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Enter new spacecraft type: ");
                                    String newType = scanner.nextLine();

                                    spaceMissionPlanner.changeSpacecraftType(userInput,newType);
                                    break;
                                case 2:
                                    clearScreen();
                                    break;
                                default:
                                    clearScreen();
                                    System.out.println("Not valid operation input!");
                                    break;
                            }
                            clearScreen();
                            break;
                        case 5:
                            clearScreen();
                            missionMenu();
                            userInput = scanner.nextInt();
                            scanner.nextLine();

                            switch(userInput){
                                case 1:
                                    clearScreen();
                                    System.out.println("Enter mission ID for change name: ");
                                    userInput = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Enter new mission name: ");
                                    userStringInput=scanner.nextLine();

                                    spaceMissionPlanner.findMission(userInput).setMissionName(userStringInput);
                                    break;
                                case 2:
                                    clearScreen();
                                    System.out.println("Enter mission ID for change name: ");
                                    userInput = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Enter new launch date name: ");
                                    userStringInput=scanner.nextLine();

                                    spaceMissionPlanner.findMission(userInput).setLaunchDate(userStringInput);
                                    break;
                                case 3:
                                    clearScreen();
                                    System.out.println("Enter mission ID for change name: ");
                                    userInput = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Enter new destination name: ");
                                    userStringInput=scanner.nextLine();

                                    spaceMissionPlanner.findMission(userInput).setDestination(userStringInput);
                                    break;
                                case 4:
                                    clearScreen();
                                    System.out.println("Enter mission ID for start: ");
                                    userInput = scanner.nextInt();
                                    scanner.nextLine();

                                    spaceMissionPlanner.findMission(userInput).setStatus(MissionStatus.IN_PROGRESS);
                                    System.out.println("Mission: "+spaceMissionPlanner.findMission(userInput).getMissionName()+" has been started!");
                                    break;
                                case 5:
                                    clearScreen();
                                    System.out.println("Enter mission ID for finish: ");
                                    userInput = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Is mission finish successfully?[y/n]");
                                    char character = scanner.next().charAt(1);
                                    switch(character){
                                        case 'Y':
                                        case 'y':
                                            spaceMissionPlanner.findMission(userInput).getMissionSpacecraft().setStatus(SpacecraftStatus.IN_TRANSIT);
                                            spaceMissionPlanner.findMission(userInput).setStatus(MissionStatus.COMPLETED);
                                            break;
                                        case 'N':
                                        case 'n':
                                            spaceMissionPlanner.findMission(userInput).getMissionSpacecraft().setStatus(SpacecraftStatus.EXPLODE);
                                            spaceMissionPlanner.findMission(userInput).setStatus(MissionStatus.FAILED);
                                            break;
                                        default:
                                            clearScreen();
                                            System.out.println("Not valid operation input!");
                                            break;

                                    }

                                    System.out.println("Mission: "+spaceMissionPlanner.findMission(userInput).getMissionName()+" has been finished!");

                                    System.out.println("Do you want to remove mission from list?[y/n]");
                                    character = scanner.next().charAt(1);
                                    switch(character){
                                        case 'Y':
                                        case 'y':
                                            spaceMissionPlanner.removeMissionWithID(userInput);
                                            break;
                                        case 'N':
                                        case 'n':
                                            clearScreen();
                                            break;
                                        default:
                                            clearScreen();
                                            System.out.println("Not valid operation input!");
                                            break;

                                    }
                                    break;
                                case 6:
                                    clearScreen();
                                    break;
                                default:
                                    clearScreen();
                                    System.out.println("Not valid operation input!");
                                    break;
                            }
                            break;
                        case 6:
                            clearScreen();
                            break;
                        default:
                            System.out.println("Not valid operation input!");
                            break;
                    }
                    break;
                case 10:
                    clearScreen();
                    System.out.println("RocketX Control Center app is closing!");
                    exit=true;
                    break;
                default:
                    clearScreen();
                    System.out.println("Not valid operation input!");
                    break;
            }
        }

    }

    static void menu(){
        System.out.println("RocketX Control Center\n"
        +"1-Add Mission\n"
        +"2-Remove Mission\n"
        +"3-Add Spacecraft\n"
        +"4-Remove Spacecraft\n"
        +"5-Show All Spacecrafts\n"
        +"6-Show All Missions\n"
        +"7-Show Spacecraft with ID\n"
        +"8-Show Mission with ID\n"
        +"9-Mission Operations\n"
        +"10-Exit\n"
        +"Operation: ");

    }
    static void operationsMenu(){
        System.out.println("RocketX Control Center\n"
                +"1-Assign a spacecraft to mission\n"
                +"2-Update spacecraft status\n"
                +"3-Update mission status\n"
                +"4-Spacecraft operations\n"
                +"5-Mission operations\n"
                +"6-Exit\n"
                +"Operation: ");
    }
    static void spacecraftMenu(){
        System.out.println("1-Change Spacecraft Type\n"
                +"2-Exit\n"
                +"Operation: ");
    }
    static void missionMenu(){
        System.out.println("1-Change Mission Name\n"
                +"2-Change Launch Day\n"
                +"3-Change Destination\n"
                +"4-Start Mission\n"
                +"5-Finish Mission\n"
                +"6-Exit\n"
                +"Operation: ");
    }
    static SpaceMission newMission(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter mission ID: ");
        int missionID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter mission name: ");
        String missionName = scanner.nextLine();
        System.out.println("Enter mission launch date: ");
        String launchDate = scanner.nextLine();
        System.out.println("Enter mission destination: ");
        String destination = scanner.nextLine();


        return new SpaceMission(missionID,missionName,launchDate,destination);
    }

    static Spacecraft newSpacecraft(){
        Scanner scanner = new Scanner(System.in);
        SpacecraftStatus status=null;

        System.out.println("Enter spacecraft ID: ");
        int spacecraftID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter spacecraft capacity: ");
        int spacecraftCapacity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter spacecraft type: ");
        String spacecraftType = scanner.nextLine();

        return new Spacecraft(spacecraftID,spacecraftCapacity,spacecraftType);
    }
    static void clearScreen(){
        System.out.print("\033[H\033[2J");
    }

}
