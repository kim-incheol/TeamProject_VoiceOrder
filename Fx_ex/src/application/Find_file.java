package application;


import java.io.FileFilter;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
 
public class Find_file {
 
    public static ArrayList<String> jFileChooserUtil(){
        
        ArrayList <String> folderPath = new ArrayList<>();
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); // ���丮 ����
        chooser.setCurrentDirectory(new File("/")); // ���� ��� ���丮�� ����
        chooser.setAcceptAllFileFilterUsed(true);   // Fileter ��� ���� ���� 
        chooser.setDialogTitle("Ÿ��Ʋ"); // â�� ����
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // ���� ���� ���
        chooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Audio files", "mp3"); // filter Ȯ���� �߰�
        
        File file = new File("V:/tmp/");
    	
        chooser.setFileFilter(filter); // ���� ���͸� �߰�
       
        int returnVal = chooser.showOpenDialog(null); // ����� â ����
        
        if(returnVal == JFileChooser.APPROVE_OPTION) { // ���⸦ Ŭ�� 
            //folderPath.add(chooser.getSelectedFiles());
        	File[] mFile = chooser.getSelectedFiles();
        	File[] file_for_directory = null;
        	boolean isDirectory = false;
        	for(int i=0; i<mFile.length; i++) {
        		if(mFile[i].isDirectory())
        		{
        			file_for_directory = mFile[i].listFiles();
        			isDirectory = true;
        		}
        	}
        	
        	if(isDirectory) {
        		for(int i=0; i<file_for_directory.length; i++) {
        			
        			if(file_for_directory[i].getPath().contains(".mp3")) {


        				folderPath.add(file_for_directory[i].getPath());
        			}
        		}
        	}else {
	        	for(int i=0; i<mFile.length; i++)
	        		folderPath.add(mFile[i].getPath());
        	}
        }else if(returnVal == JFileChooser.CANCEL_OPTION){ // ��Ҹ� Ŭ��
            System.out.println("cancel"); 
            folderPath.clear();
        }

        
        return folderPath;
        
    }
    public static void main(String[] args) {
    	ArrayList<String> a = new ArrayList<String>();
    	a=jFileChooserUtil();
    	for(int i=0;i<a.size();i++)
    	System.out.println(a.get(i));
		
	}
}
