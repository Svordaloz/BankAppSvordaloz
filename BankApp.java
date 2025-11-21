//import sektion
import java.util.Scanner; //importerar scanner för att läsa data från användaren, dvs lägga till och ta ut pengar
//End import

public class BankApp { //huvudklass för bankappen
     public static float balance = 0.0f;
     public static void putIn(float cashIn) {
            if (cashIn > 0) { //kontrollerar att insättningsbeloppet är positivt
                balance += cashIn; //lägger till beloppet till saldot
            }
        }

        public static boolean takeOut(float cash) {
            if (cash > 0 && cash <= balance) { //kontrollerar att uttagsbeloppet är positivt och inte överstiger saldot
                balance -= cash; //drar av beloppet från saldot
                return true; //returnerar true om uttaget lyckades
            } else {
                return false; //returnerar false om uttaget misslyckades
            }
        }

        public static float getBalance() {
            return balance; //returnerar det nuvarande saldot på kontot
        }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //scanner för att läsa input från användaren
        boolean running = true; //boolean som håller igång appen när den används

        //NumberFormat valutaformat = NumberFormat.getCurrencyInstance(); //ett valutaformat objekt för att visa värdena i valutaformat
        int val; //variabel för att hålla användares "val" i minnet
        System.out.println("Välkommen till Svordaloz Bank! Vad vill du göra idag?"); //meddelande visas varje gång loopen körs
        while (running) { //loop som håller appen igång medan den är i bruk
            System.out.println("1. Visa saldo"); // View Balance
            System.out.println("2. Sätt in belopp"); // Deposit Money
            System.out.println("3. Ta ut belopp"); // Withdraw Money
            System.out.println("4. Avsluta"); // Exit
        //användaren får fyra valmöjligheter, sätta in, ta ut, visa saldo eller avslut
            
        System.out.println("Ange ett av de tillgängliga valen:");
        val = input.nextInt(); //läser in användarens input
        switch (val) { //switch sats för att hantera användarens val
            case 1: //om användaren väljer 1
                System.out.println("Ditt nuvarande saldo är: " + getBalance() + " kronor."); //visar användarens nuvarande saldo i valutaformat
                break;
            case 2: //om användaren väljer 2
                System.out.println("Ange belopp att sätta in:"); //frågar användaren hur mycket de vill sätta in
                float cashIn = input.nextFloat(); //läser in insättningsbeloppet
                putIn(cashIn); //anropar metoden sättIn från BankKonto klassen för att lägga till pengar på kontot
                System.out.println(cashIn + " kronor har satts in på ditt konto."); //bekräftelsemeddelande som visar insatt belopp i valutaformat
                break;
            case 3: //om användaren väljer 3
                System.out.println("Ange belopp att ta ut:"); //frågar användaren hur mycket de vill ta ut
                float cashOut = input.nextFloat(); //läser in uttagsbeloppet
                if (takeOut(cashOut)) { //anropar metoden taUt från BankKonto klassen för att ta ut pengar från kontot, om möjligt, annars visas ett felmeddelande
                    System.out.println(cashOut + " kronor har tagits ut från ditt konto. Din nuvarande saldo är " + getBalance() + " kronor."); //bekräftelsemeddelande som visar uttaget belopp i valutaformat
                } else {
                    System.out.println("Otillräckligt saldo för detta uttag."); //meddelande om det inte finns tillräckligt med pengar på kontot :/
                }
                break;
            case 4: //om användaren väljer 4
                System.out.println("Tack för att du använde Svordaloz Bank! Ha en bra dag!"); //avslutningsmeddelande
                running = false; //sätter running till false för att avsluta loopen och därmed appen
                break;
            default: //om användaren anger ett ogiltigt val
                System.out.println("Ogiltigt val. Vänligen försök igen."); //meddelande om ogiltigt val
                break;
            }
        }
        input.close(); //stänger scannern när appen avslutas
        System.exit(0); //avslutar programmet
    }
}