package com.JavaMailTask.www;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	
	private static final int BUFFER_SIZE = 2 * 1024;

	 public static void toZip(File sourceFile, OutputStream out, boolean KeepDirStructure) throws RuntimeException{
	    ZipOutputStream zos = null ;
	    try {
	      zos = new ZipOutputStream(out);
	      compress(sourceFile,zos,sourceFile.getName(),KeepDirStructure);
	    } catch (Exception e) {
	      throw new RuntimeException("zip error from ZipUtils",e);
	    }finally{
	      if(zos != null){
	        try {
	          zos.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	  }
	  private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception{

		  
		  byte[] buf = new byte[BUFFER_SIZE];
		  if(sourceFile.isFile()){
			  // 鍚憐ip杈撳嚭娴佷腑娣诲姞涓�涓獄ip瀹炰綋锛屾瀯閫犲櫒涓璶ame涓簔ip瀹炰綋鐨勬枃浠剁殑鍚嶅瓧
			  zos.putNextEntry(new ZipEntry(name));
			  // copy鏂囦欢鍒皕ip杈撳嚭娴佷腑
			  int len;
			  FileInputStream in = new FileInputStream(sourceFile);
			  while ((len = in.read(buf)) != -1){
				  zos.write(buf, 0, len);
			  }
			  // Complete the entry
			  zos.closeEntry();
			  in.close();
		  } else {
			  File[] listFiles = sourceFile.listFiles();
			  if(listFiles == null || listFiles.length == 0){
				  // 闇�瑕佷繚鐣欏師鏉ョ殑鏂囦欢缁撴瀯鏃�,闇�瑕佸绌烘枃浠跺す杩涜澶勭悊
				  if(KeepDirStructure){
					  // 绌烘枃浠跺す鐨勫鐞�
					  zos.putNextEntry(new ZipEntry(name + "/"));
					  // 娌℃湁鏂囦欢锛屼笉闇�瑕佹枃浠剁殑copy
					  zos.closeEntry();
				  }
			  }else {
				  for (File file : listFiles) {
					  // 鍒ゆ柇鏄惁闇�瑕佷繚鐣欏師鏉ョ殑鏂囦欢缁撴瀯
					  if (KeepDirStructure) {
						  // 娉ㄦ剰锛歠ile.getName()鍓嶉潰闇�瑕佸甫涓婄埗鏂囦欢澶圭殑鍚嶅瓧鍔犱竴鏂滄潬,
						  // 涓嶇劧鏈�鍚庡帇缂╁寘涓氨涓嶈兘淇濈暀鍘熸潵鐨勬枃浠剁粨鏋�,鍗筹細鎵�鏈夋枃浠堕兘璺戝埌鍘嬬缉鍖呮牴鐩綍涓嬩簡
						  compress(file, zos, name + "/" + file.getName(),KeepDirStructure);
					  } else {
						  compress(file, zos, file.getName(),KeepDirStructure);
					  }
				  }
			  }
		  }
	  }
}
