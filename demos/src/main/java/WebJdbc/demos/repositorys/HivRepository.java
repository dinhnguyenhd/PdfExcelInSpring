package WebJdbc.demos.repositorys;

import java.util.List;

import WebJdbc.demos.entity.DoiTuong;
import WebJdbc.demos.entity.Place;
import WebJdbc.demos.entity.SearchHivRow;
import WebJdbc.demos.forms.SearchHivFrom;

public interface HivRepository {
	
	public List<Place> listPlace();
	
	public List<DoiTuong> listDoiTuong();
	
	public List<SearchHivRow> searchHiv(SearchHivFrom form, StringBuilder inConditions);

	

}
