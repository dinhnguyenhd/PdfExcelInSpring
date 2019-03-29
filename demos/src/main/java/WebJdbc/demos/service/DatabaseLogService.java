package WebJdbc.demos.service;

import java.util.List;

import WebJdbc.demos.entity.LogEntity;

public interface DatabaseLogService {

	public List<String> searchListUserInDb(String begin, String end);

	public List<String> searchListTableInDb(String begin, String end);

	public List<LogEntity> searchListDataByUser(String begin, String end, String userName);

	public List<LogEntity> searchListDataByTable(String begin, String end, String tableName);

	public List<LogEntity> searchListData(String begin, String end);

	public List<LogEntity> searchListDataWithUserAndTable(String begin, String end, String userName, String tableName);

}
