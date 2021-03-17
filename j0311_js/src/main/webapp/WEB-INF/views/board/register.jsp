<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Register Page</h1>

<div class="registerDiv">
  <form class="registerForm">
    <input name="title" type="text" value="등록테스트">
    <input name="content" type="text" value="등록테스트">
    <input name="writer" type="text" value="user00">
    <button class="registerBtn">등록</button>
  </form>
</div>

<!-- Modal -->
<div class="modal" id='registerModal' tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>등록 완료!</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="movePage()">Close</button>
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
function movePage(){
	//list가 아니라 bno번호를 바로 받아서 read 페이지로 가야한다.
	self.location ="/board/list";
}

//0. 버튼을 눌렀을 때 제출 방지 -> 등록확인 모달을 위해서
const regBtn = selOne(".registerBtn");
const title = selOne(".registerForm input[name='title']")
const content= selOne(".registerForm input[name='content']")
const writer = selOne(".registerForm input[name='writer']") //로그인 사용자의 ID or 닉네임이 담겨야 한다.

function sendAjax(data) {
	
	const obj = {
			method:"post",
			headers: {'Content-Type':'application/json' },
			body:JSON.stringify(data)
	}
	
	return fetch("/board/register", obj)
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

//1. 버튼 눌렀을 때 입력값 담기 -> input의 value는 이때 생긴다.
addEvent(regBtn, "click", function(e) {
	
	e.preventDefault();
	
	console.log(title.value)
	
	const data = {title:title.value, content:content.value, writer:writer.value}
	
	console.log(data);
	//2. 등록 -> fetch API(url,obj) or callback - obj는 객체리터럴
	//3. fetch headers : {'Content-Type' : json} / method : post / body : jsonstringify(data)
	const regResult = sendAjax(data); 
	
	
	//4. 등록 후 모달창 실행
	regResult.then(res => {
		
		console.log("RESULT: " + res);
		
		//$("#registerModal").modal('show');
		const modal = selOne("#registerModal");
		modal.style='display: block;';
		
		//modal.classList.add("show");
		//modal.setAttribute("aria-modal", true);
		//modal.setAttribute("style", 'dispaly: block;');
		//aria-modal="true" style="display: block;"
		
	})
	
},false)


</script>

<%@ include file="../includes/footer.jsp"%>