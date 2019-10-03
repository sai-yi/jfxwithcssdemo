package zero.saiyi.cssdemo;

import java.io.File;

import java.util.Iterator;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class SimpleController {

	
	@FXML
	private Button z_in_btn;
	@FXML
	private Button open_file;
	@FXML
	private GridPane gridPane;
	@FXML
	private Button open_dir;
	@FXML
	private Button shadow_btn;
	@FXML	
	private WebView webView;
	@FXML
	private Button save_btn;
	
	// init method
	public void initialize() {
		shadow_btn.setEffect(new DropShadow(5,0,5,Color.DARKGRAY));
			}
	
	@FXML
	public void handleMouseDragOver() {
		z_in_btn.setScaleX(2.0);
		z_in_btn.setScaleY(2.0);
	}
	@FXML
	public void handleMouseDragExited() {
		z_in_btn.setScaleX(1.0);
		z_in_btn.setScaleY(1.0);
	}
	@FXML
	public void openFileHandle() {
		FileChooser file_Chooser = new FileChooser();
		
		file_Chooser.getExtensionFilters()
		.addAll(new FileChooser.ExtensionFilter("txt", "*.txt"),
				new FileChooser.ExtensionFilter("pdf", "*.pdf"),
				new FileChooser.ExtensionFilter("All images", "*.jpg","*.png","*.gif")				
				);
		
		//File file=file_Chooser.showOpenDialog(gridPane.getScene().getWindow());
		
//		if(file != null) {
//			System.out.println(file.getPath());
//		}
		// choose multiple files
		List<File> multiFiles= file_Chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
		//file_Chooser.showOpenDialog(null);
		if(multiFiles != null) {
			Iterator<File> it=multiFiles.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getPath());
			}
		}
		
		
	}
	@FXML
	public void openDirHandle() {
		DirectoryChooser dir_Chooser = new DirectoryChooser();
		File file=dir_Chooser.showDialog(gridPane.getScene().getWindow());
		if(file != null)
			System.out.println(file.getName());
	}
	@FXML
	public void saveFileHandle() {
		FileChooser file_Chooser = new FileChooser();
		
		file_Chooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("txt","*.txt"),
				new FileChooser.ExtensionFilter("java","*.java"));
		
		file_Chooser.setInitialFileName("Detault");
		
		File savedFile=file_Chooser.showSaveDialog(gridPane.getScene().getWindow());
		if(savedFile != null) {
			System.out.println(savedFile.getPath());
		}		
		
	}
	@FXML
	public void linkClickHandle() {
//		try {
//			 //Desktop.getDesktop().browse(new URI("https://www.google.com"));
//		}catch(IOException e) {
//			
//		}catch(URISyntaxException ue) {
//			
//		}
		webView.getEngine().load("https://openjfx.io");
		
		
	}
}
