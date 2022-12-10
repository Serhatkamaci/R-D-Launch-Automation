package odev1;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) {
		
		int departmanSayisi;
		
		Scanner input= new Scanner(System.in);
		
		System.out.print("Departman Sayisini Giriniz --> ");
		departmanSayisi=input.nextInt();
		
		Departman[] departmanlar=new Departman[departmanSayisi];
		
		int depNo;
		String depAd;
		int personel;
		
		String perAd;
		String perSoyad;
		int perYas;
		
		int projeSayisi;
		String projeAd;
		int projeSure;
		int projeMaliyet;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			
			System.out.print(i+1+". Departman Adı --> ");
			depAd=input.next();
			input.nextLine();
			System.out.print(i+1+". Departman No --> ");
			depNo=input.nextInt();
			
			departmanlar[i]=new Departman(depNo, depAd);
			
			System.out.print("Personel Sayisi --> ");
			personel=input.nextInt();
			departmanlar[i].personeller=new Personel[personel];
			
			
			for(int j=0;j<personel;j++)
			{
				System.out.print(j+1 +". Personel'in Adi --> ");
				perAd=input.next();
				input.nextLine();
				System.out.print(j+1 +". Personel'in Soyadi --> ");
				perSoyad=input.next();
				
				System.out.print(j+1+". Personel'in Yasi --> ");
				perYas=input.nextInt();
				
				departmanlar[i].personeller[j]=new Personel(depNo, depAd, perAd, perSoyad, perYas);
			}
						
			System.out.print(depAd+" Departmanin Proje Sayisi --> ");
			projeSayisi=input.nextInt();
			departmanlar[i].projeler=new Proje[projeSayisi];
			
			for(int j=0;j<projeSayisi;j++)
			{
				System.out.print(depAd+" Departmani'nin "+ (j+1)+". "+ "Proje Adi --> ");
				projeAd=input.next();
				input.nextLine();
				System.out.print(depAd+" Departmani'nin "+ (j+1)+". "+ "Proje Suresi --> ");
				projeSure=input.nextInt();
		
				System.out.print(depAd+" Departmani'nin "+ (j+1)+". "+ " Proje Maliyeti --> ");
				projeMaliyet=input.nextInt();
				
				if(projeMaliyet<0)
				{
					System.out.println("Proje Maaliyeti 0'dan Kucuk Olamaz!");
					projeMaliyet=input.nextInt();
				}
				else
				{
					departmanlar[i].projeler[j]=new Proje(depNo, depAd, projeAd, projeSure,projeMaliyet);
				}
			}	
		}
		
		int indis=2;
		int secim;
		
		while(indis>1)
		{
			System.out.print("\n\nTüm Departmanların Bilgilerini Listele -->(1)\n");
			System.out.print("Departman Adına Göre Arama Yap -->(2)\n");
			System.out.print("Personel Adına Göre Arama Yap -->(3)\n");
			System.out.print("Proje Adına Göre Arama Yap -->(4)\n");
			System.out.print("Yaş Bilgisine Göre Personelleri Bul -->(5)\n");
			System.out.print("Yaş Bilgisine Göre Personelleri Analiz Et -->(6)\n");
			System.out.print("Proje Süresine Göre Projeleri Bul -->(7)\n");
			System.out.print("Proje Maliyetine Göre Projeleri Bul -->(8)\n");
			System.out.print("Proje Maliyetine Göre Projeleri Analiz Et -->(9)\n");
			System.out.print("Çıkış -->(10)\n\n");
			
			System.out.print("Yukaridaki Bilgilere Gore Seciminizi Yapiniz --> ");
			secim=input.nextInt();
			
			switch (secim) {
			case 1: {
				DepartmanBİlgileri(departmanlar, departmanSayisi);
				break;
			}
			case 2: {
				String aranacak;
				System.out.print("Aranacak Departman Ismini Giriniz --> ");
				aranacak=input.next();
				DepartmanAra(departmanlar, aranacak, departmanSayisi);
				break;
			}
			case 3: {
				System.out.print("Aranacak Personel Ismini Giriniz --> ");
				perAd=input.next();
				PersonelAdiArama(departmanlar, perAd, departmanSayisi);
				break;
			}
			case 4: {
				System.out.print("Aranacak Proje Adini Giriniz --> ");
				projeAd=input.next();
				ProjeAdiArama(departmanlar, projeAd, departmanSayisi);
				break;
			}
			case 5: {
				System.out.print("Listelenecek Personel Yasini Giriniz --> ");
				perYas=input.nextInt();
				YasBilgisiPersonelSorgula(perYas, departmanlar, departmanSayisi);
				break;
			}
			case 6: {
				PersonelAnalizEt(departmanlar, departmanSayisi);
				break;
			}
			case 7: {
				System.out.print("Listelenecek Proje Suresini Giriniz --> ");
				projeSure=input.nextInt();
				ProjeSuresiProjeBul(projeSure, departmanlar);
				break;
			}
			case 8: {
				System.out.print("Listelenecek Proje Maaliyetini Giriniz --> ");
				projeMaliyet=input.nextInt();
				ProjeMaaliyetiProjeBul(projeMaliyet, departmanlar);
				break;
			}
			case 9: 
			{
				ProjeMaaliyetiAnalizEt(departmanlar);
				break;
			}
			case 10:
			{
				System.out.println("Ar-Ge Firmasi Uygulamasindan Cikis Yapiliyor ...");
				System.out.println("Uygulamadan Cikis Yapildi :) ");
				return;
			}
			default:
				System.out.println("Yanlis Secim Yaptiniz");
				System.out.println("Menudeki Numaralara Gore Bir Secim Yapabilirsiniz :) ");
			}
		}
	}
	
	public static void DepartmanBİlgileri(Departman departmanlar[], int departmanSayisi) {
		int projeSayisi;
		int personelSayisi;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			System.out.println("\n---------------------------------------------");
			System.out.print("Deparman No: "+departmanlar[i].getDepNo()+"  ");
			System.out.println("Deparman Ad: "+departmanlar[i].getDepAd());
			System.out.println("Personeller: ");
			
			projeSayisi=departmanlar[i].projeler.length;
			personelSayisi=departmanlar[i].personeller.length;
			
			for(int j=0;j<personelSayisi;j++)
			{
				System.out.print(j+1+"."+"Personel: "+departmanlar[i].personeller[j].getPerId()+" "+departmanlar[i].personeller[j].getPerAd()+" "+departmanlar[i].personeller[j].getPerSoyad()+" "+departmanlar[i].personeller[j].getPerYas()+"\n");
			}
			for(int j=0;j<projeSayisi;j++)
			{
				System.out.print(j+1+"."+"Proje: "+departmanlar[i].projeler[j].getProjeId()+" "+departmanlar[i].projeler[j].getProjeAd()+" "+departmanlar[i].projeler[j].getProjeSure()+" "+departmanlar[i].projeler[j].getProjeMaliyet()+"\n");
			}
			System.out.println("\n---------------------------------------------");
		}
		
	}
	
	public static void PersonelAdiArama(Departman[] departmanlar, String perAd, int departmanSayisi)
	{
		int personelSayisi;
		int x=0;
		for(int i=0;i<departmanSayisi;i++)
		{
			personelSayisi=departmanlar[i].personeller.length;
			
			for(int j=0;j<personelSayisi;j++)
			{
				if(departmanlar[i].personeller[j].getPerAd().equals(perAd))
				{
					System.out.println("\n---------------------------------------------");
					System.out.println("Departman: "+departmanlar[i].getDepAd());
					System.out.print(j+1+"."+"Personel: "+departmanlar[i].personeller[j].getPerId()+" "+departmanlar[i].personeller[j].getPerAd()+" "+departmanlar[i].personeller[j].getPerSoyad()+" "+departmanlar[i].personeller[j].getPerYas()+"\n");
					System.out.println("---------------------------------------------\n");
					x=1;
				}
			}
			if(x==0)
			{
				System.out.println("Ar-Ge firmasinda "+perAd+" adinda bir personel bulunmamaktadir!");
			}
		}
	}
	
	public static void DepartmanAra(Departman[] departmanlar,String depAd, int departmanSayisi)
	{
		int personelSayisi;
		int x=0;
		int projeSayisi;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			if(departmanlar[i].getDepAd().equals(depAd))
			{
				System.out.println("\n---------------------------------------------");
				x=1;
				System.out.print("Deparman No: "+departmanlar[i].getDepNo()+"  ");
				System.out.println("Deparman Ad: "+departmanlar[i].getDepAd());
				System.out.println("Personeller: ");
				personelSayisi=departmanlar[i].personeller.length;
		
				for(int j=0;j<personelSayisi;j++)
				{
					System.out.print(j+1+"."+"Personel: "+departmanlar[i].personeller[j].getPerId()+" "+departmanlar[i].personeller[j].getPerAd()+" "+departmanlar[i].personeller[j].getPerSoyad()+" "+departmanlar[i].personeller[j].getPerYas()+"\n");
				}
				
				projeSayisi=departmanlar[i].projeler.length;
				
				System.out.println("Projeler: ");
				
				for(int j=0;j<personelSayisi;j++)
				{	
					System.out.print(j+1+"."+"Proje: "+departmanlar[i].projeler[j].getProjeId()+" "+departmanlar[i].projeler[j].getProjeAd()+" "+departmanlar[i].projeler[j].getProjeSure()+" "+departmanlar[i].projeler[j].getProjeMaliyet());
				}
				System.out.println("\n---------------------------------------------");
			}
		}
		if(x==0)
		{
			System.out.println("\nAr-Ge firmasinda "+depAd+" adinda bir departman bulunmamaktadir!");
		}
	}
	
	public static void ProjeAdiArama(Departman[] departmanlar,String projeAdi, int departmanSayisi)
	{
		int projeSayisi;
		int x=0;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			projeSayisi=departmanlar[i].projeler.length;
			
			for(int j=0;j<projeSayisi;j++)
			{
				if(departmanlar[i].projeler[j].getProjeAd().equals(projeAdi))
				{	
					x=1;
					System.out.println("\n---------------------------------------------");
					System.out.println(j+1+"."+"Proje Departman Adi: "+departmanlar[i].getDepAd());
					System.out.print(j+1+"."+"Proje: "+departmanlar[i].projeler[j].getProjeId()+" "+departmanlar[i].projeler[j].getProjeAd()+" "+departmanlar[i].projeler[j].getProjeSure()+" "+departmanlar[i].projeler[j].getProjeMaliyet()+"\n");	
					System.out.println("\n---------------------------------------------");
				}
			}	
		}
		if(x==0)
		{
			System.out.println("\nAr-Ge firmasinda "+projeAdi+" adinda bir proje bulunmamaktadir!");
		}
	}
	
	public static void YasBilgisiPersonelSorgula(int yas, Departman[] departmanlar, int departmanSayisi)
	{
		int uzunluk;
		int x=0;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			uzunluk=departmanlar[i].personeller.length;
			
			for(int j=0;j<uzunluk;j++)
			{
				if(departmanlar[i].personeller[j].getPerYas()==yas)
				{
					x=1;
					System.out.println("\n---------------------------------------------");
					System.out.println(j+1+"."+"Personelin Departman Adi: "+departmanlar[i].getDepAd());
					System.out.print(j+"."+"Personel: "+departmanlar[i].personeller[j].getPerId()+" "+departmanlar[i].personeller[j].getPerAd()+" "+departmanlar[i].personeller[j].getPerSoyad()+" "+departmanlar[i].personeller[j].getPerYas()+"\n");
					System.out.println("\n---------------------------------------------");
				}
			}
		}
		if(x==0)
		{
			System.out.println("\nAr-Ge firmasinda "+yas+" yasinda bir personel bulunmamaktadir!");
		}
	}
	
	public static void PersonelAnalizEt(Departman[] departmanlar, int departmanSayisi)
	{
		int uzunluk;
		int syc=0;  // 20-30
		int syc2=0; // 31-40
		int syc3=0;	// 41-50
		int syc4=0; // 50>
		double toplam=0;
		int kisiSayisi=0;
		double ort;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			uzunluk=departmanlar[i].personeller.length;
			
			for(int j=0;j<uzunluk;j++)
			{
				if(departmanlar[i].personeller[j].getPerYas()<20)
				{
					kisiSayisi+=1;
					toplam+=departmanlar[i].personeller[j].getPerYas();
				}
				else if(departmanlar[i].personeller[j].getPerYas()<31)
				{
					syc++;
					toplam+=departmanlar[i].personeller[j].getPerYas();
					kisiSayisi+=1;
				}
				else if(departmanlar[i].personeller[j].getPerYas()<41)
				{
					syc2++;
					toplam+=departmanlar[i].personeller[j].getPerYas();
					kisiSayisi+=1;
				}
				else if(departmanlar[i].personeller[j].getPerYas()<50)
				{
					syc3++;
					toplam+=departmanlar[i].personeller[j].getPerYas();
					kisiSayisi+=1;
				}
				else if(departmanlar[i].personeller[j].getPerYas()>50)
				{
					syc4++;
					toplam+=departmanlar[i].personeller[j].getPerYas();
					kisiSayisi+=1;
				}
			}
		}
		
		ort=toplam/kisiSayisi;
		System.out.println("\n---------------------------------------------");
		System.out.println("20-30 Araligindaki Personel Sayisi: "+syc);
		System.out.println("31-40 Araligindaki Personel Sayisi: "+syc2);
		System.out.println("41-50 Araligindaki Personel Sayisi: "+syc3);
		System.out.println(">50  Personel Sayisi: "+syc4);
		System.out.println("Tum Personellerin Yas Ortalamasi: "+ort);
		System.out.println("\n---------------------------------------------");
	}
	
	public static void ProjeSuresiProjeBul(int projeSuresi, Departman[] departmanlar)
	{
		int departmanSayisi;
		int projeSayisi;
		int x=0;
		
		departmanSayisi=departmanlar.length;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			projeSayisi=departmanlar[i].projeler.length;
			
			for(int j=0;j<projeSayisi;j++)
			{
				if(departmanlar[i].projeler[j].getProjeSure()==projeSuresi)
				{
					x=1;
					System.out.println("\n---------------------------------------------");
					System.out.println(j+1+"."+" Projenin Departman Adi: "+departmanlar[i].getDepAd());
					System.out.println(j+1+"."+" Proje Id: "+departmanlar[i].projeler[j].getProjeId());
					System.out.println(j+1+"."+" Proje Adi: "+departmanlar[i].projeler[j].getProjeAd());
					System.out.println(j+1+"."+" Proje Suresi: "+departmanlar[i].projeler[j].getProjeSure());
					System.out.println(j+1+"."+" Proje Maaliyeti: "+departmanlar[i].projeler[j].getProjeMaliyet());
					System.out.println("\n---------------------------------------------");
				}
			}	
		}
		if(x==0)
		{
			System.out.println("\nAr-Ge firmasinda "+projeSuresi+" süresinde bir proje bulunmamaktadir!");
		}
	}
	
	public static void ProjeMaaliyetiProjeBul(int projeMaaliyeti, Departman[] departmanlar)
	{
		int departmanSayisi;
		int projeSayisi;
		int x=0;
		int tut;
		
		departmanSayisi=departmanlar.length;
		
		for(int i=0;i<departmanSayisi;i++)
		{
			projeSayisi=departmanlar[i].projeler.length;
			
			for(int j=0;j<projeSayisi;j++)
			{
				if(departmanlar[i].projeler[j].getProjeMaliyet()==projeMaaliyeti)
				{
					x=1;
					System.out.println("\n---------------------------------------------");
					System.out.println(j+1+"."+" Projenin Departman Adi: "+departmanlar[i].getDepAd());
					System.out.println(j+1+"."+" Proje Id: "+departmanlar[i].projeler[j].getProjeId());
					System.out.println(j+1+"."+" Proje Adi: "+departmanlar[i].projeler[j].getProjeAd());
					System.out.println(j+1+"."+" Proje Suresi: "+departmanlar[i].projeler[j].getProjeSure());
					System.out.println(j+1+"."+" Proje Maaliyeti: "+departmanlar[i].projeler[j].getProjeMaliyet());
					System.out.println("\n---------------------------------------------");
				}
			}	
		}
		if(x==0)
		{
			System.out.println("\nAr-Ge firmasinda "+projeMaaliyeti+" maaliyetinde bir proje bulunmamaktadir!");
		}
	}
	
	public static void ProjeMaaliyetiAnalizEt(Departman[] departmanlar)
	{
		int departmanSayisi;
		int toplam=0;
		double ort;	
		int projeSayisi;
		int x=0;
		int indis=0;
		int tut;
		departmanSayisi=departmanlar.length;
		
		for(int i=0;i<departmanSayisi;i++)
		{	
			projeSayisi=departmanlar[i].projeler.length;

			for(int j=0;j<projeSayisi;j++)
			{
				x+=1; 
			}
		}
			
		int[] maliyetler=new int[x];
		
		for(int i=0;i<departmanSayisi;i++)
		{	
			projeSayisi=departmanlar[i].projeler.length;

			for(int j=0;j<projeSayisi;j++)
			{
				maliyetler[indis]=departmanlar[i].projeler[j].getProjeMaliyet();
				toplam+=maliyetler[indis];
				indis+=1;
			}
		}
		
		for(int i=1;i<x;i++)
		{	
			if(maliyetler[i-1]>maliyetler[i])
			{
				tut=maliyetler[i-1];
				maliyetler[i-1]=maliyetler[i];
				maliyetler[i]=tut;
			}
			
		}
		
		if(x==0)
		{
			System.out.println("Ar-Ge firmasinda proje olmadigi icin maaliyet analizi yapilamaz!");
		}
		
		else
		{
			ort=toplam/x;
		
			System.out.println("En Yuksek Maaliyet --> "+maliyetler[x-1]);
			System.out.println("En dusuk Maaliyet --> "+maliyetler[0]);
			System.out.println("Tum Projelerin Ortalamasi --> "+ort);	
		}
	}	
}
