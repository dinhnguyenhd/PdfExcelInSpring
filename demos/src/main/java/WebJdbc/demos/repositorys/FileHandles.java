package WebJdbc.demos.repositorys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import WebJdbc.demos.entity.FileLog;
import WebJdbc.demos.utils.FileFilterDateIntervalUtils;

@Component
public class FileHandles {
	String folderPath = "C:\\Users\\eHealth-PC\\Desktop\\Task 2\\Log";

	public List<String> getListFileInFolder(String begin, String end) {
		List<String> listFile = new ArrayList<String>();

		FileFilterDateIntervalUtils filter = new FileFilterDateIntervalUtils(begin, end);
		File folder = new File(this.folderPath);
		File files[] = folder.listFiles(filter);
		for (File f : files) {
			/*
			 * if (f.getName().endsWith(".log")) { listFile.add(f.getName()); }
			 */
			listFile.add(f.getName());
			
		}
		return listFile;

	}

	// Case A : call ajax - select option for user_id
	public List<String> getListUserInDuration(String begin, String end) {
		List<String> file = new FileHandles().getListFileInFolder(begin, end);
		BufferedReader buff = null;
		List<String> listUser = new ArrayList<String>();
		Gson gson = new Gson();
		try {
			for (String fileName : file) {
				buff = new BufferedReader(new FileReader(new File(this.folderPath + "/" + fileName)));
				String line = null;
				while ((line = buff.readLine()) != null) {
					String json = line.substring(22, line.length());
					FileLog fileLog = gson.fromJson(json, FileLog.class);
					if (fileLog.getUserID() != null) {
						if (!listUser.contains(fileLog.get_UserID())) {
							listUser.add(fileLog.getUserID());
						}
						
					}
				}
				buff.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return listUser;

	}

	// call ajax - select option for table name
	public List<String> getListTableInDuration(String begin, String end) {
		List<String> file = new FileHandles().getListFileInFolder(begin, end);
		BufferedReader buff = null;
		List<String> listUser = new ArrayList<String>();
		Gson gson = new Gson();
		try {
			for (String fileName : file) {
				buff = new BufferedReader(new FileReader(new File(this.folderPath + "/" + fileName)));
				String line = null;
				while ((line = buff.readLine()) != null) {
					String json = line.substring(22, line.length());
					FileLog fileLog = gson.fromJson(json, FileLog.class);
					if (fileLog.getEntityName() != null) {
						if (!listUser.contains(fileLog.getEntityName())) {
							listUser.add(fileLog.getEntityName());
						}
						
					}
				}
				buff.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return listUser;

	}

	// call search when user null and table null
	public List<FileLog> getListFileLogInDuration(String begin, String end) {
		List<String> file = new FileHandles().getListFileInFolder(begin, end);
		BufferedReader buff = null;
		List<FileLog> listObject = new ArrayList<FileLog>();
		Gson gson = new Gson();
		try {
			for (String fileName : file) {
				buff = new BufferedReader(new FileReader(new File(this.folderPath + "/" + fileName)));
				String line = null;
				while ((line = buff.readLine()) != null) {
					String json = line.substring(22, line.length());
					FileLog fileLog = gson.fromJson(json, FileLog.class);
					listObject.add(fileLog);
				}
				buff.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return listObject;

	}

	// case 1: begin _ end
	public List<String> getListFullnDuration(String begin, String end) {
		List<String> file = new FileHandles().getListFileInFolder(begin, end);
		BufferedReader buff = null;
		List<String> listUser = new ArrayList<String>();
		Gson gson = new Gson();
		try {
			for (String fileName : file) {
				buff = new BufferedReader(new FileReader(new File(this.folderPath + "/" + fileName)));
				String line = null;
				while ((line = buff.readLine()) != null) {
					String json = line.substring(22, line.length());
					FileLog fileLog = gson.fromJson(json, FileLog.class);
					if (fileLog.getEntityName() != null) {
						listUser.add(fileLog.getEntityName());
					}
				}
				buff.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return listUser;

	}

	// case 2: begin _ end _ user id
	public List<FileLog> searchListDataByUser(String begin, String end, String userId) {
		List<FileLog> list = new FileHandles().getListFileLogInDuration(begin, end);
		list = list.stream().filter(d -> d.getUserID().trim().equals(userId)).collect(Collectors.toList());
		return list;
	}

	// case 3: begin _ end _ table
	public List<FileLog> searchListDataByTable( String begin, String end, String tableName) {
		List<FileLog> list = new FileHandles().getListFileLogInDuration(begin, end);
		list = list.stream().filter(d -> d.getEntityName().trim().equals(tableName)).collect(Collectors.toList());
		return list;
	}

	// case 1: begin _ end, user id_ table name
	public List<FileLog> getListWithUserIdAndTable(String begin, String end, String userId, String tableName) {
		List<String> file = new FileHandles().getListFileInFolder(begin, end);
		BufferedReader buff = null;
		List<FileLog> listObject = new ArrayList<FileLog>();
		Gson gson = new Gson();
		try {
			for (String fileName : file) {
				buff = new BufferedReader(new FileReader(new File(this.folderPath + "/" + fileName)));
				String line = null;
				while ((line = buff.readLine()) != null) {
					String json = line.substring(22, line.length());
					if (line.contains(userId) && line.contains(tableName)) {
						FileLog fileLog = gson.fromJson(json, FileLog.class);
						listObject.add(fileLog);
					}

				}
				buff.close();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return listObject;

	}

}
