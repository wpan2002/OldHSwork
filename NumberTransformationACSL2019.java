import java.util.Scanner;
class Main {
  public static void main(String[] args) {
  encode(); 
encode(); 
encode(); 
encode(); 
encode(); 
}
  public static void encode() {
String revNString = "";
String outp1 = "";
String pValString ="";
String outp1a = "";
int pVal = 0;
int rev = 0;
int dig =0;
int revN = 0;
Scanner scan = new Scanner(System.in);
String inpN ="";
int inpP = 0;
int nString = 0;
System.out.println("Please type in a positive integer");
inpN = scan.nextLine();
System.out.println("Please type a position in that integer");
inpP = scan.nextInt();
revNString =inpN;
inpP = revNString.length() - inpP;

pValString = revNString.substring(inpP, inpP + 1);

pVal = Integer.parseInt(pValString); 
for (int i = 0; i < inpP; i++){
outp1 = outp1 + Integer.toString((((Integer.parseInt(revNString.substring(i, i + 1))) + pVal) % 10));
}
for (int i = inpP +1; i < revNString.length(); i++){
outp1a = outp1a + Integer.toString(Math.abs(Integer.parseInt(revNString.substring(i, i + 1)) - pVal));
}
System.out.println(outp1 + pValString + outp1a);
  }
  }