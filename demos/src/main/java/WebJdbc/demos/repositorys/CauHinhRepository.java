package WebJdbc.demos.repositorys;

import java.util.List;

import WebJdbc.demos.entity.CauHinh;

public interface CauHinhRepository {

	public List<CauHinh> listConfig();
	
	public CauHinh getNameConfig(String findCode) ;

	public void insert(List<CauHinh> list);

	public void delete();
	

}
