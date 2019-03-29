package WebJdbc.demos.forms;

import java.util.List;

import WebJdbc.demos.entity.UnitDto;

public class UploadForm  {

	/**
	 * 
	 */
	
	private List<UnitDto> data;

	public UploadForm() {
		super();
	}

	public UploadForm(List<UnitDto> data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public List<UnitDto> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<UnitDto> data) {
		this.data = data;
	}

}
