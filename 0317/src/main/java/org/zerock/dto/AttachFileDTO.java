package org.zerock.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachFileDTO {
	
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
	
	
	public String getLink() {
		
		//파일의 경로 전달
		// ex. 2021/03/17/ - 뒤에 / 필요
		String fileLinkName = fileName.replace(".", "#"); //uuid 중간에 _가 들어가기 때문에 #을 추천
		
		String str = uploadPath+"/"+uuid+"_"+fileLinkName; //파일을 가져올 경로
		
		String enStr = ""; //encoding 값
		
		try {
			
			enStr = URLEncoder.encode(str, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//이미지가 아닌경우
		
		return enStr;
	}
	
	//위 코드를 복붙해서 썼기 때문에 좋지 않은 코드이다.
	public String getThumbLink() {
		
		String fileLinkName = fileName.replace(".", "#");
		// 2021/03/17/
		String str = uploadPath+"/s_"+uuid+"_"+fileLinkName;
		
		String enStr = "";
		
		try {
			enStr = URLEncoder.encode(str,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return enStr;
	}
}
