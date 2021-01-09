import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class User {
    private LocalDate dob;
    private String name;
    private String emailaddress;
    private String phonenumber;//it may start with 0, so don't use int type
    private StringBuffer age;


    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");//transform the input date format

    User(String name, LocalDate dob,String emailaddress, String phonenumber){

        this.name = name;
        this.dob = dob;
        this.emailaddress = emailaddress;
        this.phonenumber = phonenumber;
        this.age = getAge();
    }


    public void singleLine() {
        System.out.println(name + " | " + "Contact number " + phonenumber);
    }

    /*for retrieve*/
    public StringBuffer getAge(){
        Period p1 = Period.between(dob, LocalDate.now());
        StringBuffer s = new StringBuffer();
        age = s.append(p1.getYears());
        return age;
    }
    public String getName() {
        return name;
    }
    public LocalDate getDob() {
        return dob;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public String getEmailaddress() {
        return emailaddress;
    }

    public void behaviour() {
        System.out.println("Name "+getName()+"\n"+"Date of Birth "+getDob().format(formatter)+"\n"+"Email "+getEmailaddress()+"\n"+"Contact Number "+getPhonenumber()+"\n"+"Age "+getAge());
    }

    public static void main(String[] args){

        LocalDate b = LocalDate.of(1999,2,19);
        User u = new User("Suri Zhou",b,"suri@gmail.com","01296471148");

//        u.behaviour();
//        u.singleLine();



    }
}
