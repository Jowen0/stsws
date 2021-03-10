<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Blank Page</h1>
                    
<ul>
<c:forEach items="${list }" var="board">
<li><a href="${board.bno }">${board}</a></li>
</c:forEach>
</ul>

<ul class="pagination">
  <c:if test="${pageMaker.prev}">
   	<li class="page-item">
      <a class="page-link" href="${pageMaker.start - 10}" tabindex="-1">Previous</a>
    </li>
  </c:if>
   
  <c:forEach begin = "${pageMaker.start}" end="${pageMaker.end }" var="num">
    <li class="page-item ${num == pageMaker.pageDTO.page?"active":"" }"><a class="page-link" href="${num }">${num }</a></li>
  </c:forEach>
   
  <c:if test="${pageMaker.next }">
    <li class="page-item">
      <a class="page-link" href="${pageMaker.end + 1}">Next</a>
   	</li>
  </c:if>
</ul>

<form class="actionForm" action="/board/list" method="get">
  <input type="hidden" name = 'page' value="${pageDTO.page }">
  <input type="hidden" name = 'perSheet' value="${pageDTO.perSheet }">
</form>

<script>

const selOne = document.querySelector.bind(document);
const selAll = document.querySelectorAll.bind(document);
	
const event = document.addEventListener.bind(document);

const actionForm = selOne(".actionForm");

console.log(selOne);
console.log(actionForm);
console.log(event);

selOne(".pagination").addEventListener("click", function(e) {
	
	e.preventDefault();
	//e.stoppropagation();
	const target = e.target;
	
	console.log(target);
	
	const pageNum = target.getAttribute("href");
	
	console.log(pageNum);
	
	selOne(".actionForm input[name='page']").value = pageNum;
	actionForm.submit();
	
	
}, false)

</script>


${pageMaker }



<%@include file="../includes/footer.jsp"%>               