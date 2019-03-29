package WebJdbc.demos.forms;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UnitForm implements Serializable {
	/**
	 * 
	 */

	@NotNull
	@Size(max = 255, message = "Nhập lại mã đơn vi")
	private String code;

	@NotNull
	@Size(max = 255, message = "Nhập lại tên đơn vi")
	private String name;

	@NotNull
	@Size(max = 255, message = "Nhập lại địa chỉ ")
	private String address;

	@Size(max = 255, message = "Nhập lại mã số thuế")
	private String taxCode;

	@Email
	@Size(max = 255, message = "Nhập lại địa chỉ email")
	private String email;

	@Size(max = 255, message = "Nhập lại số điện thoại ")
	private String mobile;

	private String dvtt;

	public UnitForm() {
		super();
	}

	public UnitForm(@NotNull @Size(max = 255, message = "Nhập lại mã đơn vi") String code,
			@NotNull @Size(max = 255, message = "Nhập lại tên đơn vi") String name,
			@NotNull @Size(max = 255, message = "Nhập lại địa chỉ ") String address,
			@Size(max = 255, message = "Nhập lại mã số thuế") String taxCode,
			@Email @Size(max = 255, message = "Nhập lại địa chỉ email") String email,
			@Size(max = 255, message = "Nhập lại số điện thoại ") String mobile, String dvtt) {
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
