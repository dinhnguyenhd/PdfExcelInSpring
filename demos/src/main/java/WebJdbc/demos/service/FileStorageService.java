package WebJdbc.demos.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService {

	private final String parentPath = "C:/Users/eHealth-PC/Desktop/pdf";

	public Resource loadFileAsResource(String fileName) throws Exception {
		try {
			Path path = Paths.get(parentPath + "/"+  fileName);
			Resource resource = new UrlResource(path.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new Exception("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new Exception("File not found " + fileName, ex);
		}
	}
}