<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Register Page</h1>

<div class="registerDiv">
	<form class="registerForm">
		<input name="title" type="text" value="등록테스트"> <input
			name="content" type="text" value="등록테스트"> <input
			name="writer" type="text" value="user00">
		<button class="registerBtn">등록</button>
	</form>
</div>

<div class="uploadDiv">
	<input type="file" name="uploadFile" multiple="multiple">

	<button id="uploadBtn">Upload</button>

	<ul class="uploadResult">

	</ul>
</div>

<!-- Modal -->
<div class="modal" id='registerModal' tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Message</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>등록 완료!</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"
					onclick="movePage()">Close</button>
			</div>
		</div>
	</div>
</div>

<script>
//utill
const selOne = document.querySelector.bind(document);
const selAll = document.querySelectorAll.bind(document);
const addEvent = function (param,event,func,cap) {
	
	param.addEventListener(event,func,cap);
	
	return param;
}

//선언문
//파일업로드 전 input Tag
const protoInput = selOne("input[name='uploadFile']").outerHTML;
//업로드 ul
const uploadUL = selOne(".uploadResult");
const formData = new FormData();

const regBtn = selOne(".registerBtn");
const title = selOne(".registerForm input[name='title']")
const content= selOne(".registerForm input[name='content']")
const writer = selOne(".registerForm input[name='writer']") //로그인 사용자의 ID or 닉네임이 담겨야 한다.

function movePage(){
	//list가 아니라 bno번호를 바로 받아서 read 페이지로 가야한다.
	self.location ="/board/list";
}

function sendAjax(url, obj) {
	
	return fetch(url, obj)
			.then(res => {
				
				if(!res.ok) {
					console.log("success")
					throw new Error(res)
					
				}
				
				return res.text();
				
			})
			.catch(error => {
				console.log("catch..........")
				console.log(error)
			})
			
}
//실행문
//1. 파일 업로드
addEvent(".uploadDiv", "change", function(e){
	
	e.preventDefault();
	e.stopPropagation();

	const input = selOne("input[name='uploadFile']");

	const files = input.files;
	  
	//console.dir(input);
	  
	let htmlCode = "";
	
	for(let i = 0; i < files.length; i++) {
		  
	  formData.append("files", files[i]);
	  htmlCode += "<li>"+files[i].name+"</li>";

	}
	
	uploadUL.innerHTML += htmlCode;
	
	input.outerHTML = protoInput;
	
	//console.dir(input);
	
}, false);
	

//2.게시물 등록
addEvent(regBtn, "click", function(e) {
	
	e.preventDefault();
	
	const uploadUrl = "/upload";
	const uploadObj = {method:"post", 
					   body:formData};
	
	//업로드 파일 등록
	const uploadResult = sendAjax(uploadUrl, uploadObj)
	 
	uploadResult.then(res => res.json())
	.then(jsonObj => {
		 
		
		 
	 }
	
	//게시물 등록
	const data = {title:title.value, content:content.value, writer:writer.value, filePath:}
	
	const regUrl = "/board/register";
	const regObj = {
			
			method:"post",
			headers: {'Content-Type':'application/json' },
			body:JSON.stringify(data)
	}
	
	const regResult = sendAjax(regUrl, regObj);
	
	regResult.then(res => {
		
		console.log("RESULT: " + res);
		
		const modal = selOne("#registerModal");
		modal.style='display: block;';
		
	})
	
},false)


</script>

<%@ include file="../includes/footer.jsp"%>