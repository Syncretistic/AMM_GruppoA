<%-- 
    Document   : itemList
    Created on : 11-giu-2016, 15.55.52
    Author     : Saverio
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="item" items="${itemList}">
        <json:object>
            <json:property name="name" value="${item.name}"/>
            <json:property name="imgUrl" value="${item.imgUrl}"/>
            <json:property name="price" value="${item.price}"/>
            <json:property name="quantity" value="${item.quantity}"/>
            <json:property name="id" value="${item.id}"/>
        </json:object>
    </c:forEach>
</json:array>