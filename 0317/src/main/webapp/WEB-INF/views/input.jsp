<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr/>
<button id="saveBtn">Register</button>
<hr/>
<hr/>

  <input type="file" name="uploadFile" multiple="multiple">

  <button id="uploadBtn">Upload</button>
  
  <ul class="uploadResult">
  	
  </ul>
  
  <script>
  
  document.querySelector("#saveBtn")
  .addEventListener("click", function(e){
  	
    const obj  = {
  		  title:"Title", 
  		  content:"Content",
  		  writer:"user00",
  		  fileList: arr}	
  	
    fetch("/board/register",
  		  {
  	  		method: 'post',
  	  		headers: {'Content-type': 'application/json; charset=UTF-8'},
  	  		body: JSON.stringify(obj)
  		  })

  }, false);
  
  const arr = [];
  
  const protoInput = document.querySelector("input[name='uploadFile']").outerHTML;
  
  console.dir(protoInput);
  
  //ul
  const uploadUL = document.querySelector(".uploadResult");
  
  document.querySelector("input").addEventListener("change", function(e){
	  
	  //formData 형식으로 보내기 위해서 FormData 객체를 생성
	  const formData = new FormData();
	  //파일 업로드 하기위한 input Tag를 input 변수에 할당 -> 이걸 안하면 계속 querySelector를 날려야 될 수도 있으니까 속도가 느려집니다.
	  const input = document.querySelector("input[name='uploadFile']");
	  
	  //input Tag에 있는 file들을 가져옵니다.
	  const files = input.files;
	  
	  console.dir(input);
	  
	  //let htmlCode = "";
	  //files에 있는 file 하나하나를 formData에 추가합니다.
	  for(let i = 0; i < files.length; i++) {
		  
		  //Controller의 MultipartFile[] files 변수명과 이름을 똑같이 맞춰줘야 한다.
		  //아니면 컨트롤러 부분에서 @RequestParam(key)를 설정해 줘야한다.
		  formData.append("files", files[i]);
		  //htmlCode += "<li>"+files[i].name+"</li>";
	  }
	  
	  //uploadUL.innerHTML += htmlCode;
	  
	  //fetch로 비동기 처리를 합니다. url은 "/upload", 방식은 post, 보낼 데이터는 formData
	 fetch("/upload", {method:"post", body:formData})
	  
	  //then전에 UploadController 한번 갔다 와야겠죠
	  .then(res => res.json()) //여기에서 res는 List<AttachFileDTO> list 가 반환됐죠
	  						   //이걸 json데이터로 만들어주는 코드가 res.json() 입니다.
	  						   
	  .then(jsonObj => { //화살표 함수는 결과 잖아요? jsonObj = res.json() 이 되는거죠.
		  
	 	  //console.log("json1: " + jsonObj)
	  
		  let htmlCode = ""; //ul Tag에 넣을 li들을 담기 위한 문자열 변수
		  					 //왜 배열이 아니냐? JS(자바스크립트)는 배열을 넣으면 자동으로 배열로 바뀝니다.
		  
		  for(let i = 0; i < jsonObj.length; i++) {
			  
			  let fileObj = jsonObj[i]; //fileObj의 타입을 쓰지 않는 이유: JS는 타입에 자유롭기 때문입니다.
										//fileObj에 jsonObj[i]번째 하나를 담는다.	
			  
			  //ul Tag에 넣을 <li> Tag 문자열들을 htmlCode에 담는다.
			  htmlCode += "<li id='li_"+fileObj.uuid+"'><img src='/view?file="+fileObj.thumbLink+"'>"+
			  "<button onclick='removeFile("+JSON.stringify(fileObj) +")'>DEL</button></li>";
			  
			  arr.push(fileObj);
			  
		  }
		  
		  console.log(arr);
		  
		  //ul Tag(uploadUL)에 innerHTML로 htmlCode() 
		  uploadUL.innerHTML += htmlCode; //DoM처리 한번만 되겠죠
		  
		  input.remove();
		  
		  document.querySelector("#uploadBtn").insertAdjacentHTML('beforebegin',protoInput);
	  
	  });
	  
  }, false);
  
  function removeFile(param){
	  
	  console.log(param);
	  
	  alert("REMOVE FILE");
	  
	  fetch("/removeFile", 
			  {
		  		method:'delete',
		  		headers: {'Content-type': 'application/json; charset=UTF-8'},
		  		body:JSON.stringify(param)
	  		  })
	  
	  document.querySelector("#li_" + param.uuid).remove();
	  
  }
  
  </script>
  
</body>
</html>