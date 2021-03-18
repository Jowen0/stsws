package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.dto.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;


@CrossOrigin(origins = "*")
@RestController
@Log4j
public class UploadController {
	
	//올라간 이미지파일 클릭 시 보여주는 페이지로 보내기 위한 메서드
	@GetMapping("/view")
	public ResponseEntity<byte[]> viewFile(String file){
		
		byte[] result = null;
		
		ResponseEntity<byte[]> res = null;
		
		try {
			String deStr = URLDecoder.decode(file, "UTF-8");
			
			String originStr = deStr.replace("#",".");
			
			log.info(originStr);
			
			File targetFile = new File("C:\\upload\\"+ originStr);
			
			//MIME 
			String mimeType = Files.probeContentType(targetFile.toPath());
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type",mimeType);
			
			res = new ResponseEntity<>(
					FileCopyUtils.copyToByteArray(targetFile),
					header,
					HttpStatus.OK
					);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	//415에러 - 파라미터 없이 동작하는지 먼저 확인한 후 RequestBody를 적용한다.
	@DeleteMapping("removeFile")
	public ResponseEntity<String> removeFile(@RequestBody AttachFileDTO dto) {
		
		log.info("remove............");
		
		log.info(dto);
		
		String filePath = "C:\\upload\\" + dto.getUploadPath();
		String fileName = dto.getUuid()+"_"+dto.getFileName();
		
		if(dto.isImage()) {
			
			File thumb = new File(filePath+File.separator+"s_"+fileName);
			thumb.delete();
			
		}
		
		File target = new File(filePath+File.separator+fileName);
		target.delete();
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
		
	}
	
	@PostMapping(value="/upload")
	public ResponseEntity<List<AttachFileDTO>> upload(@RequestParam("files") MultipartFile[] files) {
		
		String uploadFolder = "C:\\upload";
		
		log.info("---------------------------------------");
		
		String folderPath = getFolder(); //현재날짜의 폴더경로를 만드는 메서드 -> 2021\03\17
		
		//Java API에서 Path는 폴더도 된다. //c드라이브 경로부터 쓰지 않기 위함
		File uploadPath = new File(uploadFolder, folderPath); //파일을 담는 폴더 경로(처음 위치, 하위 위치)
		
		if(uploadPath.exists() == false) {
			
			uploadPath.mkdirs(); //폴더 생성
			
		}
		
		//null이나 length 체크
		
		List<AttachFileDTO> list = new ArrayList<>();
		
		for (MultipartFile multipartFile : files) {
			
			//log.info(multipartFile.getOriginalFilename()); //OriginalFilename로 확장자를 검사해야 한다.
			
			String fileName = multipartFile.getOriginalFilename(); //가져온 파일 1개의 이름을 가져온다.
			
			UUID uuid = UUID.randomUUID(); //랜덤 UUID 생성 -> 중복을 방지하기 위함
			
			boolean isImage = multipartFile.getContentType().startsWith("image"); //업로드 파일의 MIME Type이 image로 시작하는지
			
			//log.info(multipartFile.getSize());
			
			//파일 저장을 하는데 1. 경로는 uploadPath, 2. 중복방지를 위한 uuid 문자열 추가
			//3. uuid와 파일 이름을 구분짓기 위한 "_" 추가 4. 마지막으로 뒤에 파일 이름 붙인다.
			File saveFile = new File(uploadPath, uuid.toString() + "_" + fileName);  
			
			try {
				
				multipartFile.transferTo(saveFile); //업로드 된 파일들의 실제 파일을 생성 한다.
				
				if(isImage) { //이미지 파일이라면
					
					//썸네일 만드는 작업
					FileOutputStream fos = new FileOutputStream(
							new File(uploadPath,"s_" + uuid.toString()+"_"+fileName));
					
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), fos, 100, 100);
					
					fos.close();
					
				}
				
				//1. AttachFileDTO 타입의 파일로 변환해서 넣을거잖아요? 그래서 AttachFileDTO 객체를 하나 생성하는 거죠
				//2. 그 다음 객체에 파라미터를 넣어주면 완성이 됩니다.
				AttachFileDTO attachFileDTO = 
						new AttachFileDTO(fileName, folderPath, uuid.toString(), isImage);
				
				//만들어진 AttachFileDTO객체를 list에 추가해줍니다.
				list.add(attachFileDTO);
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //바로 \\등을 쓰지 않는 이유 - 운영체제마다 다르니까 -> windosw 2021-03-17

		String str = sdf.format(new Date()); //현재 시간으로 폴더 경로를 잡는다.
		
		return str.replace("-", File.separator); //"-"을 운영체제에 따라 바꿔준다. 2021-03-17 -> 2021\03\17
		
	}
	
}
