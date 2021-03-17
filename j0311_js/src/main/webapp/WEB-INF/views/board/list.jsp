<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Blank Page</h1>

<!--                     게시글 목록                        -->

<div class="board_list">
  <ul class="list">
	<c:forEach items="${list }" var="board" >
  	  <li><a href="${board.bno }">${board }</a></li>
	</c:forEach>
  </ul>
</div>

<!--                       검색 조건                       -->

<div class="searchDiv">
  <select class="stype">
    <option value="">-------------</option>
    <option value="t" ${pageDTO.type == 't'?"selected":"" }>제목</option>
    <option value="c" ${pageDTO.type == 'c'?"selected":"" }>내용</option>
    <option value="tc" ${pageDTO.type == 'tc'?"selected":"" }>제목+내용</option>
  </select>
  <input name ='skeyword' type="text" value="<c:out value="${pageDTO.keyword }"/>">
  <button class="searchBtn">검색</button>
</div>

 <!--                     페이지네이션                          -->
<div>
  <ul class="pagination">
	<c:if test="${pageMaker.prev }">
	  <li class="page-item">
	    <a class="page-link" href="${pageMaker.start - 10}" tabindex="-1">Previous</a>
	  </li>
	</c:if>
	   
	<c:forEach begin="${pageMaker.start }" end="${pageMaker.end }" var = "num">
	  <li class="page-item ${num == pageMaker.pageDTO.page?"active":"" }"><a class="page-link" href="${num }">${num }</a></li>
	</c:forEach> 
	<c:if test="${pageMaker.next }">
	  <li class="page-item">
	    <a class="page-link" href="${pageMaker.end + 1}">Next</a>
	 	</li>
	</c:if>
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


 <!--                     Footer                         -->
<div class="footer">
<button class="registerBtn">등록</button>  
${pageDTO }
<br>
${pageMaker }
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

addEvent(".pagination", "click", function(e){
	
	e.preventDefault();
	e.stopPropagation();
	
	const target = e.target;
	
	const pageNum = target.getAttribute("href")
	
	if(pageNum){
	selOne(".actionForm input[name='page']").value = pageNum;
	
	actionForm.submit();
	}
	
}, false);

addEvent(".board_list", "click", function(e) {
	
	e.preventDefault();
	e.stopPropagation();
	
	const target = e.target;
	
	const bno = target.getAttribute("href");
	if(bno){

	actionForm.setAttribute("action", "/board/read");
	actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
	actionForm.submit();
		
	}
	
}, false);

addEvent(".searchBtn", "click", function(e) {
	
	e.preventDefault();
	e.stopPropagation();
	
	const stype = selOne(".stype");
	const idx = stype.selectedIndex;
	const type = stype[idx].value;
	
	selOne(".actionForm input[name='type']").value = type;
	
	const keyword = selOne(".searchDiv input[name='skeyword']").value;
	
	selOne(".actionForm input[name='keyword']").value = keyword;
	selOne(".actionForm input[name='page']").value = 1;
	actionForm.submit();
	 
}, false);

addEvent(".registerBtn", "click", function(e){

	e.preventDefault();
	e.stopPropagation();
	
	window.location = "/board/register"
	
}, false)

</script>

<%@ include file="../includes/footer.jsp"%>