<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Read Page</h1>
  <div class="col-md-6">
    <label for="inputCity" class="form-label">City</label>
    <input type="text" class="form-control" id="inputCity" readonly="readonly">
  </div>
  <div class="col-md-8">
    <label for="inputState" class="form-label">Title</label>
    <input type="text" class="form-control" id="title" value="${board.title }" readonly="readonly">
  </div>
  <div class="col-md-2">
    <label for="inputZip" class="form-label">Writer</label>
    <input type="text" class="form-control" id="writer" value="${board.writer }" readonly="readonly">
  </div>

<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Material</th>
      <th>Quantity</th>
      <th>Unit price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td class="mdl-data-table__cell--non-numeric">${board.title }</td>
      <td>${board.content }</td>
      <td>${board.writer }</td>
    </tr>
    <tr>
      <td class="mdl-data-table__cell--non-numeric">Plywood (Birch)</td>
      <td>50</td>
      <td>$1.25</td>
    </tr>
    <tr>
      <td class="mdl-data-table__cell--non-numeric">Laminate (Gold on Blue)</td>
      <td>10</td>
      <td>$2.35</td>
    </tr>
  </tbody>
</table>

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