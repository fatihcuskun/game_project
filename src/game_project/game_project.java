package game_project;
import java.util.Scanner;

public class game_project {
	
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Harf sayısını giriniz: ");
		
		int harf_sayisi = scan.nextInt();
		
		String[] kelime = new String[harf_sayisi];
		
		kelime[0] = "a";
		
		System.out.println(kelime[0]);
		
		
	}   
}
