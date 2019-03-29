package WebJdbc.demos.forms;

import java.io.Serializable;
import java.util.List;

import WebJdbc.demos.entity.CauHinh;

public class ConfigForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<CauHinh> list;

	/**
	 * @return the list
	 */
	public List<CauHinh> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<CauHinh> list) {
		this.list = list;
	}

}
