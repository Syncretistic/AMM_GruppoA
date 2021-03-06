<%-- 
    Document   : cliente
    Created on : 15-apr-2016, 13.17.02
    Author     : Saverio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Tonino Shop - Acquista</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="Acquista il tuo usato su Tonino Shop!">
      <meta name="keywords" content="Tonino, Shop, Elettronica, Usato, Tablet, Smartphone, Compra">
      <meta name="author" content="Saverio Salaris">
      <link rel="stylesheet" type="text/css" href="M2/style.css">
      <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
      <script type="text/javascript" src="js/searchHandler.js"></script>
   </head>
   <body class="cliente">
      <%@ include file="header.jsp" %>
      <div class="container">
         <h1>Catalogo</h1>
         <%@ include file="sidebar.jsp" %>
         <div class="content">
            <c:choose>
                <c:when test="${not empty buyer && not empty purchaseOk}">
                    <div class="success-msg">Acquisto concluso con successo!</div>
                </c:when>
                <c:when test="${not empty buyer && not empty purchaseFailed}">
                    <div class="error-msg">Fondi insufficienti! </div>
                </c:when>
                <c:when test="${empty itemDetails && not empty buyer}">
                    <c:if test="${not empty category}">
                        <h3>Category: ${category}</h3>
                    </c:if>
                    <div class="input-wrap">
                        <label for="search">Filtra gli oggetti</label>
                        <input type="text" id="search" size="15"/>
                    </div>
                    <table id="itemTable">
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
                                   <a href="cliente.html?itemId=${item.id}" class="btn-std">Aggiungi al carrello</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:when test="${not empty itemDetails && not empty buyer}">
                    <div id="reviewPurchase">
                        <h3>Dettaglio Oggetto</h3>
                        <p>Immagine: </p>
                        <img src="${itemDetails.imgUrl}" alt="Foto art." width="150" height="150"/>
                        <p>Nome: ${itemDetails.name}</p>
                        <p>Prezzo: ${itemDetails.price}</p>
                        <p>Quantità: ${itemDetails.quantity}</p>
                        <p>Descrizione: ${itemDetails.description}</p>
                        <p>Categoria: ${itemDetails.category}</p>
                        <a href="cliente.html?itemPurchase=${itemDetails.id}" class="btn-std">conferma acquisto</a>
                    </div>
                </c:when>
                <c:when test="${not empty login_error}">
                     <div class="error-msg">Zona riservata. Effettua il Login.</div>
                 </c:when>
            </c:choose>
         </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>
