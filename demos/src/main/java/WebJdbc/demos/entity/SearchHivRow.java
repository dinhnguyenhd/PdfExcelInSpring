package WebJdbc.demos.entity;

import java.io.Serializable;

public class SearchHivRow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String hoten;
	private String gioitinh;
	private String tuoi;
	private String diachi;
	private String doituong;
	private String ngaylm;
	private String ngayxn;
	private String sp;
	private String maxn;
	private String ketluan;
	private String ketluankd;
	private String ghichu;

	public SearchHivRow() {
		super();
	}

	public SearchHivRow(String id, String hoten, String gioitinh, String tuoi, String diachi, String doituong,
			String ngaylm, String ngayxn, String sp,String maxn, String ketluan, String ketluankd, String ghichu) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.doituong = doituong;
		this.ngaylm = ngaylm;
		this.ngayxn = ngayxn;
		this.sp = sp;
		this.maxn = maxn;
		this.ketluan = ketluan;
		this.ketluankd = ketluankd;
		this.ghichu = ghichu;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the hoten
	 */
	public String getHoten() {
		return hoten;
	}

	/**
	 * @param hoten the hoten to set
	 */
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	/**
	 * @return the gioitinh
	 */
	public String getGioitinh() {
		return gioitinh;
	}

	/**
	 * @param gioitinh the gioitinh to set
	 */
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	/**
	 * @return the tuoi
	 */
	public String getTuoi() {
		return tuoi;
	}

	/**
	 * @param tuoi the tuoi to set
	 */
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	/**
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}

	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	/**
	 * @return the doituong
	 */
	public String getDoituong() {
		return doituong;
	}

	/**
	 * @param doituong the doituong to set
	 */
	public void setDoituong(String doituong) {
		this.doituong = doituong;
	}

	/**
	 * @return the ngaylm
	 */
	public String getNgaylm() {
		return ngaylm;
	}

	/**
	 * @param ngaylm the ngaylm to set
	 */
	public void setNgaylm(String ngaylm) {
		this.ngaylm = ngaylm;
	}

	/**
	 * @return the ngayxn
	 */
	public String getNgayxn() {
		return ngayxn;
	}

	/**
	 * @param ngayxn the ngayxn to set
	 */
	public void setNgayxn(String ngayxn) {
		this.ngayxn = ngayxn;
	}

	/**
	 * @return the sp
	 */
	public String getSp() {
		return sp;
	}

	/**
	 * @param sp the sp to set
	 */
	public void setSp(String sp) {
		this.sp = sp;
	}

	/**
	 * @return the ketluan
	 */
	public String getKetluan() {
		return ketluan;
	}

	/**
	 * @param ketluan the ketluan to set
	 */
	public void setKetluan(String ketluan) {
		this.ketluan = ketluan;
	}

	/**
	 * @return the ketluankd
	 */
	public String getKetluankd() {
		return ketluankd;
	}

	/**
	 * @param ketluankd the ketluankd to set
	 */
	public void setKetluankd(String ketluankd) {
		this.ketluankd = ketluankd;
	}

	/**
	 * @return the ghichu
	 */
	public String getGhichu() {
		return ghichu;
	}

	/**
	 * @param ghichu the ghichu to set
	 */
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	/**
	 * @return the maxn
	 */
	public String getMaxn() {
		return maxn;
	}

	/**
	 * @param maxn the maxn to set
	 */
	public void setMaxn(String maxn) {
		this.maxn = maxn;
	}
	
	

}
