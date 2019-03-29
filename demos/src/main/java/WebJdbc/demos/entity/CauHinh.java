package WebJdbc.demos.entity;

public class CauHinh {

	private String id;
	private String tenso;
	private String listCode;

	public CauHinh() {
		super();
	}

	public CauHinh(String tenso, String listCode) {
		super();
		this.tenso = tenso;
		this.listCode = listCode;
	}

	public CauHinh(String id, String tenso, String listCode) {
		super();
		this.id = id;
		this.tenso = tenso;
		this.listCode = listCode;
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
	 * @return the tenso
	 */
	public String getTenso() {
		return tenso;
	}

	/**
	 * @param tenso the tenso to set
	 */
	public void setTenso(String tenso) {
		this.tenso = tenso;
	}

	/**
	 * @return the listCode
	 */
	public String getListCode() {
		return listCode;
	}

	/**
	 * @param listCode the listCode to set
	 */
	public void setListCode(String listCode) {
		this.listCode = listCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CauHinh [id=" + id + ", tenso=" + tenso + ", listCode=" + listCode + "]";
	}

}
