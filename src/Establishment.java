public class Establishment {
    private String name;
    private String firstLineAddress;
    private String postCode;
    private int maxOccupancy;


    Establishment(String name, String firstLineAddress, String postCode, int maxOccupancy){
        this.name = name;
        this.firstLineAddress = firstLineAddress;
        this.postCode = postCode;
        this.maxOccupancy = maxOccupancy;
    }
     Establishment(String name, String[] address, int maxOccupancy){
        this.name = name;
        this.firstLineAddress = address[0];
        this.postCode = address[1];
        this.maxOccupancy = maxOccupancy;
    }

    /*for retrieve*/
    public String getName() {
        return name;
    }
    public String getFirstLineAddress() {
        return firstLineAddress;
    }
    public String getPostCode() { return postCode; }
    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void behaviour(){
        System.out.println("Name: "+getName()+","+"\n"+"Address: "+getFirstLineAddress()+" "+getPostCode());
    }


    public static void main(String[] args) {
        Establishment e1 = new Establishment("Some Coffee House","1 King Street","FA1 3KE",5);
//        Establishment e2 = new Establishment("Some Restaurant Place",new String[]{"1 Queen Street","FA2 3KE"},15);
//        Establishment e3 = new Establishment("Some Book Place","1 Regal Street","FA4 3KE",20);


//        e1.behaviour();

    }
}
