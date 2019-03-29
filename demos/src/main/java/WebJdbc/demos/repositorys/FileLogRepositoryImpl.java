package WebJdbc.demos.repositorys;

import java.util.List;

import org.springframework.stereotype.Repository;

import WebJdbc.demos.entity.LogEntity;
import WebJdbc.demos.forms.SearchForm;

@Repository
public class FileLogRepositoryImpl implements FileLogRepository {

	@Override
	public List<String> searchListUserInFolder(SearchForm form) {

		return null;
	}

	@Override
	public List<String> searchListTableInFolder(SearchForm form) {

		return null;
	}

	@Override
	public List<LogEntity> searchListDataByUser(SearchForm form) {

		return null;
	}

	@Override
	public List<LogEntity> searchListDataByTable(SearchForm form) {

		return null;
	}

	@Override
	public List<LogEntity> searchListDataByUserAndTable(SearchForm form) {

		return null;
	}

	@Override
	public List<String> searchListUserInDb(SearchForm form) {

		return null;
	}

	@Override
	public List<String> searchListTableInDB(SearchForm form) {

		return null;
	}

	@Override
	public List<LogEntity> searchListDataInFolder(SearchForm form) {

		return null;
	}

	@Override
	public List<LogEntity> searchListDataInDB(SearchForm form) {

		return null;
	}

}
