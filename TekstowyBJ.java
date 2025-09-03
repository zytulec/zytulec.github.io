package inne;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TekstowyBJ {

	public static void main(String[] args) {
		String[] talia = {"2","2","2","2","2","2","2","2","2","2","2","2","3","3","3","3","3","3","3","3","4","4","4","4","4","4","4","4","5","5","5","5","5","5","5","5","6","6","6","6","6","6","6","6",
				"7","7","7","7","7","7","7","7","8","8","8","8","8","8","8","8","9","9","9","9","9","9","9","9","10","10","10","10","10","10","10","10","J","J","J","J","J","J","J","J","Q","Q","Q","Q","Q","Q","Q","Q",
				"K","K","K","K","K","K","K","K","A","A","A","A","A","A","A"};
		ArrayList<String> Gracz = new ArrayList<String>();
		ArrayList<String> Dealer = new ArrayList<String>();
		ArrayList<String> Split1 = new ArrayList<String>();
		ArrayList<String> Split2 = new ArrayList<String>();
		Random r = new Random();
		int losowa;
		int tura = 0;
		int turaD = 0;
		String hit = "hit";
		String stay = "stay";
		String duble = "double";
		String split = "split";
		Scanner tak = new Scanner(System.in);
		
losowa=r.nextInt(talia.length);	
while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
Gracz.add(talia[losowa]);
talia[losowa]="0";

losowa=r.nextInt(talia.length);	
while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
Dealer.add(talia[losowa]);
talia[losowa]="0";

losowa=r.nextInt(talia.length);	
while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
Gracz.add(talia[losowa]);
talia[losowa]="0";





while (oblicz(Gracz)<21 && tura==0) {
	System.out.println(Dealer);
	System.out.println(Gracz);
	String rzecz = tak.next();
	if (rzecz.equals(stay)) {tura=10;}
	else if (rzecz.equals(hit)) {
	losowa=r.nextInt(talia.length);
	while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
	Gracz.add(talia[losowa]);
	talia[losowa]="0";
	if (oblicz(Gracz)>21) {
		turaD++;
	}
	}
	else if (rzecz.equals(duble)) {
		losowa=r.nextInt(talia.length);
		while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
		Gracz.add(talia[losowa]);
		talia[losowa]="0";
		tura = 10;
	}
	else if (rzecz.equals(split)) {
	if (Gracz.get(0).equals(Gracz.get(1))){
	Split1.add(Gracz.get(0));
	Split2.add(Gracz.get(1));
	tura=10;
	}
	else {System.out.println("Nie");
	tura = 0;
	System.out.println(tura);
	System.out.println();
	}}}


while (oblicz(Split1)>0 && oblicz(Split1)<21 && tura==10) {
	System.out.println(Dealer);
	System.out.println(Split1 + "     " + Split2);
	String rzecz = tak.next();
	if (rzecz.equals(stay)) {tura=100;}
	else if (rzecz.equals(hit)) {
	losowa=r.nextInt(talia.length);
	while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
	Split1.add(talia[losowa]);
	talia[losowa]="0";
	if (oblicz(Split1)>21) {
		turaD++;
	}
	}
	else if (rzecz.equals(duble)) {
		losowa=r.nextInt(talia.length);
		while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
		Split1.add(talia[losowa]);
		talia[losowa]="0";
		tura = 10;}
	}
while (oblicz(Split2)>0 && oblicz(Split2)<21 && (tura==10 || tura==100)) {
	System.out.println(Dealer);
	System.out.println(Split1 + "     " + Split2);
	String rzecz = tak.next();
	if (rzecz.equals(stay)) {tura=1000;}
	else if (rzecz.equals(hit)) {
	losowa=r.nextInt(talia.length);
	while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
	Split2.add(talia[losowa]);
	talia[losowa]="0";
	if (oblicz(Split2)>21) {
		turaD++;
	}
	}
	else if (rzecz.equals(duble)) {
		losowa=r.nextInt(talia.length);
		while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
		Split2.add(talia[losowa]);
		talia[losowa]="0";
		tura = 10;}
	}
	

	
	System.out.println(Dealer);
	System.out.println();
	System.out.println(Gracz);
	System.out.println("--------");


while (oblicz(Dealer)<18&& turaD==0) {
	losowa=r.nextInt(talia.length);	
	while (talia[losowa]=="0") {losowa=r.nextInt(talia.length);}
	Dealer.add(talia[losowa]);
	talia[losowa]="0";
	
	System.out.println(Dealer);
	System.out.println();
	if (oblicz(Split1)==0)System.out.println(Gracz);
	if (oblicz(Split1)<0)System.out.println(Split1 + "     " + Split2);
	System.out.println("--------");
}
if (oblicz(Split1)==0) {
	if (turaD == 1 && oblicz(Split1)==0)System.out.println("Przegrana - Mia³eœ za du¿o");
	else if (turaD == 0 && oblicz(Dealer)>21) System.out.println("Wygrana - Dealer mia³ za du¿o");
	else if (turaD == 0 && oblicz(Dealer)>oblicz(Gracz)) System.out.println("Przegra³eœ - Dealer mia³ wiêcej");
	else if (turaD == 0 && oblicz(Dealer)<oblicz(Gracz)) System.out.println("Wygra³eœ - Mia³eœ wiêcej od dealera");
	else if (turaD == 0 && oblicz(Dealer)==oblicz(Gracz)) System.out.println("Remis - mieliœcie po tyle samo");}
if (oblicz(Split1)>0) {	
	if (turaD == 1 && oblicz(Split1)>0)System.out.println("Gra 1 - Przegrana - Mia³eœ za du¿o");
	else if (turaD == 0 && oblicz(Dealer)>21) System.out.println("Gra 1 - Wygrana - Dealer mia³ za du¿o");
	else if (turaD == 0 && oblicz(Dealer)>oblicz(Split1)) System.out.println("Gra 1 - Przegra³eœ - Dealer mia³ wiêcej");
	else if (turaD == 0 && oblicz(Dealer)<oblicz(Split1)) System.out.println("Gra 1 - Wygra³eœ - Mia³eœ wiêcej od dealera");
	else if (turaD == 0 && oblicz(Dealer)==oblicz(Split1)) System.out.println("Gra 1 - Remis - mieliœcie po tyle samo");
	
	if (turaD == 1 && oblicz(Split2)>0)System.out.println("Gra 2 - Przegrana - Mia³eœ za du¿o");
	else if (turaD == 0 && oblicz(Dealer)>21) System.out.println("Gra 2 - Wygrana - Dealer mia³ za du¿o");
	else if (turaD == 0 && oblicz(Dealer)>oblicz(Split2)) System.out.println("Gra 2 - Przegra³eœ - Dealer mia³ wiêcej");
	else if (turaD == 0 && oblicz(Dealer)<oblicz(Split2)) System.out.println("Gra 2 - Wygra³eœ - Mia³eœ wiêcej od dealera");
	else if (turaD == 0 && oblicz(Dealer)==oblicz(Split2)) System.out.println("Gra 2 - Remis - mieliœcie po tyle samo");

	}}

public static int oblicz(ArrayList<String> karty) {
	int wynik=0;
	String sprawdzam;
	int asy=0;
	for (int i = 0;i < karty.size(); i++) {
	sprawdzam = karty.get(i);
	if (sprawdzam=="2")wynik = wynik + 2;
	if (sprawdzam=="3")wynik = wynik + 3;
	if (sprawdzam=="4")wynik = wynik + 4;
	if (sprawdzam=="5")wynik = wynik + 5;
	if (sprawdzam=="6")wynik = wynik + 6;
	if (sprawdzam=="7")wynik = wynik + 7;
	if (sprawdzam=="8")wynik = wynik + 8;
	if (sprawdzam=="9")wynik = wynik + 9;
	if (sprawdzam=="10")wynik = wynik + 10;
	if (sprawdzam=="J")wynik = wynik + 10;
	if (sprawdzam=="K")wynik = wynik + 10;
	if (sprawdzam=="Q")wynik = wynik + 10;
	if (sprawdzam=="A")wynik = wynik + 11;
	if (sprawdzam=="A")asy++;
	}
	while(wynik>21&&asy>0) {
	wynik=wynik-10;
	asy--;
	}
	return(wynik);
	}

}




