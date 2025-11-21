
//import sektion
import java.text.NumberFormat;
import java.util.Scanner; //importerar scanner för att läsa data från användaren, dvs lägga till och ta ut pengar
import java.util.List;
import java.util.Locale;
//End import

public class BankApp { // huvudklass för bankappen
    public static float balance = 0.0f;
    public static Scanner input = new Scanner(System.in); // scanner för att läsa input från användaren
    public static List<Locale> bankCountries = List.of(
            Locale.forLanguageTag("sv-SE"),
            Locale.forLanguageTag("en-US"),
            Locale.forLanguageTag("de-DE"));
    public static NumberFormat currencyFormat; // ett valutaformat objekt för att visa värdena i valutaformat

    public static void deposit() {
        System.out.println("Ange belopp att sätta in:"); // frågar användaren hur mycket de vill sätta in
        float cashIn = input.nextFloat(); // läser in insättningsbeloppet
        if (cashIn > 0) { // kontrollerar att insättningsbeloppet är positivt
            balance += cashIn; // lägger till beloppet till saldot
        }
        System.out.println(currencyFormat.format(cashIn) + " har satts in på ditt konto."); // bekräftelsemeddelande som
                                                                                            // visar insatt belopp i
                                                                                            // valutaformat
    }

    public static void withdraw() {
        System.out.println("Ange belopp att ta ut:"); // frågar användaren hur mycket de vill ta ut
        float cash = input.nextFloat(); // läser in uttagsbeloppet
        if (cash > 0 && cash <= balance) { // kontrollerar att uttagsbeloppet är positivt och inte överstiger saldot
            balance -= cash; // drar av beloppet från saldot
            System.out.println(currencyFormat.format(cash) + " har tagits ut från ditt konto. Din nuvarande saldo är "
                    + currencyFormat.format(balance) + "."); // bekräftelsemeddelande som visar uttaget belopp i
                                                             // valutaformat
        } else {
            System.out.println("Otillräckligt saldo för detta uttag."); // meddelande om det inte finns tillräckligt med
                                                                        // pengar på kontot :/
        }
    }

    public static void getBalance() {
        System.out.println("Ditt nuvarande saldo är: " + currencyFormat.format(balance) + ".");
        // return balance; //returnerar det nuvarande saldot på kontot
    }

    public static void main(String[] args) {
        boolean languageSelected = false; // boolean för att kontrollera om användaren har valt språk
        int val; // variabel för att hålla användares "val" i minne

        while (!languageSelected) { // loop för att säkerställa att användaren väljer ett giltigt språk
            System.out.println("Välkommen till Svordaloz Bank! Vilket land är du i från?"); // meddelande visas varje
                                                                                            // gång loopen körs
            System.out.println("1. Sverige");
            System.out.println("2. USA");
            System.out.println("3. Tyskland");
            System.out.println("Ange ett av de tillgängliga valen:");
            val = input.nextInt(); // läser in användarens val
            switch (val) { // switch sats för att hantera användarens val
                case 1:
                    currencyFormat = NumberFormat.getCurrencyInstance(bankCountries.get(0));
                    languageSelected = true;
                    break;
                case 2:
                    currencyFormat = NumberFormat.getCurrencyInstance(bankCountries.get(1));
                    languageSelected = true;
                    break;
                case 3:
                    currencyFormat = NumberFormat.getCurrencyInstance(bankCountries.get(2));
                    languageSelected = true;
                    break;
                default:
                    break;
            }
        }
        boolean running = true; // boolean som håller igång appen när den används
        while (running) { // loop som håller appen igång medan den är i bruk
            System.out.println("1. Visa saldo"); // View Balance
            System.out.println("2. Sätt in belopp"); // Deposit Money
            System.out.println("3. Ta ut belopp"); // Withdraw Money
            System.out.println("4. Avsluta"); // Exit
            // användaren får fyra valmöjligheter, sätta in, ta ut, visa saldo eller avslut

            System.out.println("Ange ett av de tillgängliga valen:");
            val = input.nextInt(); // läser in användarens input
            switch (val) { // switch sats för att hantera användarens val
                case 1: // om användaren väljer 1
                    getBalance();
                    break;
                case 2: // om användaren väljer 2
                    deposit();
                    break;
                case 3: // om användaren väljer 3
                    withdraw();
                    break;
                case 4: // om användaren väljer 4
                    System.out.println("Tack för att du använde Svordaloz Bank! Ha en bra dag!"); // avslutningsmeddelande
                    running = false; // sätter running till false för att avsluta loopen och därmed appen
                    break;
                default: // om användaren anger ett ogiltigt val
                    System.out.println("Ogiltigt val. Vänligen försök igen."); // meddelande om ogiltigt val
                    break;
            }
        }
        input.close(); // stänger scannern när appen avslutas
        System.exit(0); // avslutar programmet
    }
}