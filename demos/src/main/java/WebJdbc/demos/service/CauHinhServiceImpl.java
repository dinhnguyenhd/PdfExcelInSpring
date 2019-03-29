package WebJdbc.demos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebJdbc.demos.entity.CauHinh;
import WebJdbc.demos.repositorys.CauHinhRepository;

@Service
public class CauHinhServiceImpl implements CauHinhService {

	@Autowired
	private CauHinhRepository cauHinhRepository;

	@Override
	public List<CauHinh> listConfig() {
		return this.cauHinhRepository.listConfig();
	}

	@Override
	public void insert(List<CauHinh> list) {
		this.cauHinhRepository.insert(list);
	}

	@Override
	public void delete() {
		this.cauHinhRepository.delete();

	}

}
