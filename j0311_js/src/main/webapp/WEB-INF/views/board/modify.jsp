<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Read Page</h1>

<div class="board_list">
  <ul class="list">
  	  <li><a href="${board.bno }">${board }</a></li>
  </ul>
</div>

 <!--                    modifyDiv                      -->
<div class="modifyDiv">
  <form class="modifyForm">
    <input name="title" type="text" value="수정테스트">
    <input name="content" type="text" value="수정테스트">
    <input name="writer" type="text" value="user00">
  </form>
</div>

 <!--                    buttonDiv                      -->
<div class="buttonDiv">
    <button class="modifyBtn">수정</button>
    <button class="removeBtn">삭제</button>
	<button class="listBtn">목록</button>
</div>

 <!--                    actionForm                      -->
<div class="activity">
  <form class="actionForm" action="/board/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}">
	<input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
	<input type="hidden" name="type" value="${pageDTO.type}">
	<input type="hidden" name="keyword" value="${pageDTO.keyword}">
  </form>	
</div>

<!--						 Modal						 -->
<div class="modal" id='modifyModal' tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>수정 완료!</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="movePage()">Close</button>
      </div>
    </div>
  </div>
</div>   

<script>
//utill
const selOne = document.querySelector.bind(document); //querySelector 함수 변수로 지정
const selAll = document.querySelectorAll.bind(document); //querySelectorAll 함수 변수로 지정
const addEvent = function (param,event,func,cap) { //이벤트추가 함수 변수로 지정
	
	const target = document.querySelector(param);
	
	target.addEventListener(event,func,cap);
	
	return target;
}

//선언문
function movePage(){
	//list가 아니라 bno번호를 바로 받아서 read 페이지로 가야한다.
	actionForm.submit();
}

const bno = ${board.bno}; //bno 값
const title = selOne(".modifyForm input[name='title']"); //제목
const content= selOne(".modifyForm input[name='content']"); //내용
const writer = selOne(".modifyForm input[name='writer']"); //작성자 - 나중에 로그인 사용자의 ID or 닉네임이 담겨야 한다.
const modal = selOne("#modifyModal"); //모달
const actionForm = selOne(".actionForm"); //actionForm

const modify = "/board/modify"; //post modify 주소
const remove = "/board/remove"; //post remove 주소
const url = null; //url 변수 선언

function sendAjax(data, url) { //파라미터는 data, url
	
	const obj = {
			method:"post",
			headers: {'Content-Type':'application/json'},
			body:JSON.stringify(data)
	}
	
	return fetch(url, obj) //파라미터는 url, obj
			.then(response => {//fetch API 실행 후 post Controller로 부터 return으로 받은 값을 response라고 명명
				
				if(!response.ok) {//만약 응답이 OK가 아니라면
					
					console.log(response)
					throw new Error(response) //에러 생성 후 에러에 response를 파라미터로 담는다.
					
				}
				
				return response.text(); //응답이 OK라서 if문에 걸리지 않았다면 바로 응답을 text로 return 한다.
				
			})
			.catch(error => {//error가 생기면 
				console.log("catch..........")
				console.log(error)
			})
			
}

//실행문
addEvent(".modifyBtn", "click", function(e) {
	//actionForm Tag의 action 속성의 값을 "/board/read"로 바꾼다
	actionForm.setAttribute("action", "/board/read");
	
	//수정을 하려면 bno번호가 필요하기 때문에 bno값을 파라미터로 넘겨줄 수 있는 input Tag를 추가한다.
	actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
	
	//fetch API Body에 넣을 데이터 값을 각각의 input Tag로 부터 가져온다. 단, 여기서 bno는 그냥 board의 bno이다. //위에 선언문 참고
	const data = {bno:bno, title:title.value, content:content.value, writer:writer.value}

	//수정작업을 fetch API를 이용해서 Ajax(비동기) 처리 한다.
	const modResult = sendAjax(data, modify); 
	
	//post modify 응답 완료 후 실행부분 -> 이때 위쪽 sendAjax 부분이 실행된다.
	modResult.then(res => {
		
		console.log("RESULT: " + res);
		//모달창을 보여준다 - Vanilla JS
		modal.style='display: block;';
		
	})
	
},false)

//삭제 버튼 클릭
addEvent(".removeBtn", "click", function(e) {
	//actionForm Tag의 action 속성의 값을 "/board/list"로 바꾼다 - 삭제 후 read 페이지로 못 가기 때문에 list로 이동
	actionForm.setAttribute("action", "/board/list");
	
	//fetch에 넣을 data = bno - delete 하려면 bno만 필요하기 때문에
	const data = bno; 
	
	//console.log(data); - data가 잘 들어오는지 테스트용

	//삭제작업을 fetch API를 이용해서 Ajax(비동기) 처리 한다. -> 이때 위쪽 sendAjax 부분이 실행된다.
	const removeResult = sendAjax(data, remove); 
	
	//post remove 응답 완료 후 실행부분
	removeResult.then(res => {
		
		console.log("RESULT: " + res);
		//모달창의 P Tag 내용을 수정한다. - 삭제니까 삭제완료!
		selOne(".modal-body").innerHTML = "<p>삭제 완료!</p>";
		
		//모달창을 보여준다 - Vanilla JS
		modal.style='display: block;';
		
	})
	
},false)

//목록 버튼 클릭
addEvent(".listBtn", "click", function(e){
	//actionForm의 action 속성이 list이기 때문에 그냥 Form처리( submit() )하면 된다.
	actionForm.submit();
	
}, false)
</script>


<%@ include file="../includes/footer.jsp"%>