package WebJdbc.demos.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebJdbc.demos.entity.CauHinh;
import WebJdbc.demos.entity.DoiTuong;
import WebJdbc.demos.entity.Place;
import WebJdbc.demos.entity.SearchHivRow;
import WebJdbc.demos.forms.ConfigForm;
import WebJdbc.demos.forms.SearchHivFrom;
import WebJdbc.demos.forms.SelectItem;
import WebJdbc.demos.service.CauHinhService;
import WebJdbc.demos.service.FileStorageService;
import WebJdbc.demos.service.HivService;
import WebJdbc.demos.service.ReportService;

@RestController
@RequestMapping(value = "/hiv")
@CrossOrigin(value = "*")
public class HivController {
	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private HivService hivService;

	@Autowired
	private CauHinhService cauHinhService;

	@Autowired
	private ReportService reportService;

	@PostMapping("/downloadFile")
	public ResponseEntity<Resource> downloadFile(@RequestBody SearchHivFrom form, HttpServletRequest request) {
		System.out.print(form.toString());
		reportService.writeFilePdf(form);

		String fileName = "thongtinbn.pdf";
		Resource resource = null;
		try {
			resource = fileStorageService.loadFileAsResource(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {

		}
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/list/place")
	public ResponseEntity<List<?>> listPlaced() {
		List<Place> list = this.hivService.listPlace();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/list/doituong")
	public ResponseEntity<List<?>> listDoituong() {
		List<DoiTuong> list = this.hivService.listDoiTuong();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/search")
	public ResponseEntity<List<?>> search(@RequestBody SearchHivFrom form) {
		System.out.println(" beign " + form.getBegin() + " end " + form.getEnd() + " place" + form.getPlace());
		for (SelectItem item : form.getList()) {
			System.out.println(" id " + item.getId() + " label " + item.getLabel());
		}
		List<SearchHivRow> list = this.hivService.searchHiv(form);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/list/config")
	public ResponseEntity<List<?>> listConfig() {
		List<CauHinh> list = this.cauHinhService.listConfig();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/config/delete")
	public ResponseEntity<List<?>> delete() {
		this.cauHinhService.delete();
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PostMapping("/config/save")
	public ResponseEntity<List<?>> saveConfig(@RequestBody ConfigForm form) {
		this.cauHinhService.delete();
		this.cauHinhService.insert(form.getList());
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
