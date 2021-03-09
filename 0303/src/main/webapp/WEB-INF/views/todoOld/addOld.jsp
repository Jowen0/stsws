<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/todoOld/addOld" method="post">
		<!-- <input type='hidden' name='complete' value='true'> -->
		<div>
			<input type='text' name='title' value='${todoDTO.title }'>
			<spring:hasBindErrors name="todoDTO">
				<c:if test="${errors.hasFieldErrors('title') }">
					<strong>Error.....Title...... ${errors.getFieldError( 'title' ).defaultMessage }</strong>
				</c:if>
			</spring:hasBindErrors>
		</div>
		<div>
			<button class='btn'>SAVE</button>
		</div>
	</form>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous">
		
	</script>
	<script>
		function showResult() {
			alert("showResult")
			self.location = "/todo/list";
		}
		$(document).ready(function() {
			/* $(".btn").on("click", function(e) {
				e.preventDefault();
				const data = {title:$("input[name='title']").val(), complete:false}
				console.log(data);
				
				$.post("/todo/add", data, function(result) {
					//바닐라 JS로 만들려면 fetch api를 사용해야 한다.
					//항상 데이터가 제대로 날라가는지 확인해줘야한다. - Network
					console.log(result);
					
				})
				
			}) */
		})
	</script>
</body>
</html>