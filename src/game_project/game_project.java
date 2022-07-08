package game_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.Math;
import java.nio.charset.StandardCharsets;

public class game_project {
	
	private static boolean devam = false;
	public static void main (String[] args) throws IOException 
	{
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Kelime girmek için G / Kelimeyi tahmin etmek için T yazınız.");
		
		String yanit = scanner.next();
		
	while(true)
	{
	
		boolean devam = false;
		
	if(yanit.equals("G") || yanit.equals("g"))
	{
	
		Scanner scan = new Scanner(System.in);
		
		//Değişkenler
		
		int i;
		int tahmin = 0;
		int kontrol = 0;
		int dogru = 0;
		boolean k = false;
		
		//Harf Sayısı Girişi
		
		System.out.println("Harf sayısını giriniz: ");
		
		
		int harf_sayisi = getRandomInteger(22,1);
		System.out.println(harf_sayisi);
		
		readfile(harf_sayisi);
		
		//Kelime Girişi
		
		System.out.println("\nKelime gir");
		
		String kelime = scan.next();
		
		//Alt Çizgilerin Sayısı
		
		String bulunan[] = new String[kelime.length()];
		
		BufferedReader klavye = new BufferedReader(new InputStreamReader(System.in));
		
		for(i= 0; i<kelime.length(); i++)
		{
			bulunan[i] = "_ ";
		}
		
		finish:
	
			
		while(tahmin<11)
		{
		//Harf Tahmini
			
			System.out.println("\nHarf Tahmin Edin: ");
			char harf = getRandomLowerCaseLetter();
			tahmin++;
			
			for(i=0; i<kelime.length(); i++)
			{
				if(kelime.charAt(i) == harf)
				{
					bulunan[i] = harf + " ";
					kontrol = 1;
					dogru++;
					
					//Oyunu Kazanma
					if(dogru == kelime.length())
					{
						for(int j=0; j<kelime.length(); j++)
						{
							System.out.print(kelime.charAt(j) + " ");
						}
						System.out.println("\n\nTebrikler, oyunu kazandınız!");
						break finish;
					}
					
				}
			}
			if(kontrol == 1)
			{
				kontrol = 0;
				tahmin--;
			}
			for(i = 0; i<kelime.length(); i++)
			{
				System.out.print(bulunan[i]);
			}
		}
		
		//Oyunu Kaybetme
		if(dogru != kelime.length())
		{
			System.out.println("Oyunu kaybettiniz.");
		}
		
	
	}
		else if(yanit.equals("T") || yanit.equals("t"))
		{
			
				Scanner scan = new Scanner(System.in);
				
				//Değişkenler
				
				int i;
				int tahmin = 0;
				int kontrol = 0;
				int dogru = 0;
				boolean k = false;
				
				//Harf Sayısı Girişi
				
				System.out.println("Harf sayısını giriniz: ");
				
				while(k==false )
				{
					int harf_sayisi = scan.nextInt();
					
				if(harf_sayisi>1 && harf_sayisi<22 )
				{
					
					readfile(harf_sayisi);
					k = true;
				}
				else
				{
					System.out.println("Lütfen 2 ile 21 arasında bir sayı giriniz");
					k = false;
					System.out.println("Harf sayısını giriniz: ");
				}
				}
				int harf_sayisi = scan.nextInt();
				
				//Kelime Girişi
				
				System.out.println("\nKelime gir");
				
				String kelime = null;
				
				kelime = random(kelime);
				
				
				//Alt Çizgilerin Sayısı
				
				String bulunan[] = new String[kelime.length()];
				
				BufferedReader klavye = new BufferedReader(new InputStreamReader(System.in));
				
				for(i= 0; i<kelime.length(); i++)
				{
					bulunan[i] = "_ ";
				}
				
				finish:
			
					
				while(tahmin<11)
				{
				//Harf Tahmini
					
					System.out.println("\nHarf Tahmin Edin: ");
					String harf = klavye.readLine();
					tahmin++;
					
					for(i=0; i<kelime.length(); i++)
					{
						if(kelime.charAt(i) == harf.charAt(0))
						{
							bulunan[i] = harf + " ";
							kontrol = 1;
							dogru++;
							
							//Oyunu Kazanma
							if(dogru == kelime.length())
							{
								for(int j=0; j<kelime.length(); j++)
								{
									System.out.print(kelime.charAt(j) + " ");
								}
								System.out.println("\n\nTebrikler, oyunu kazandınız!");
								break finish;
							}
							
						}
					}
					if(kontrol == 1)
					{
						kontrol = 0;
						tahmin--;
					}
					for(i = 0; i<kelime.length(); i++)
					{
						System.out.print(bulunan[i]);
					}
				}
				
				//Oyunu Kaybetme
				if(dogru != kelime.length())
				{
					System.out.println("Oyunu kaybettiniz.");
				}
				
		}	
			
		//Yeni Oyuna Başlama veya Bitirme		
		System.out.println("Devam etmek ister misiniz?    Y / N");


		Scanner sca = new Scanner(System.in);
		String cevap = sca .next();
		if(cevap.equals("Y") || cevap.equals("y"))
		{
		devam = true;
		}
		else if(cevap.equals("N") || cevap.equals("n"))
		{
		System.out.println("Programdan çıkılıyor.");
		devam = false;
		
		}
		else
		{
		System.out.println("Tanımsız kelime girişi yaptınız.");
		
		}
	}
			
}

	
	 public static char getRandomCharacter(char ch1, char ch2) 
	 {
	        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
	   }
	 public static char getRandomLowerCaseLetter() {
	        return getRandomCharacter('a', 'z');
	    }
	
