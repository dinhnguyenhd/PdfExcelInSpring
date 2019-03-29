package WebJdbc.demos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WebJdbc.demos.entity.LogEntity;
import WebJdbc.demos.forms.SearchForm;
import WebJdbc.demos.repositorys.FileLogRepository;

@Service
@Transactional
public class FileLogServiceImpl implements FilelogService {

	@Autowired
	private FileLogRepository fileLogRepository;

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
