import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
    /*
Project - BINGO!
Create a Bingo project. Within this project, we will have one class with the following methods:
a) izgenerisi() - this method should generate and return an array of 30 random numbers from 1 to 50.
b) unesiSvoje() - within this method, you should enter your 6 numbers for guessing (you can generate them using Random or input them via Scanner).
c) izvlacenje(int[] prviNiz, int[] drugiNiz) - you will input two previously generated arrays, and it will print a message indicating how many numbers were matched in total.
In the main method of the class, only call these three methods.

         */
        System.out.println("Dobro dosli! Pocinje Bingo!");
        int[] ucesnikovi = unesiSvoje();
        System.out.print("Vasi brojevi su: ");
        stampajNizRastuce(ucesnikovi);
        int[] izvuceni = izgenerisi();
        System.out.print("Izvuceni su brojevi: ");
        stampajNizRastuce(izvuceni);
        izvlacenje(ucesnikovi,izvuceni);

    }

    public static void stampajNizRastuce (int[]niz){
        Arrays.sort(niz);
        for(int element: niz){
            System.out.print(element + " ");
        }
        System.out.println();
    }



    public static int[] izgenerisi(){
        Random random = new Random();
        int[] nasumicni = new int[30];
        for(int i=0; i<30; i++){
            int broj = random.nextInt(1,51);
            if(imaLiGaUNIzu(broj, nasumicni)==true){
                i--;
                continue;
            }
            nasumicni[i]=broj;
        }
        return nasumicni;
    }


    public static void izvlacenje(int[] ucesnikovi, int[] izvuceni) {
        int brojac=0;
        for(int i=0; i<izvuceni.length; i++){
            for(int k=0; k<ucesnikovi.length; k++){
                if(ucesnikovi[k]==izvuceni[i]){
                    brojac++;
                }
            }
        }
        if(brojac==0){
            System.out.println("Zao nam, je niste pogodili nijedan broj!");
        } else {
            System.out.println("Broj pogodjenih brojeva je: " + brojac);
            int[] pogodjeni = new int[brojac];
            int j = 0;
            for (int i = 0; i < izvuceni.length; i++) {
                for (int k = 0; k < ucesnikovi.length; k++) {
                    if (ucesnikovi[k] == izvuceni[i]) {
                        pogodjeni[j] = ucesnikovi[k];
                        j++;
                    }
                }
            }
            System.out.print("Pogodili ste brojeve: ");
            stampajNizRastuce(pogodjeni);
            System.out.println("Cestitamo!");
        }
    }

    public static int[] unesiSvoje(){
        Scanner scanner = new Scanner(System.in);
        int[] mojiBrojevi = new int[6];
        System.out.println("Unesite 6 brojeva od 1 do 50!");
        for(int i=0; i<6; i++){
            System.out.println((i+1) + ". broj je: ");
            int broj = scanner.nextInt();
            if(broj<1 || broj>50){
                System.out.println("Niste uneli broj od 1 do 50! Unesite broj opet!");
                i--;
                continue;
            } else if(imaLiGaUNIzu(broj, mojiBrojevi)==true){
                System.out.println("Vec ste uneki taj broj! Unesite neki drugi!");
                i--;
                continue;
            }
            mojiBrojevi[i]=broj;
        }
        return mojiBrojevi;
    }

    public static boolean imaLiGaUNIzu(int broj, int[] niz){
        for(int i=0; i<niz.length; i++){
            if(broj==niz[i]){
                return true;
            }
        }
        return false;
    }
}


