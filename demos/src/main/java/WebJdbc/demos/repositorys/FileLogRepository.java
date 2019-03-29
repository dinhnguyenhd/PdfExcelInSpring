package WebJdbc.demos.repositorys;

import java.util.List;

import WebJdbc.demos.entity.LogEntity;
import WebJdbc.demos.forms.SearchForm;

public interface FileLogRepository {

	public List<String> searchListUserInFolder(SearchForm form);

	public List<String> searchListTableInFolder(SearchForm form);

	public List<LogEntity> searchListDataByUser(SearchForm form);

	public List<LogEntity> searchListDataByTable(SearchForm form);

	public List<LogEntity> searchListDataByUserAndTable(SearchForm form);

	public List<String> searchListUserInDb(SearchForm form);

	public List<String> searchListTableInDB(SearchForm form);

	public List<LogEntity> searchListDataInFolder(SearchForm form);

	public List<LogEntity> searchListDataInDB(SearchForm form);

}
