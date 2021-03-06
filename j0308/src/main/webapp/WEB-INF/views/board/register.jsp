<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Blank Page</h1>
                    
<div class="modal" id='registerModal' tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick = "movePage()">Close</button>
      </div>
    </div>
  </div>
</div>                    
					
<script>
//스크립트도 외부로 빼줘야 한다.

function movePage(){
	self.location = "/board/list"; //window.location //this.location 상관없다(this가 window인 경우)
	//alert("movePage");
}

function sendAjax(data) {
	
	console.log("sendAjax....", data);
	
	//fetch - 비동기
	return fetch("/board/register", 
			{method:"post", headers:{'Content-Type':'application/json'}, body:JSON.stringify(data)})
	.then(res => {
		if(!res.ok){
			throw new Error(res);
		}
		return res.text() //함수를 넣어도 되지만 화살표 함수를 쓴다. 자바스크립트에서는 화살표 함수라고 한다.	
	})
	.catch(error => {
		
		console.log("catch..................")
		console.log(error)
		
	});	//.then(result => ) //어싱크 어웨이트 개념이 필요하다.
	
}

const data = {title:"한글 제목", content:"게시물 내용", writer:"user00"}; //객체를 찍어내야할 때는 JS class를 사용한다.

const fnResult = sendAjax(data);

/* fnResult.then(result => {
	console.log("RESULT: " + result);
}) */

fnResult.then(function(result) {
	console.log("RESULT: " + result);
	$("#registerModal").modal('show')
	 
})

//위 코드를 이쁘게 만드는 방법 생각해보기

</script>
					
<%@include file="../includes/footer.jsp"%>    