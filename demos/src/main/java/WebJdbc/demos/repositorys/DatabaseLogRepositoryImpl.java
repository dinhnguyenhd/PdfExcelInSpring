package WebJdbc.demos.repositorys;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import WebJdbc.demos.entity.LogEntity;
import WebJdbc.demos.utils.DateFomatConvert;

@Repository
@Transactional
public class DatabaseLogRepositoryImpl implements DatabaseLogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<String> searchListUserInDb(String begin, String end) {
		String formatBegin = null;
		String formatEnd = null;
		try {
			formatBegin = DateFomatConvert.convertDate(begin);
			formatEnd = DateFomatConvert.convertDate(end);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		String sql = "SELECT DISTINCT UserID FROM Log  WHERE NguoiTao >= ? AND NguoiTao  <= ?";
		List<String> list = getJdbcTemplate().queryForList(sql, new Object[] { formatBegin, formatEnd }, String.class);
		return list;

	}

	@Override
	public List<String> searchListTableInDb(String begin, String end) {
		String formatBegin = null;
		String formatEnd = null;
		try {
			formatBegin = DateFomatConvert.convertDate(begin);
			formatEnd = DateFomatConvert.convertDate(end);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String sql = "SELECT DISTINCT EntityName FROM Log  WHERE NguoiTao >= ? AND NguoiTao  <= ?";
		List<String> list = getJdbcTemplate().queryForList(sql, new Object[] {formatBegin, formatEnd }, String.class);
		return list;
	}

	@Override
	public List<LogEntity> searchListData(String begin, String end) {
		
		String formatBegin = null;
		String formatEnd = null;
		try {
			formatBegin = DateFomatConvert.convertDate(begin);
			formatEnd = DateFomatConvert.convertDate(end);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	
		String sql = "SELECT ID, " + "BUID, " + "Times, " + "EntityKey, " + "EntityName, " + "State, " + "HostName, "
				+ "IPAddress, " + "UserID, " + "SessionID, " + "OriginalValues, " + "CurrentValues, "
				+ "ListRecordChanged, " + "NguoiTao, " + "NgayTao, Description  FROM Log WHERE NguoiTao >= ? AND NguoiTao  <= ?";

		return jdbcTemplate.query(sql, new Object[] { formatBegin, formatEnd },
				(result, row) -> new LogEntity(result.getString("ID"), result.getString("BUID"),
						result.getString("Times"), result.getString("EntityKey"), result.getString("EntityName"),
						result.getString("State"), result.getString("HostName"), result.getString("IPAddress"),
						result.getString("UserID"), result.getString("SessionID"), result.getString("OriginalValues"),
						result.getString("CurrentValues"), result.getString("ListRecordChanged"),
						result.getString("NguoiTao"), result.getString("NgayTao"),result.getString("Description")
						));
	}

	@Override
	public List<LogEntity> searchListDataByTable(String begin, String end, String tableName) {
		String formatBegin = null;
		String formatEnd = null;
		try {
			formatBegin = DateFomatConvert.convertDate(begin);
			formatEnd = DateFomatConvert.convertDate(end);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String sql = "SELECT ID, " + "BUID, " + "Times, " + "EntityKey, " + "EntityName, " + "State, " + "HostName, "
				+ "IPAddress, " + "UserID, " + "SessionID, " + "OriginalValues, " + "CurrentValues, "
				+ "ListRecordChanged, " + "NguoiTao, "
				+ "NgayTao, Description FROM Log WHERE NguoiTao >= ? AND NguoiTao  <= ?  AND  EntityName =?";

		return jdbcTemplate.query(sql, new Object[] { formatBegin, formatEnd, tableName },
				(result, row) -> new LogEntity(result.getString("ID"), result.getString("BUID"),
						result.getString("Times"), result.getString("EntityKey"), result.getString("EntityName"),
						result.getString("State"), result.getString("HostName"), result.getString("IPAddress"),
						result.getString("UserID"), result.getString("SessionID"), result.getString("OriginalValues"),
						result.getString("CurrentValues"), result.getString("ListRecordChanged"),
						result.getString("NguoiTao"), result.getString("NgayTao"), result.getString("Description")));
	}

	@Override
	public List<LogEntity> searchListDataByUser(String begin, String end, String userName) {
		String formatBegin = null;
		String formatEnd = null;
		try {
			formatBegin = DateFomatConvert.convertDate(begin);
			formatEnd = DateFomatConvert.convertDate(end);
		} catch (ParseException e) {

			e.printStackTrace();
		}		
		
		String sql = "Select ID, " + "BUID, " + "Times, " + "EntityKey, " + "EntityName, " + "State, " + "HostName, "
				+ "IPAddress, " + "UserID, " + "SessionID, " + "OriginalValues, " + "CurrentValues, "
				+ "ListRecordChanged, " + "NguoiTao, "
				+ "NgayTao, Description FROM Log WHERE NguoiTao >= ? AND NguoiTao  <= ?  AND  UserID =?";

		return jdbcTemplate.query(sql, new Object[] { formatBegin, formatEnd, userName },
				(result, row) -> new LogEntity(result.getString("ID"), result.getString("BUID"),
						result.getString("Times"), result.getString("EntityKey"), result.getString("EntityName"),
						result.getString("State"), result.getString("HostName"), result.getString("IPAddress"),
						result.getString("UserID"), result.getString("SessionID"), result.getString("OriginalValues"),
						result.getString("CurrentValues"), result.getString("ListRecordChanged"),
						result.getString("NguoiTao"), result.getString("NgayTao"),result.getString("Description")));
	}

	@Override
	public List<LogEntity> searchListDataWittUserAndTable(String begin, String end, String userName, String tableName) {
		String formatBegin = null;
		String formatEnd = null;
		try {
			formatBegin = DateFomatConvert.convertDate(begin);
			formatEnd = DateFomatConvert.convertDate(end);
		} catch (ParseException e) {

			e.printStackTrace();
		}		
		String sql = "Select ID, " + "BUID, " + "Times, " + "EntityKey, " + "EntityName, " + "State, " + "HostName, "
				+ "IPAddress, " + "UserID, " + "SessionID, " + "OriginalValues, " + "CurrentValues, "
				+ "ListRecordChanged, " + "NguoiTao, "
				+ "NgayTao, Description FROM Log WHERE NguoiTao >= ? AND NguoiTao  <= ?  AND  UserID =? AND EntityName = ? ";

		return jdbcTemplate.query(sql, new Object[] { formatBegin, formatEnd, userName, tableName },
				(result, row) -> new LogEntity(result.getString("ID"), result.getString("BUID"),
						result.getString("Times"), result.getString("EntityKey"), result.getString("EntityName"),
						result.getString("State"), result.getString("HostName"), result.getString("IPAddress"),
						result.getString("UserID"), result.getString("SessionID"), result.getString("OriginalValues"),
						result.getString("CurrentValues"), result.getString("ListRecordChanged"),
						result.getString("NguoiTao"), result.getString("NgayTao"), result.getString("Description")));

	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
