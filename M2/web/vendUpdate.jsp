<%-- 
    Document   : venditore
    Created on : 15-apr-2016, 13.17.20
    Author     : Saverio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Tonino Shop - Vendi</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="Vendi su Tonino Shop">
      <meta name="keywords" content="Tonino, Shop, Elettronica, Usato, Tablet, Smartphone, Vendita">
      <meta name="author" content="Saverio Salaris">
      <link rel="stylesheet" type="text/css" href="M2/style.css">
   </head>
   <body class="venditore">
      <%@ include file="header.jsp" %>
      <div class="container">
         <h1>Vendi su Tonino Shop</h1>
         <%@ include file="sidebar.jsp" %>
         <div class="content">
             <c:choose>
                 <c:when test="${empty modItem && not empty itemModified}">
                     <div class="success-msg">Oggetto modificato con successo!</div>
                 </c:when>
                 <c:when test="${empty modItem}">
                    <table>
                        <c:forEach var="item" items="${itemList}">
                            <tr>
                                        <td>
                                           <h4>${item.name}</h4>
                                           <img src="${item.imgUrl}" alt="Foto art." width="150" height="150"/>
                                        </td>
                                        <td class="itemattr">
                                           Prezzo: ${item.price}€
                                        </td>
                                        <td class="itemattr">
                                           Disponibili: ${item.quantity}
                                        </td>
                                        <td>
                                           <a href="venditore.html?UpdateItem=true&delItemId=${item.id}" class="btn-std">Elimina</a>
                                        </td>
                                        <td>
                                           <a href="venditore.html?UpdateItem=true&modItemId=${item.id}" class="btn-std">Modifica</a>
                                        </td>
                            </tr>
                        </c:forEach>
                    </table>
                 </c:when>
                 <c:when test="${not empty modItem}">
                     <div class="sellerform">
                        <form method="get" action="venditore.html">
                            <div class="input-wrap">
                              <label for="itemName">Nome Articolo: </label>
                              <input id="itemName" type="text" name="itemName" value="${modItem.name}">
                            </div>
                            <div class="input-wrap">
                              <label for="imgUrl">Immagine (url) : </label>
                              <input id="imgUrl" type="url" name="imgUrl" value="${modItem.imgUrl}">
                            </div>
                            <div class="input-wrap">
                              <label for="itemCat">Categoria: </label>                    
                              <select name="itemCat" id="itemCat"">
                                <option value="Desktop">Desktop</option>
                                <option value="Tablet">Tablet</option>
                                <option value="Smartphone">Smartphone</option>
                                <option value="Laptop">Laptop</option>
                              </select>
                            </div>
                            <div class="input-wrap">
                              <label for="itemDesc">Descrizione: </label>
                              <textarea rows="5" cols="30" id="itemDesc" name="itemDesc">${modItem.description}</textarea>
                            </div>
                            <div class="input-wrap">
                              <label for="itemPrice">Prezzo: </label>
                              <input id="itemPrice" type="number" min="0" step="0.01" name="itemPrice" value="${modItem.price}">
                            </div>
                            <div class="input-wrap">
                              <label for="itemQuantity">Quantità: </label>
                              <input id="itemQuantity" type="number" min="1" step="1" name="itemQuantity" value="${modItem.quantity}">
                            </div>
                            <c:if test="${not empty input_error}">
                                <div class="error-msg">Verifica di aver inserito i dati correttamente.</div>
                            </c:if>
                            <div class="input-wrap"> 
                                <button type="submit" name="ModifyItem" value="${modItem.id}" class="btn-std">Modify Item</button>
                            </div>
                        </form>
                    </div>
                 </c:when>
             </c:choose>
         </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>
