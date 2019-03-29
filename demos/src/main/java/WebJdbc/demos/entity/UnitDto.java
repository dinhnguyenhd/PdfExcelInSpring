package WebJdbc.demos.entity;

import java.io.Serializable;

public class UnitDto  extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private String name;

	private String address;

	private String taxCode;

	private String email;

	private String mobile;

	private String dvtt;

	public UnitDto() {
		

	}

	public UnitDto(String code, String name, String address, String taxCode, String email, String mobile) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.taxCode = taxCode;
		this.email = email;
		this.mobile = mobile;
	}

	public UnitDto(String code, String name, String address, String taxCode, String email, String mobile, String dvtt) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.taxCode = taxCode;
		this.email = email;
		this.mobile = mobile;
		this.dvtt = dvtt;
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
	 * @return the taxCode
	 */
	public String getTaxCode() {
		return taxCode;
	}

	/**
	 * @param taxCode the taxCode to set
	 */
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the dvtt
	 */
	public String getDvtt() {
		return dvtt;
	}

	/**
	 * @param dvtt the dvtt to set
	 */
	public void setDvtt(String dvtt) {
		this.dvtt = dvtt;
	}

}
