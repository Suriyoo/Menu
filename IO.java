import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class IO {
    private ArrayList<Establishment> establishment;
    private ArrayList<Event> event;
    private final Controller controller;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    IO( ArrayList<Establishment> establishment, ArrayList<Event> event) {
        this.establishment = establishment;
        this.event = event;
        this.controller = new Controller(establishment,event);
    }

    public ArrayList<Establishment> getEstablishment() {
        return establishment;
    }
    public ArrayList<Event> getEvent() {
        return event;
    }
    public Controller getController() {
        return controller;
    }

    /*transform format of input date*/
    public static String date(){
        int year;
        int month;
        int day;
        System.out.println("Enter a  year: ");
        Scanner scanner = new Scanner(System.in);
        year = scanner.nextInt();

        System.out.println("Enter a Month: ");
        Scanner scanner1 = new Scanner(System.in);
        month = scanner1.nextInt();

        System.out.println("Enter a Day: ");
        Scanner scanner2 = new Scanner(System.in);
        day = scanner2.nextInt();

        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dob = date.format(dtf);

        return dob;
    }
    public static LocalDate stringToLocalDate(String str) {
        LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return localDate;
    }
    public static String checkDate(String dob){
        LocalDate today = LocalDate.now();
        DateTimeFormatter FM = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(dob,FM);
        if(today.isAfter(birthday)){
            return "valid input, please continue";
        }
        else{
            return "invalid input";
        }
    }
    public static String checkDate2(){
        String db;
        while (1==1) {
            db = date();
            System.out.println(checkDate(db));
            if (checkDate(db).equals("invalid input")) {
                System.out.println("Please input the date again");
                continue;
            } else {
                break;
            }
        }
       return db;
    }
    public StringBuffer getAge(String db){
        LocalDate dob = stringToLocalDate(db);
        Period p1 = Period.between(dob, LocalDate.now());
        StringBuffer s = new StringBuffer();
        StringBuffer age = s.append(p1.getYears());
        return age;
    }
    public static String checkEmail() {
        String email;
        Scanner se = new Scanner(System.in);
        while (1 == 1) {
            email = se.next();
            if (email.contains("@")) {
                break;
            } else {
                System.out.println("invalid input");
                System.out.println("Please input your email again");
                continue;
            }
        }
        return email;
    }
    public static String checkPhone(){
        boolean pnum;
        String phoneNumber;
        while (1==1){
            Scanner pnumber = new Scanner(System.in);
            phoneNumber = pnumber.next();
            pnum = phoneNumber.matches("\\d{11}$");
            if(pnum == true){
                break;
            }
            else {
                System.out.println("invalid input");
                System.out.println("Please input your contact number again");
                continue;
            }
        }
        return phoneNumber;
    }
    public String getEventTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String eventTime=sdf.format(new Date());
        return eventTime;
    }

    /*Records by Establishment*/
    public void rebe(String ename){
        int s = 1;
        System.out.println("-- Establishment "+ename + " Record --");
        for(Event est:event) {
            if (est.getEstablishment().getName().equals(ename)) {
                System.out.println("  "+"[Record "+s+"]");
                System.out.println("Name " + est.getUser().getName() + "\n" + "Date of Birth " + est.getUser().getDob() + "\n" + "Email " + est.getUser().getEmailaddress() + "\n" + "Contact Number " + est.getUser().getPhonenumber() + "\n" + "Age " + (est.getUser()).getAge() + "\n" + "Date " + est.getEventDate() + "\n" + "Time " + est.getEventTime() + "\n" + "Party Size " + est.getPartyNumber() + "\n" + "Establishment" + "\n" + "Name: " + est.getEstablishment().getName() + "," + "\n" + "Address: " + est.getEstablishment().getFirstLineAddress());
                s++;
            }else {
            }

            }
    }
    /*Records by Name*/
    public void rena(String name){
        int s= 0;
        System.out.println("-- "+name + "'s Event Records --");
        for(Event est:event) {
            if (est.getUser().getName().equals(name)) {
                s = s+1;
                System.out.println("  "+"[Record "+s+"]");
                System.out.println("Name " + est.getUser().getName() + "\n" + "Date of Birth " + est.getUser().getDob() + "\n" + "Email " + est.getUser().getEmailaddress() + "\n" + "Contact Number " + est.getUser().getPhonenumber() + "\n" + "Age " + (est.getUser()).getAge() + "\n" + "Date " + est.getEventDate() + "\n" + "Time " + est.getEventTime() + "\n" + "Party Size " + est.getPartyNumber() + "\n" + "Establishment" + "\n" + "Name: " + est.getEstablishment().getName() + "," + "\n" + "Address: " + est.getEstablishment().getFirstLineAddress());
            }else {
            }

        }
    }
    /*Records by Date*/
    public void reda(LocalDate c){
        int s = 0;
        System.out.println("-- Event Records " +c+ " --");
        for(Event est:event) {
            if (est.getEventDate().equals(c)) {
                s++;
                System.out.println("  "+"[Record "+s+"]");
                System.out.println("Name " + est.getUser().getName() + "\n" + "Date of Birth " + est.getUser().getDob() + "\n" + "Email " + est.getUser().getEmailaddress() + "\n" + "Contact Number " + est.getUser().getPhonenumber() + "\n" + "Age " + (est.getUser()).getAge() + "\n" + "Date " + est.getEventDate() + "\n" + "Time " + est.getEventTime() + "\n" + "Party Size " + est.getPartyNumber() + "\n" + "Establishment" + "\n" + "Name: " + est.getEstablishment().getName() + "," + "\n" + "Address: " + est.getEstablishment().getFirstLineAddress());
            }else {
            }

        }
    }

    public void menu() {
            Scanner x = new Scanner(System.in);
            int n = 0;
            boolean flag = true;
            int a;
            while(flag){
                do{
                    System.out.println("Menu");
                    System.out.println("1.Record an Event");
                    System.out.println("2.Add Establishment");
                    System.out.println("3.Filters");
                    System.out.println("4.Print Events");
                    System.out.println("5.Print Establishment");
                    System.out.println("6.Exit the program");
                    System.out.println("Please choose an option");
                    while(!x.hasNextInt()){
                        System.out.println("Wrong input!");
                        x.next();
                        System.out.println("Please choose an option again");
                    }
                    a = x.nextInt();
                }while(a<0);

            switch (a) {
                case 1:
                    System.out.println("You have selected option 1");
                    System.out.println("Please record your information here");
                    System.out.println("Name: ");
                    Scanner s1 = new Scanner(System.in);
                    String name = s1.next();

                    System.out.println("Date of Birth: ");
                    String db = checkDate2();

                    System.out.println("Email: ");
                    String email = checkEmail();

                    System.out.println("Contact Number: ");
                    String cno = checkPhone();

                    System.out.println("Address: ");
                    Scanner s4 = new Scanner(System.in);
                    String address = s4.next();

                    System.out.println("Establishment: ");
                    Scanner s5 = new Scanner(System.in);
                    String establishment1 = s5.next();

                    System.out.println("Date: ");
                    LocalDate date = stringToLocalDate(checkDate2());

                    System.out.println("PartyNumber: ");
                    Scanner s6 = new Scanner(System.in);
                    int pn = s6.nextInt();
                    int o = 1619713100+n;

                    System.out.println("Event ID: "+o + " | " + "Recorded User" + "\n" + "Name " + name + "\n" + "Date of Birth " + db + "\n" + "Email " +email+ "\n" + "Contact Number "+cno + "\n" + "Age "+getAge(db)+"\n"+"Date "+date.format(formatter)+"\n"+"Time "+getEventTime()+"\n"+"Party Size "+pn+"\n"+"Establishment"+"\n"+"Name: "+name+","+"\n"+"Address: "+address);
                    Establishment ee = new Establishment(establishment1,address, "FA4 3KE", 20);
                    User u = new User(name,stringToLocalDate(db),email,cno);
                    Event ev = new Event(u,LocalDate.now(),pn,ee);//record a new event
                    controller.addEvent(event,ev);
                    n = n+1;
                    continue;

                case 2:
                    System.out.println("You have selected option 2");
                    System.out.println("Please record your information here");
                    System.out.println("Address: ");
                    Scanner sc1 = new Scanner(System.in);
                    String address2 = sc1.next();

                    System.out.println("Establishment: ");
                    Scanner sc2 = new Scanner(System.in);
                    String establishment2 = sc2.next();

                    System.out.println("Post Code: ");
                    Scanner sc3 = new Scanner(System.in);
                    String postCode = sc3.next();

                    System.out.println("Max Occupancy: ");
                    Scanner sc4 = new Scanner(System.in);
                    int maxOccupancy = sc4.nextInt();

                    Establishment ee2 = new Establishment(establishment2,address2, postCode, maxOccupancy);
                    controller.addEstablishment(establishment,ee2);//record a new establishment
                    continue;

                case 3:
                    Scanner y = new Scanner(System.in);
                    while (a == 3) {
                        System.out.println("Welcome to sub-menu Filters");
                        System.out.println("1.Records by Establishment");
                        System.out.println("2.Records by Date");
                        System.out.println("3.Records by Name");
                        System.out.println("4.Go Back");
                        System.out.println("please choose an option");
                        int choice = y.nextInt();
                        if (choice == 1) {
                            System.out.println("You have selected option 1");
                            /*I'm not sure whether I should finish Section 3 first before looking into Section 4.
                            And there seemed no prompt that I can skip the sub-menu, therefore, I did it twice.
                            As i don't know the expected output format of the sub-menu requirements in Section3,
                            so the first three lines are based on my understanding. */
                           rebe("Some Coffee House");
                           rebe("Some Restaurant Place");
                           rebe("Some Book Place");

                           System.out.println("Please input an establishment name");
                           getController().filterEventByEstablishments();
                           break;
                        }
                        if (choice == 2) {
                            System.out.println("You have selected option 2");
                            LocalDate c = LocalDate.of(2011,7,14);
                            LocalDate c1 = LocalDate.of(2015,1,30);
                            LocalDate c2 = LocalDate.of(2019,9,4);
                             /*Same reason*/
                            reda(c);
                            reda(c1);
                            reda(c2);

                            System.out.println("Please input an event date");
                            getController().filterEventByDate(checkDate2());
                            break;
                        }
                        if (choice == 3) {
                            System.out.println("You have selected option 3");
                             /*Same*/
                            rena("Suri Zhou");
                            rena("zack Walter");
                            rena("Aria King");
                            rena("Mike Belton");
                            rena("Rinbow Zhang");

                            getController().filterEventByUser();
                            break;
                        }
                        if (choice == 4) {
                            System.out.println("Go back to Menu now...");
                            break;
                        } else {
                            System.out.println("Not a valid input, please choose again!");
                            continue;
                        }
                    }
                    continue;
                case 4:
                    System.out.println("You have selected option 4");
                    int k = 0;
                        for(Event stmp:getEvent()) {
                            int id = 1619713100+k;
                            k=k+1;
                            System.out.println("-- Event "+k+" --");
                            System.out.println("Event ID: "+id+" | "+"Recorded User"+"\n"+"Name "+stmp.getUser().getName()+"\n"+"Date of Birth "+stmp.getUser().getDob()+"\n"+"Email "+stmp.getUser().getEmailaddress()+"\n"+"Contact Number "+stmp.getUser().getPhonenumber()+"\n"+"Age "+(stmp.getUser()).getAge()+"\n"+"Date "+stmp.getEventDate()+"\n"+"Time "+stmp.getEventTime()+"\n"+"Party Size "+stmp.getPartyNumber()+"\n"+"Establishment"+"\n"+"Name: "+stmp.getEstablishment().getName()+","+"\n"+"Address: "+stmp.getEstablishment().getFirstLineAddress());
                }
                    continue;
                case 5:
                    System.out.println("You have selected option 5");
                    int m = 0;
                    for(Establishment ep:getEstablishment()){
                        m = m+1;
                        System.out.println("-- Establishment "+m+" --");
                        System.out.println("Name: "+ep.getName()+","+"\n"+"Address: "+ep.getFirstLineAddress()+" "+ep.getPostCode());
                    }
                    continue;
                case 6:
                    System.out.println("You have selected option 6");
                    System.out.println("Exiting now...");
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input, please input again!");
                    continue;
            }
           }
        }
    private void debug(Establishment e1, Event ev2){
        /*hard code several user objects*/
        LocalDate l1 = LocalDate.of(2001,6,3);
        User ul1 = new User("Mike Belton",l1,"mmmmike@outlook.com","070273542911");
        LocalDate l2 = LocalDate.of(1992,11,22);
        User ul2 = new User("Rinbow Zhang",l2,"zzhzzang@gmail.com","52734290064");

        Establishment esl1 = new Establishment("Some Restaurant Place","1 Queen Street","FA2 3KE",15);
        Establishment esl2 = new Establishment("Central Stadium",new String[]{"55 Fake Street","FW4 9AK"},200);

        /*hard code several event objects with establishment objects*/
        LocalDate l3 = LocalDate.of(2019,12,29);
        LocalDate l4 = LocalDate.of(2017,5,11);
        Event evl1 = new Event(ul1,l3,3,e1);
        Event evl2 = new Event(ul2,l4,6,esl1);
        Event evl3 = new Event(ul2,l4,35,esl2);

        controller.addEstablishment(establishment,esl1);
        controller.addEstablishment(establishment,esl2);
        controller.addEstablishment(establishment,e1);
        System.out.println(controller.getEstablishment());

        controller.addEvent(event,evl1);
        controller.addEvent(event,evl2);
        controller.addEvent(event,evl3);
        controller.addEvent(event,ev2);
        System.out.println(controller.getEvent());
    }

    public static void main(String[] args) {
        ArrayList<Establishment> establishment = new ArrayList<Establishment>();
        Establishment e1 = new Establishment("Some Coffee House","1 King Street","FA1 3KE",5);
        Establishment e2 = new Establishment("Some Restaurant Place","1 Queen Street","FA2 3KE",15);
        Establishment e3 = new Establishment("Some Book Place","1 Regal Street","FA4 3KE",20);
        establishment.add(e1);
        establishment.add(e2);
        establishment.add(e3);

        LocalDate b = LocalDate.of(1999,2,19);
        User u = new User("Suri Zhou",b,"suri@gmail.com","01296471148");
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
        event.add(ev4);


        IO i = new IO(establishment,event);
        i.menu();

        new IO(establishment,event).debug(e1,ev2);






    }
}