import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Event {
    private User user;
    private String eventTime;
    private LocalDate eventDate;
    private int partyNumber;
    private Establishment establishment;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    Event(User user, LocalDate eventDate, int partyNumber, Establishment establishment){
        this.user = user;
        this.eventDate = eventDate;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    Event(User user, int partyNumber, Establishment establishment ){
        this.user = user;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    /*for retrieve*/
    public User getUser() {
        return user;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public String getEventTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        eventTime=sdf.format(new Date());
        return eventTime;
    }
    public int getPartyNumber() {
        return partyNumber;
    }
    public Establishment getEstablishment() {
        return establishment;
    }

    public void behaviour(){
        System.out.println("Event ID: 1619713100"+" | "+"Recorded User"+"\n"+"Name "+user.getName()+"\n"+"Date of Birth "+user.getDob().format(formatter)+"\n"+"Email "+user.getEmailaddress()+"\n"+"Contact Number "+user.getPhonenumber()+"\n"+"Age "+user.getAge()+"\n"+"Date "+getEventDate().format(formatter)+"\n"+"Time "+getEventTime()+"\n"+"Party Size "+getPartyNumber()+"\n"+"Establishment"+"\n"+"Name: "+establishment.getName()+","+"\n"+"Address: "+establishment.getFirstLineAddress());
    }

    public static void main(String[] args) {
        Establishment e1 = new Establishment("Some Coffee House","1 King Street","FA1 3KE",5);
//        Establishment e2 = new Establishment("Some Restaurant Place",new String[]{"1 Queen Street","FA2 3KE"},15);
//        Establishment e3 = new Establishment("Some Book Place","1 Regal Street","FA4 3KE",20);

        LocalDate b = LocalDate.of(1999,2,19);
        User u = new User("Suri Zhou",b,"suri@gmail.com","01296471148");
//        LocalDate b1 = LocalDate.of(2001,6,3);
//        User u1 = new User("zack Walter",b1,"zack@outlook.com","09741262073");
//        LocalDate b2 = LocalDate.of(1992,11,22);
//        User u2 = new User("Aria King",b2,"aria@gmail.com","97821647524");

        LocalDate c = LocalDate.of(2011,7,14);
//        LocalDate c1 = LocalDate.of(2015,1,30);
//        LocalDate c2 = LocalDate.of(2019,9,4);
        Event ev1 = new Event(u,c,4,e1);
//        Event ev2 = new Event(u1,c1,9,e2);
//        Event ev3 = new Event(u2,c2,5,e3);
//        Event ev4 = new Event(u1,c1,8,e1);

//        ev1.behaviour();

    }
}