	public static int getRandomInteger(int max, int min) 
	{
		
		return((int) (Math.random()*(max - min))) + min;

	}

	public static int readfile (int harf_sayisi) throws IOException
	{
		
		File file = new File("C:/Users/kiki1/OneDrive/Masaüstü/turkish_dictionary.txt");
		/*BufferedReader reader = new BufferedReader(new FileReader("C:/Users/kiki1/OneDrive/Masaüstü/turkish_dictionary.txt")); int liness = 0; while (reader.readLine() != null) liness++; reader.close();
		
		int random = (int)(Math.random() * liness);
		String line32 = Files.readAllLines(Paths.get("C:/Users/kiki1/OneDrive/Masaüstü/turkish_dictionary.txt")).get(random);
		
		String p = Integer.toString(liness);
		
		String[] u = line32.split(" ");
		String satirr = u[0];*/
		
		FileReader fReader = new FileReader(file);
		
		String line;
		try (BufferedReader bReader = new BufferedReader(fReader)) {
			while ((line = bReader.readLine()) != null)
			{
				String[] lines = line.split(" ");
				
				String satir = lines[0];
				
				
				switch(harf_sayisi)
				{
				
				case 2:
					if(satir.length() == 2)
					{
					System.out.println(satir);
					}
					break;
				case 3:
					if(satir.length() == 3)
					{
					
					System.out.println(satir);
					}
					break;
				
			
				case 4:
					if(satir.length() == 4)
					{
					System.out.println(satir);
					}
					break;
					
				case 5:
					if(satir.length() == 5)
					{
					System.out.println(satir);				
					}
					break;
					
				case 6:
					if(satir.length() == 6)
					{
					System.out.println(satir);
					}
					break;
				case 7:
					if(satir.length() == 7)
					{
					System.out.println(satir);
					}
					break;
				case 8:
					if(satir.length() == 8)
					{
					System.out.println(satir);					
					}
					break;
				case 9:
					if(satir.length() == 9)
					{
					System.out.println(satir);
					}
					break;
				case 10:
					if(satir.length() == 10)
					{
					System.out.println(satir);
					}
					break;
				case 11:
					if(satir.length() == 11)
					{
					System.out.println(satir);
					}
					break;
				case 12:
					if(satir.length() == 12)
					{
					System.out.println(satir);
					}
					break;
				case 13:
					if(satir.length() == 13)
					{
					System.out.println(satir);
					}
					break;
				case 14:
					if(satir.length() == 14)
					{
					System.out.println(satir);
					}
					break;
				case 15:
					if(satir.length() == 15)
					{
					System.out.println(satir);
					}
					break;
				case 16:
					if(satir.length() == 16)
					{
					System.out.println(satir);
					}
					break;
				case 17:
					if(satir.length() == 17)
					{
					System.out.println(satir);
					}
					break;
				case 18:
					if(satir.length() == 18)
					{
					System.out.println(satir);
					}
					break;
				case 19:
					if(satir.length() == 19)
					{
					System.out.println(satir);
					}
					break;
				case 20:
					if(satir.length() == 20)
					{
					System.out.println(satir);
					}
					break;
				case 21:
					if(satir.length() == 21)
					{
					System.out.println(satir);
					}
					break;
					
				}
				
			}
			
		}
		
		return harf_sayisi;
		
		
	}
	
	public static String random(String kelime) throws IOException
	{
		File file = new File("C:/Users/kiki1/OneDrive/Masaüstü/turkish_dictionary.txt");
		BufferedReader reader = new BufferedReader(new FileReader("C:/Users/kiki1/OneDrive/Masaüstü/turkish_dictionary.txt")); int liness = 0; while (reader.readLine() != null) liness++; reader.close();
		
		int random = (int)(Math.random() * liness);
		System.out.println(random);
		String line32 = Files.readAllLines(Paths.get("C:/Users/kiki1/OneDrive/Masaüstü/turkish_dictionary.txt")).get(random);
		
		String p = Integer.toString(liness);
		
		String[] u = line32.split(" ");
		String satirr = u[0];
		
		
		return satirr;
		
		
	}
}

