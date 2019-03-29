package WebJdbc.demos.repositorys;

import java.util.List;

import WebJdbc.demos.entity.LogEntity;

public interface DatabaseLogRepository {

	public List<String> searchListUserInDb(String begin, String end);

	public List<String> searchListTableInDb(String begin, String end);

	public List<LogEntity> searchListData(String begin, String end);

	public List<LogEntity> searchListDataByTable(String begin, String end, String tableName);

	public List<LogEntity> searchListDataByUser(String begin, String end, String userName);

	public List<LogEntity> searchListDataWittUserAndTable(String begin, String end, String userName, String tableName);

}
