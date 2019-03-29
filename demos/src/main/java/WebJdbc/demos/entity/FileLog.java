package WebJdbc.demos.entity;

import java.io.Serializable;

public class FileLog  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String _UserID;
	private String _Action;
	private String dsRecordChanged;
	private String Decription;
	private String keyPair;
	private String Key;
	private String NewID;
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
	private String NguoiCapNhat;
	private String NgayCapNhat;
	private String FieldHaveAvaliable;
	private String IsNotEdit;
	private String sysSTT;
	private String _IsAdd;
	private String _UID;

	public FileLog() {
		super();
	}

	
	public FileLog(String _UserID, String _Action, String dsRecordChanged, String decription, String keyPair,
			String key, String newID, String iD, String bUID, String times, String entityKey, String entityName,
			String state, String hostName, String iPAddress, String userID, String sessionID, String originalValues,
			String currentValues, String listRecordChanged, String nguoiTao, String ngayTao, String nguoiCapNhat,
			String ngayCapNhat, String fieldHaveAvaliable, String isNotEdit, String sysSTT, String _IsAdd,
			String _UID) {
		super();
		this._UserID = _UserID;
		this._Action = _Action;
		this.dsRecordChanged = dsRecordChanged;
		this.Decription = decription;
		this.keyPair = keyPair;
		Key = key;
		NewID = newID;
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
		NguoiCapNhat = nguoiCapNhat;
		NgayCapNhat = ngayCapNhat;
		FieldHaveAvaliable = fieldHaveAvaliable;
		IsNotEdit = isNotEdit;
		this.sysSTT = sysSTT;
		this._IsAdd = _IsAdd;
		this._UID = _UID;
	}


	/**
	 * @return the _UserID
	 */
	public String get_UserID() {
		return _UserID;
	}

	/**
	 * @param _UserID the _UserID to set
	 */
	public void set_UserID(String _UserID) {
		this._UserID = _UserID;
	}

	/**
	 * @return the _Action
	 */
	public String get_Action() {
		return _Action;
	}

	/**
	 * @param _Action the _Action to set
	 */
	public void set_Action(String _Action) {
		this._Action = _Action;
	}

	/**
	 * @return the dsRecordChanged
	 */
	public String getDsRecordChanged() {
		return dsRecordChanged;
	}

	/**
	 * @param dsRecordChanged the dsRecordChanged to set
	 */
	public void setDsRecordChanged(String dsRecordChanged) {
		this.dsRecordChanged = dsRecordChanged;
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
		this.Decription = decription;
	}

	
	/**
	 * @return the keyPair
	 */
	public String getKeyPair() {
		return keyPair;
	}

	/**
	 * @param keyPair the keyPair to set
	 */
	public void setKeyPair(String keyPair) {
		this.keyPair = keyPair;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return Key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		Key = key;
	}

	/**
	 * @return the newID
	 */
	public String getNewID() {
		return NewID;
	}

	/**
	 * @param newID the newID to set
	 */
	public void setNewID(String newID) {
		NewID = newID;
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
	 * @return the nguoiCapNhat
	 */
	public String getNguoiCapNhat() {
		return NguoiCapNhat;
	}

	/**
	 * @param nguoiCapNhat the nguoiCapNhat to set
	 */
	public void setNguoiCapNhat(String nguoiCapNhat) {
		NguoiCapNhat = nguoiCapNhat;
	}

	/**
	 * @return the ngayCapNhat
	 */
	public String getNgayCapNhat() {
		return NgayCapNhat;
	}

	/**
	 * @param ngayCapNhat the ngayCapNhat to set
	 */
	public void setNgayCapNhat(String ngayCapNhat) {
		NgayCapNhat = ngayCapNhat;
	}

	/**
	 * @return the fieldHaveAvaliable
	 */
	public String getFieldHaveAvaliable() {
		return FieldHaveAvaliable;
	}

	/**
	 * @param fieldHaveAvaliable the fieldHaveAvaliable to set
	 */
	public void setFieldHaveAvaliable(String fieldHaveAvaliable) {
		FieldHaveAvaliable = fieldHaveAvaliable;
	}

	/**
	 * @return the isNotEdit
	 */
	public String getIsNotEdit() {
		return IsNotEdit;
	}

	/**
	 * @param isNotEdit the isNotEdit to set
	 */
	public void setIsNotEdit(String isNotEdit) {
		IsNotEdit = isNotEdit;
	}

	/**
	 * @return the sysSTT
	 */
	public String getSysSTT() {
		return sysSTT;
	}

	/**
	 * @param sysSTT the sysSTT to set
	 */
	public void setSysSTT(String sysSTT) {
		this.sysSTT = sysSTT;
	}

	/**
	 * @return the _IsAdd
	 */
	public String get_IsAdd() {
		return _IsAdd;
	}

	/**
	 * @param _IsAdd the _IsAdd to set
	 */
	public void set_IsAdd(String _IsAdd) {
		this._IsAdd = _IsAdd;
	}

	/**
	 * @return the _UID
	 */
	public String get_UID() {
		return _UID;
	}

	/**
	 * @param _UID the _UID to set
	 */
	public void set_UID(String _UID) {
		this._UID = _UID;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileLog [_UserID=" + _UserID + ", _Action=" + _Action + ", dsRecordChanged=" + dsRecordChanged
				+ ", decription=" + Decription + ", keyPair=" + keyPair + ", Key=" + Key + ", NewID=" + NewID + ", ID="
				+ ID + ", BUID=" + BUID + ", Times=" + Times + ", EntityKey=" + EntityKey + ", EntityName=" + EntityName
				+ ", State=" + State + ", HostName=" + HostName + ", IPAddress=" + IPAddress + ", UserID=" + UserID
				+ ", SessionID=" + SessionID + ", OriginalValues=" + OriginalValues + ", CurrentValues=" + CurrentValues
				+ ", ListRecordChanged=" + ListRecordChanged + ", NguoiTao=" + NguoiTao + ", NgayTao=" + NgayTao
				+ ", NguoiCapNhat=" + NguoiCapNhat + ", NgayCapNhat=" + NgayCapNhat + ", FieldHaveAvaliable="
				+ FieldHaveAvaliable + ", IsNotEdit=" + IsNotEdit + ", sysSTT=" + sysSTT + ", _IsAdd=" + _IsAdd
				+ ", _UID=" + _UID + "]";
	}

	
	
}
