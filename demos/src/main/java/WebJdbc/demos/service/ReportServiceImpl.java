package WebJdbc.demos.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import WebJdbc.demos.entity.SearchHivRow;
import WebJdbc.demos.forms.SearchHivFrom;
import WebJdbc.demos.utils.WritePdf;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private WritePdf writePdf;

	@Autowired
	private HivService hivService;

	@Override
	public void writeFilePdf(SearchHivFrom form) {
		List<SearchHivRow> list = this.hivService.searchHiv(form);
		try {
			this.writePdf.createFile(list);
		} catch (IllegalArgumentException | IllegalAccessException | DocumentException | IOException e) {
			e.printStackTrace();
		}

	}

}
