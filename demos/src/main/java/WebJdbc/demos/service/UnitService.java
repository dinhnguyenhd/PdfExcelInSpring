package WebJdbc.demos.service;

import java.util.List;

import WebJdbc.demos.entity.Dvtt;
import WebJdbc.demos.entity.UnitDto;
import WebJdbc.demos.entity.Units;
import WebJdbc.demos.forms.UnitForm;

public interface UnitService {

	public List<Units> list();

	public int add(UnitForm form);

	public Units getByCode(String code);

	public int update(Units unit);

	public int delete(String code);

	public List<UnitDto> searchByCondition(UnitForm form);
	
	public List<Dvtt> listDvtt();
	
	public void insertBatch(List<UnitDto> data);
	
	

}
