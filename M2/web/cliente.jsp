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

<!--
                <tr>
                  <td>
                     <h4>D510 MT Desktop Computer</h4>
                     <img src="./img/Desktop1.jpg" alt="Foto art.1" width="150" height="150"/>
                  </td>
                  <td class="itemattr">
                     Prezzo: 799,66€
                  </td>
                  <td class="itemattr">
                     Disponibili: 15
                  </td>
                  <td>
                     <a href="cliente.jsp" class="btn-std">Aggiungi al carrello</a>
                  </td>
               </tr>
               <tr>
                  <td>
                     <h4>Smartphone Samsung Galaxy s6</h4>
                     <img src="./img/GalaxyS6.jpg" alt="Foto art.2" width="150" height="150"/>
                  </td>
                  <td class="itemattr">
                     Prezzo: 539,90€
                  </td>
                  <td class="itemattr">
                     Disponibili: 2
                  </td>
                  <td>
                     <a href="cliente.jsp" class="btn-std">Aggiungi al carrello</a>
                  </td>
               </tr>
               <tr>
                  <td>
                     <h4>Hannspree Tablet PC 10,1"</h4>
                     <img src="./img/HanspreeTablet1.jpg" alt="Foto art.3" width="150" height="150"/>
                  </td>
                  <td class="itemattr">
                     Prezzo: 260,66€
                  </td>
                  <td class="itemattr">
                     Disponibili: 12
                  </td>
                  <td>
                     <a href="cliente.jsp" class="btn-std">Aggiungi al carrello</a>
                  </td>
               </tr>
               <tr>
                  <td>
                     <h4>Apple Iphone 6</h4>
                     <img src="./img/Iphone1.jpg" alt="Foto art.4" width="150" height="150"/>
                  </td>
                  <td class="itemattr">
                     Prezzo: 666,66€
                  </td>
                  <td class="itemattr">
                     Disponibili: 5
                  </td>
                  <td>
                     <a href="cliente.jsp" class="btn-std">Aggiungi al carrello</a>
                  </td>
               </tr>
               <tr>
                  <td>
                     <h4>ASUS - Notebook con Monitor 15,6" Full HD</h4>
                     <img src="./img/Laptop1.jpg" alt="Foto art.5" width="150" height="150"/>
                  </td>
                  <td class="itemattr">
                     Prezzo: 659,99€
                  </td>
                  <td class="itemattr">
                     Disponibili: 22
                  </td>
                  <td class="itemattr">
                     <a href="cliente.jsp" class="btn-std">Aggiungi al carrello</a>
                  </td>
               </tr>
               <tr>
                  <td>
                     <h4>ASUS - VS228DE Monitor 21.5</h4>
                     <img src="./img/Monitor1.jpg" alt="Foto art.6" width="150" height="150"/>
                  </td>
                  <td class="itemattr">
                     Prezzo: 119,99€
                  </td>
                  <td class="itemattr">
                     Disponibili: 37
                  </td>
                  <td class="itemattr">
                     <a href="cliente.jsp" class="btn-std">Aggiungi al carrello</a>
                  </td>
               </tr>
               <tr>
                  <td>
                     <h4>Western Digital Caviar Black 1 TB</h4>
                     <img src="./img/HDD1.jpg" alt="Foto art.5" width="150" height="150"/>
                  </td>
                  <td class="itemattr">
                     Prezzo: 79,99€
                  </td>
                  <td class="itemattr">
                     Disponibili: 320
                  </td>
                  <td class="itemattr">
                     <a href="cliente.jsp" class="btn-std">Aggiungi al carrello</a>
                  </td>
               </tr>
               -->