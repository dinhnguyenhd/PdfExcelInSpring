package WebJdbc.demos.service;

import java.util.List;

import WebJdbc.demos.entity.CauHinh;

public interface CauHinhService {

	public List<CauHinh> listConfig() ;
	
	public void  insert(List<CauHinh> list) ;
	
	public void delete() ;
}
