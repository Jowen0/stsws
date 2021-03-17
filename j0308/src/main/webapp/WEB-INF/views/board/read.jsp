<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Read Page</h1>

<ul>
	<li>
	  <span><a class='listA' href="<c:out value="${board.bno }"/>"><c:out value="${board.bno }"></c:out></a></span>
	  <c:out value="${board.title }"></c:out>
	</li>
</ul>