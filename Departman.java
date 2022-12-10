package odev1;

public class Departman {
	private int depNo;
	private String depAd;
	public Personel[] personeller;
	public Proje[] projeler;
	
	public Departman(int depNo, String depAd)
	{
		setDepAd(depAd);
		setDepNo(depNo);
	}
	
	
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public String getDepAd() {
		return depAd;
	}
	public void setDepAd(String depAd) {
		this.depAd = depAd;
	}
	
}
