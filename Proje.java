package odev1;

public class Proje extends Departman{
	
	public Proje(int depNo, String depAd, String projeAd, int projeSure, int projeMaaliyet) {
		super(depNo, depAd);
		setProjeAd(projeAd);
		setProjeSure(projeSure);
		setProjeMaliyet(projeMaaliyet);
		setProjeId();
	}
	public static int pID=0;
	
	private int depNo;
	private int projeId;
	private String projeAd;
	private int projeSure;
	private int projeMaliyet;
	
	public int getProjeId() {
		return projeId;
	}
	public void setProjeId() {
		this.projeId = ++pID;
	}
	public String getProjeAd() {
		return projeAd;
	}
	public void setProjeAd(String projeAd) {
		this.projeAd = projeAd;
	}
	public int getProjeSure() {
		return projeSure;
	}
	public void setProjeSure(int projeSure) {
		this.projeSure = projeSure;
	}
	public int getProjeMaliyet() {
		return projeMaliyet;
	}
	public void setProjeMaliyet(int projeMaliyet) {
		this.projeMaliyet = projeMaliyet;
	}
	
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo() {
		this.depNo = super.getDepNo();
	}

}
