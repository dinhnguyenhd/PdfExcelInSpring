package WebJdbc.demos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WebJdbc.demos.entity.LogEntity;
import WebJdbc.demos.repositorys.DatabaseLogRepository;

@Service
@Transactional
public class DatabaseLogServiceImpl implements DatabaseLogService {

	@Autowired
	private DatabaseLogRepository databaseLogRepository;

	@Override
	public List<String> searchListUserInDb(String begin, String end) {
		return this.databaseLogRepository.searchListUserInDb(begin, end);
	}

	@Override
	public List<String> searchListTableInDb(String begin, String end) {
		return this.databaseLogRepository.searchListTableInDb(begin, end);
	}

	@Override
	public List<LogEntity> searchListDataByUser(String begin, String end, String userName) {

		return this.databaseLogRepository.searchListDataByUser(begin, end, userName);
	}

	@Override
	public List<LogEntity> searchListDataByTable(String begin, String end, String tableName) {
		return this.databaseLogRepository.searchListDataByTable(begin, end, tableName);
	}

	@Override
	public List<LogEntity> searchListData(String begin, String end) {

		return this.databaseLogRepository.searchListData(begin, end);
	}

	@Override
	public List<LogEntity> searchListDataWithUserAndTable(String begin, String end, String userName, String tableName) {
		return this.databaseLogRepository.searchListDataWittUserAndTable(begin, end, userName, tableName);
	}

	/**
	 * @return the databaseLogRepository
	 */
	public DatabaseLogRepository getDatabaseLogRepository() {
		return databaseLogRepository;
	}

	/**
	 * @param databaseLogRepository the databaseLogRepository to set
	 */
	public void setDatabaseLogRepository(DatabaseLogRepository databaseLogRepository) {
		this.databaseLogRepository = databaseLogRepository;
	}

}
