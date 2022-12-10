package odev1;

public class Personel extends Departman{
	
	public Personel(int depNo, String depAd,String perAd, String perSoyad, int perYas) {
		super(depNo, depAd);
		setPerAd(perAd);
		setPerSoyad(perSoyad);
		setPerYas(perYas);
		setPerId();
	}
	public static int perID=0;
	
	private int depNo;
	private int perId;
	private String perAd;
	private String perSoyad;
	private int perYas;
	
	public int getPerId() {
		return perId;
	}
	public void setPerId() {
		this.perId = ++perID;
	}
	public String getPerAd() {
		return perAd;
	}
	public void setPerAd(String perAd) {
		this.perAd = perAd;
	}
	public String getPerSoyad() {
		return perSoyad;
	}
	public void setPerSoyad(String perSoyad) {
		this.perSoyad = perSoyad;
	}
	public int getPerYas() {
		return perYas;
	}
	public void setPerYas(int perYas) {
		this.perYas = perYas;
	}
	
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo() {
		this.depNo = super.getDepNo();
	}
	
}
