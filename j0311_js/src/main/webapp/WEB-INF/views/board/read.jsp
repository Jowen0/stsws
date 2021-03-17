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

 <!--                    actionForm                      -->
<div class="activity">
  <form class="actionForm" action="/board/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}">
	<input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
	<input type="hidden" name="type" value="${pageDTO.type}">
	<input type="hidden" name="keyword" value="${pageDTO.keyword}">
  </form>	
</div> 

<div class="buttionDiv">
<button class="modifyBtn">수정/삭제</button>
<button class="listBtn">목록</button>
</div>

<script>
//utill
const selOne = document.querySelector.bind(document);
const selAll = document.querySelectorAll.bind(document);
const addEvent = function (param,event,func,cap) {
	
	const target = document.querySelector(param);
	
	target.addEventListener(event,func,cap);
	
	return target;
}

//실행문
const actionForm = selOne(".actionForm");

addEvent(".modifyBtn", "click", function(e){

	e.preventDefault();
	e.stopPropagation();
	
	actionForm.setAttribute("action", "/board/modify");
	actionForm.innerHTML += "<input type='hidden' name='bno' value='"+${board.bno }+"'>";
	actionForm.submit();
	
}, false)

addEvent(".listBtn", "click", function(e){

	e.preventDefault();
	e.stopPropagation();

	actionForm.submit();
	
}, false)

</script>


<%@ include file="../includes/footer.jsp"%>