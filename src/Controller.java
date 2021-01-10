import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class Controller{
    ArrayList<Establishment> establishment = new ArrayList<>();
    ArrayList<Event> event = new ArrayList<>();
    private String establishmentCSVFileURI;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    Controller(ArrayList<Establishment> establishment, ArrayList<Event> event) {
        this.establishment = establishment;
        this.event = event;
    }

    Controller(String establishmentCSVFileURI) {
        this.establishmentCSVFileURI = establishmentCSVFileURI;
    }

    /*for retrieve*/
    public ArrayList<Establishment> getEstablishment() {
        return establishment;
    }
    public ArrayList<Event> getEvent() {
        return event;
    }
    public String getEstablishmentCSVFileURI() {
        return establishmentCSVFileURI;
    }

    /*add an Establishment object to the list of establishments, if the object already exists then return false*/
    public static boolean addEstablishment(ArrayList<Establishment> establishment, Establishment es) {
        boolean add;
        if (es == establishment.get(0) || es == establishment.get(1) || es == establishment.get(2)) {//Determine whether the newly added element is duplicated with the existing element
            add = false;
            System.out.println("Failed");
        } else {
            add = true;
            establishment.add(es);
            System.out.println("Establishment Added");
        }
        return add;//if the object already exists will return false
    }

    /*add an Event object to the list of establishments, if the object already exists then return false*/
    public static boolean addEvent(ArrayList<Event> event, Event ev) {
        boolean add1 = true;
        for(int i = 0;i<event.size();i++){
            if(ev == event.get(i)){//Determine whether the newly added element is duplicated with the existing element
                add1 = false;
                System.out.println("Failed");
            }
            else{
                continue;
            }
        }
        if(add1 == true){
            event.add(ev);
            System.out.println("Event Added");
            return add1;
        }
        else {
            return add1;//if the object already exists will return false
        }
    }

    /*parse a csv file with the given format, and store the values as an appropriate object*/
    private ArrayList <String> recordCSV(File name) throws FileNotFoundException {
        /*record an csv file*/
        ArrayList<String> records = new ArrayList<>();//record every single line of the csv file
        Scanner s = new Scanner(name);//scan csv file
        while(s.hasNextLine()){//Determine whether there will be a next line or not
            records.add(s.nextLine());//store the values in csv file as an ArrayList
        }
        /*parse an csv file*/
        for(int i =0; i<records.size(); i++){
            System.out.println(records.get(i));
        }
        return records;
    }

    /*filter the events and present the users who have visited a given establishment by String input of an Establishments name.*/
    public void filterEventByEstablishments() {
        Scanner ses = new Scanner(System.in);
        String eName = ses.nextLine();
        int a = 0;
        Event recordEv;
        System.out.println("-- Establishment " + eName + " --");
        for(int w = 0; w < event.size(); w++) {//events selected by establishments
            recordEv = event.get(w);
            String Rename = recordEv.getEstablishment().getName();
            if (Rename.equals(eName)) {
                a = a + 1;
                System.out.println("  " + "[Record " + a + "]");
                System.out.println("Name " + recordEv.getUser().getName() + "\n" + "Date of Birth " + recordEv.getUser().getDob() + "\n" + "Email " + recordEv.getUser().getEmailaddress() + "\n" + "Contact Number " + recordEv.getUser().getPhonenumber() + "\n" + "Age " + (recordEv.getUser()).getAge() + "\n" + "Date " + recordEv.getEventDate() + "\n" + "Time " + recordEv.getEventTime() + "\n" + "Party Size " + recordEv.getPartyNumber() + "\n" + "Establishment" + "\n" + "Name: " + recordEv.getEstablishment().getName() + "," + "\n" + "Address: " + recordEv.getEstablishment().getFirstLineAddress());
            } else {
                continue;
            }
        }

    }
    /*filter events that occurred at a given date by String input of a valid date format of dd/mm/yyyy*/
    public void filterEventByDate(String db){
        int a = 0;
        Event recordEv;
        System.out.println("-- Event Records " + db + " --");
        for(int w = 0; w < event.size(); w++) {//events selected by establishments
            recordEv = event.get(w);
            String eDate = recordEv.getEventDate().format(formatter);
            if (eDate.equals(db)) {
                a = a + 1;
                System.out.println("  " + "[Record " + a + "]");
                System.out.println("Name " + recordEv.getUser().getName() + "\n" + "Date of Birth " + recordEv.getUser().getDob() + "\n" + "Email " + recordEv.getUser().getEmailaddress() + "\n" + "Contact Number " + recordEv.getUser().getPhonenumber() + "\n" + "Age " + (recordEv.getUser()).getAge() + "\n" + "Date " + recordEv.getEventDate() + "\n" + "Time " + recordEv.getEventTime() + "\n" + "Party Size " + recordEv.getPartyNumber() + "\n" + "Establishment" + "\n" + "Name: " + recordEv.getEstablishment().getName() + "," + "\n" + "Address: " + recordEv.getEstablishment().getFirstLineAddress());
            } else {
                continue;
            }
        }

    }
    /*filter events that a user have been recorded at by String input of a valid name and email address*/
    public void filterEventByUser() {
        System.out.println("Please input an user's name");
        Scanner ses = new Scanner(System.in);
        String uName = ses.nextLine();
        System.out.println("Please input an user's email address");
        String uEmailAddress = ses.next();
        int a = 0;
        Event recordEv;
        System.out.println("--"+ uName+"'s Event --");
        for (int w = 0; w < event.size(); w++) {//events selected by establishments
            recordEv = event.get(w);
            String Rename = recordEv.getUser().getName();
            String Remail = recordEv.getUser().getEmailaddress();
            if (Rename.equals(uName) && Remail.equals(uEmailAddress)) {
                a = a + 1;
                System.out.println("  " + "[Record " + a + "]");
                System.out.println("Name " + recordEv.getUser().getName() + "\n" + "Date of Birth " + recordEv.getUser().getDob() + "\n" + "Email " + recordEv.getUser().getEmailaddress() + "\n" + "Contact Number " + recordEv.getUser().getPhonenumber() + "\n" + "Age " + (recordEv.getUser()).getAge() + "\n" + "Date " + recordEv.getEventDate() + "\n" + "Time " + recordEv.getEventTime() + "\n" + "Party Size " + recordEv.getPartyNumber() + "\n" + "Establishment" + "\n" + "Name: " + recordEv.getEstablishment().getName() + "," + "\n" + "Address: " + recordEv.getEstablishment().getFirstLineAddress());
            } else {
                continue;
            }
        }
    }

//    @Override
//    public String toString() {
//        return "Controller{" +
//                "establishment=" + establishment +
//                ", event=" + event +
//                ", establishmentCSVFileURI='" + establishmentCSVFileURI + '\'' +
//                '}';
//    }

        public static void main (String[]args) throws FileNotFoundException {
            ArrayList<Establishment> establishment = new ArrayList<Establishment>();
            Establishment e1 = new Establishment("Some Coffee House", "1 King Street", "FA1 3KE", 5);
            Establishment e2 = new Establishment("Some Restaurant Place", "1 Queen Street", "FA2 3KE", 15);
            Establishment e3 = new Establishment("Some Book Place", "1 Regal Street", "FA4 3KE", 20);
            establishment.add(e1);
            establishment.add(e2);
            establishment.add(e3);


            Establishment e4 = new Establishment("Some Fancy Park", "2 James Street", "NE9 5BF", 30);

            LocalDate b = LocalDate.of(1999, 2, 19);
            User u = new User("Suri Zhou", b, "suri@gmail.com", "01296471148");
            LocalDate b1 = LocalDate.of(2001,6,3);
            User u1 = new User("zack Walter",b1,"zack@outlook.com","09741262073");
            LocalDate b2 = LocalDate.of(1992,11,22);
            User u2 = new User("Aria King",b2,"aria@gmail.com","97821647524");

            ArrayList<Event> event = new ArrayList<Event>();
            LocalDate c = LocalDate.of(2011,7,14);
            LocalDate c1 = LocalDate.of(2015,1,30);
            LocalDate c2 = LocalDate.of(2019,9,4);
            Event ev1 = new Event(u,c,4,e1);
            Event ev2 = new Event(u1,c1,9,e2);
            Event ev3 = new Event(u2,c2,5,e3);
            Event ev4 = new Event(u1,c1,8,e1);

            event.add(ev1);
            event.add(ev2);
            event.add(ev3);

            Controller controller = new Controller(establishment, event);

            /*read and record a csv file*/
//            File name = new File(Controller.class.getResource("establishments.csv").getFile());
//            controller.recordCSV(name);

//            controller.addEstablishment(establishment, e4);
//            controller.addEstablishment(establishment, e2);

//            controller.addEvent(event, ev3);
//            controller.addEvent(event,ev4);

        }

}
