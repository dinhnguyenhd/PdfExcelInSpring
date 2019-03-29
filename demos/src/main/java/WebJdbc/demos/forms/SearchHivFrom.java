package WebJdbc.demos.forms;

import java.io.Serializable;
import java.util.List;

public class SearchHivFrom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String begin;
	private String end;
	private String place;
	private List<SelectItem> list;

	public SearchHivFrom() {
		super();
	}

	public SearchHivFrom(String begin, String end, String place, List<SelectItem> list) {
		super();
		this.begin = begin;
		this.end = end;
		this.place = place;
		this.list = list;
	}

	/**
	 * @return the begin
	 */
	public String getBegin() {
		return begin;
	}

	/**
	 * @param begin the begin to set
	 */
	public void setBegin(String begin) {
		this.begin = begin;
	}

	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the list
	 */
	public List<SelectItem> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<SelectItem> list) {
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchHivFrom [begin=" + begin + ", end=" + end + ", place=" + place + ", list=" + list + "]";
	}
	
	

}
