<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>タスク管理</h2>
        <ul>
            <c:forEach var="DTO" items="${tasks}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${DTO.id}">
                        <c:out value="${DTO.id}" />
                    </a>
                    ： &gt; <c:out value="${DTO.content}" />
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">新規</a></p>

    </c:param>
</c:import>