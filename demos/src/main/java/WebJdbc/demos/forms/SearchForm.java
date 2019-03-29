package WebJdbc.demos.forms;

import java.util.Date;

public class SearchForm {
	private Date begin;
	private Date end;
	private String userName;
	private String tableName;
	private boolean selectUser;
	private boolean selectTable;

	public SearchForm() {
		super();
	}

	public SearchForm(Date begin, Date end, String userName, String tableName, boolean selectUser,
			boolean selectTable) {
		super();
		this.begin = begin;
		this.end = end;
		this.userName = userName;
		this.tableName = tableName;
		this.selectUser = selectUser;
		this.selectTable = selectTable;
	}

	/**
	 * @return the begin
	 */
	public Date getBegin() {
		return begin;
	}

	/**
	 * @param begin the begin to set
	 */
	public void setBegin(Date begin) {
		this.begin = begin;
	}

	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the selectUser
	 */
	public boolean isSelectUser() {
		return selectUser;
	}

	/**
	 * @param selectUser the selectUser to set
	 */
	public void setSelectUser(boolean selectUser) {
		this.selectUser = selectUser;
	}

	/**
	 * @return the selectTable
	 */
	public boolean isSelectTable() {
		return selectTable;
	}

	/**
	 * @param selectTable the selectTable to set
	 */
	public void setSelectTable(boolean selectTable) {
		this.selectTable = selectTable;
	}

}
