package WebJdbc.demos.utils;

public class RowEntity {
	private int stt;
	private String name;
	private String code;
	private String gender;
	private String age;
	private String address;
	private String object;
	private String daylm;
	private String dayxn;
	private String sp;
	private String ketLuan;
	private String ketLuanKd;
	private String note;

	public RowEntity() {
		super();
	}

	public RowEntity(int stt, String name, String code, String gender, String age, String address, String object,
			String daylm, String dayxn, String sp, String ketLuan, String ketLuanKd, String note) {
		super();
		this.stt = stt;
		this.name = name;
		this.code = code;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.object = object;
		this.daylm = daylm;
		this.dayxn = dayxn;
		this.sp = sp;
		this.ketLuan = ketLuan;
		this.ketLuanKd = ketLuanKd;
		this.note = note;
	}

	/**
	 * @return the stt
	 */
	public int getStt() {
		return stt;
	}

	/**
	 * @param stt the stt to set
	 */
	public void setStt(int stt) {
		this.stt = stt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * @return the daylm
	 */
	public String getDaylm() {
		return daylm;
	}

	/**
	 * @param daylm the daylm to set
	 */
	public void setDaylm(String daylm) {
		this.daylm = daylm;
	}

	/**
	 * @return the dayxn
	 */
	public String getDayxn() {
		return dayxn;
	}

	/**
	 * @param dayxn the dayxn to set
	 */
	public void setDayxn(String dayxn) {
		this.dayxn = dayxn;
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
	 * @return the ketLuan
	 */
	public String getKetLuan() {
		return ketLuan;
	}

	/**
	 * @param ketLuan the ketLuan to set
	 */
	public void setKetLuan(String ketLuan) {
		this.ketLuan = ketLuan;
	}

	/**
	 * @return the ketLuanKd
	 */
	public String getKetLuanKd() {
		return ketLuanKd;
	}

	/**
	 * @param ketLuanKd the ketLuanKd to set
	 */
	public void setKetLuanKd(String ketLuanKd) {
		this.ketLuanKd = ketLuanKd;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
