
package WebJdbc.demos.entity;

import java.io.Serializable;

public class LogEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String BUID;
	private String Times;
	private String EntityKey;
	private String EntityName;
	private String State;
	private String HostName;
	private String IPAddress;
	private String UserID;
	private String SessionID;
	private String OriginalValues;
	private String CurrentValues;
	private String ListRecordChanged;
	private String NguoiTao;
	private String NgayTao;
	private String Decription;

	public LogEntity() {
		super();
	}

	public LogEntity(String iD, String bUID, String times, String entityKey, String entityName, String state,
			String hostName, String iPAddress, String userID, String sessionID, String originalValues,
			String currentValues, String listRecordChanged, String nguoiTao, String ngayTao, String description) {
		super();
		ID = iD;
		BUID = bUID;
		Times = times;
		EntityKey = entityKey;
		EntityName = entityName;
		State = state;
		HostName = hostName;
		IPAddress = iPAddress;
		UserID = userID;
		SessionID = sessionID;
		OriginalValues = originalValues;
		CurrentValues = currentValues;
		ListRecordChanged = listRecordChanged;
		NguoiTao = nguoiTao;
		NgayTao = ngayTao;
		this.Decription = description;
	}

	/**
	 * @return the listRecordChanged
	 */
	public String getListRecordChanged() {
		return ListRecordChanged;
	}

	/**
	 * @param listRecordChanged the listRecordChanged to set
	 */
	public void setListRecordChanged(String listRecordChanged) {
		ListRecordChanged = listRecordChanged;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the bUID
	 */
	public String getBUID() {
		return BUID;
	}

	/**
	 * @param bUID the bUID to set
	 */
	public void setBUID(String bUID) {
		BUID = bUID;
	}

	/**
	 * @return the times
	 */
	public String getTimes() {
		return Times;
	}

	/**
	 * @param times the times to set
	 */
	public void setTimes(String times) {
		Times = times;
	}

	/**
	 * @return the entityKey
	 */
	public String getEntityKey() {
		return EntityKey;
	}

	/**
	 * @param entityKey the entityKey to set
	 */
	public void setEntityKey(String entityKey) {
		EntityKey = entityKey;
	}

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return EntityName;
	}

	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		EntityName = entityName;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return HostName;
	}

	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName) {
		HostName = hostName;
	}

	/**
	 * @return the iPAddress
	 */
	public String getIPAddress() {
		return IPAddress;
	}

	/**
	 * @param iPAddress the iPAddress to set
	 */
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return UserID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		UserID = userID;
	}

	/**
	 * @return the sessionID
	 */
	public String getSessionID() {
		return SessionID;
	}

	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}

	/**
	 * @return the originalValues
	 */
	public String getOriginalValues() {
		return OriginalValues;
	}

	/**
	 * @param originalValues the originalValues to set
	 */
	public void setOriginalValues(String originalValues) {
		OriginalValues = originalValues;
	}

	/**
	 * @return the currentValues
	 */
	public String getCurrentValues() {
		return CurrentValues;
	}

	/**
	 * @param currentValues the currentValues to set
	 */
	public void setCurrentValues(String currentValues) {
		CurrentValues = currentValues;
	}

	/**
	 * @return the nguoiTao
	 */
	public String getNguoiTao() {
		return NguoiTao;
	}

	/**
	 * @param nguoiTao the nguoiTao to set
	 */
	public void setNguoiTao(String nguoiTao) {
		NguoiTao = nguoiTao;
	}

	/**
	 * @return the ngayTao
	 */
	public String getNgayTao() {
		return NgayTao;
	}

	/**
	 * @param ngayTao the ngayTao to set
	 */
	public void setNgayTao(String ngayTao) {
		NgayTao = ngayTao;
	}

	/**
	 * @return the decription
	 */
	public String getDecription() {
		return Decription;
	}

	/**
	 * @param decription the decription to set
	 */
	public void setDecription(String decription) {
		Decription = decription;
	}

	
}
