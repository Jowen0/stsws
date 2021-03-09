<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach items="${list }" var="todoDTO">
			<li>${todoDTO }</li>
		</c:forEach>
	</ul>
	
	<!-- Old방식 -->
	<script>
	//${param.msg}//EL에는 param이라는 것이 있다. 이렇게 하면 자바스크립트 소스코드라서 오류가 뜬다.
	/* 때문에 이렇게 자바스크립트 변수로 선언해야 한다. */
	/* const msg = '${param.msg}' */
	
	//rttr선언 후
	const msg = '${msg}'
	//이것만으로 다 해결이 되지않는다. 뒤로가기 했다가 앞으로 오면 다시 Alert창이 뜬다.
	//그래서 JS로 브라우저 뒤로가기 막기라는 방법이 생겼다. 
	
	if(msg ==='success'){
		alert("성공")
	}
	</script>
</body>
</html>