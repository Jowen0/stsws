<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>Replies Page</h1>
<body>
<div class="replyList">
<ul class="list">

</ul>
</div>

 <!--                     페이지네이션                          -->
<div>
  <ul class="pagination">
	<c:if test="${pageMaker.prev }">
	  <li class="page-item">
	    <a class="page-link" href="${pageMaker.start - 10}" tabindex="-1">Previous</a>
	  </li>
	</c:if>
	   
	<c:forEach begin="1" end="${totalcount}" var = "num">
	  <li class="page-item ${num == pageMaker.pageDTO.page?"active":"" }"><a class="page-link" href="${num }">${num }</a></li>
	</c:forEach> 
	<c:if test="${pageMaker.next }">
	  <li class="page-item">
	    <a class="page-link" href="${pageMaker.end + 1}">Next</a>
	 	</li>
	</c:if>
  </ul>
</div>

<script>
const totalcount = 15;
let skip = parseInt(totalcount / 10) * 10;
console.log(skip);

const service = (function () {

        function bringGet(obj){

            return fetch("http://localhost:8080/samples/get1?skip="+obj.skip+"&bno="+obj.bno)
            //then이 실행되기 전까지 SampleController에 갔다가 List<Reply> 데이터를 가지고 온 겁니다. ----- 1
            //그 이후 then이 실행되는 거죠
            .then(response => response.json()) //response 가져온거 json 객체로 만들어 ------ 2

        }

        function sendDelete(sno){

            return fetch("http://localhost:8080/samples/"+sno, {

                method:"delete"

            }).then(res => res.json())

        }

        return {bringGet:bringGet, sendDelete:sendDelete}

    })();
	
    let list = [{ }]; //객체의 배열 생성
 
    const obj = {bno:262, skip:skip}; //bno, skip 값
    
    service.bringGet(obj)
    // ------- 1,2 까지죠
    .then(result => { //--------- 3

        console.log(result); //2번으로 만든 json 데이터를 브라우저 console 창에 뿌려
        
        list = result; //list(객체의 배열)에 json 객체 배열을 넣는다.
        
        console.log(list); //list에 잘 담겼는지 확인
        
        let htmlCode = ""; //Dom처리를 한번에 하기위해 li Tag들을 담을 변수 생성
        
        list.forEach(reply => { 
        	
        	//list 하나하나를 li Tag로 htmlCode에 넣는다.
        	
        htmlCode += "<li>reply: "+reply.reply+" / "+"replyer: "+reply.replyer+"</li>";
        	
        })
        
         document.querySelector(".list").innerHTML = htmlCode; // innerHTML로 Dom에 추가한다.
        
        console.log(${pageMaker})

    })
    
    

    //service.sendDelete(112).then(result => console.log(result));    

</script>


</body>
</html>