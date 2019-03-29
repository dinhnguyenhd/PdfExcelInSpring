package WebJdbc.demos.utils;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

public class GenerateReport {

	private String name;
	private String folder;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}

	public List addRowHeader() {
		List row = new List();
		// add ho ten
		ListItem hoten = new ListItem("Họ Và Tên ");
		row.add(hoten);
		ListItem maso = new ListItem("Mã Số");
		row.add(maso);
		ListItem gioitinh = new ListItem("Giới Tính ");
		row.add(gioitinh);
		ListItem tuoi = new ListItem(" Tuổi ");
		row.add(tuoi);
		ListItem diachi = new ListItem("Địa Chỉ ");
		row.add(diachi);
		ListItem doituong = new ListItem("Đối Tượng");
		row.add(doituong);
		ListItem ngaylm = new ListItem("Ngày Lấy Mẫu ");
		row.add(ngaylm);
		ListItem ngayxn = new ListItem("Ngày Xét Nghiệm");
		row.add(ngayxn);
		ListItem sp = new ListItem("SP");
		row.add(sp);
		ListItem kl = new ListItem("Kết Luận");
		row.add(kl);
		ListItem kq = new ListItem(" Kết Quả Khẳng Định ");
		row.add(kq);
		ListItem ghichu = new ListItem("Ghi Chú ");
		row.add(ghichu);
		return row;

	}

	public void writeFpf() throws FileNotFoundException {
		String file = "C:/Users/eHealth-PC/Desktop/pdf//test.pdf";
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(file));

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		float[] pointColumnWidths = { 300F, 300F };
		Table table = new Table(pointColumnWidths);

		doc.add(table);

		// Closing the document
		doc.close();
		System.out.println("Lists added to table successfully..");
	}

	public static void main(String args[]) throws Exception {
		// Creating a PdfWriter object
		String file = "C:/Users/eHealth-PC/Desktop/pdf//test.pdf";
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(file));

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		doc.setHorizontalAlignment(HorizontalAlignment.LEFT);

		// Creating a table

		float[] pointColumnWidths = { 50F, 50F, 50F, 50F, 50F, 50F, 50F, 50F, 50F, 50F, 50F, 50F };
		Table table = new Table(pointColumnWidths);
		int index = 0;
		while (index < 10) {
			for (int i = 0; i < 12; i++) {
				Cell c = new Cell();
				c.add("Cell " + i + " X" + index);
			
				table.addCell(c);

			}
		//	table.complete();
			index++;
		}

		// Adding Table to document
		doc.add(table);

		// Closing the document
		doc.close();
		System.out.println("Lists added to table successfully..");
	}
}