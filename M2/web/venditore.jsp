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
                <c:when test="${not empty itemPosted && not empty vendor}">
                    <h3>Annuncio postato!</h3>
                    <p>Immagine: </p>
                    <img src="${itemPosted.imgUrl}" alt="Foto art." width="150" height="150"/>
                    <p>Nome: ${itemPosted.name}</p>
                    <p>Prezzo: ${itemPosted.price}</p>
                    <p>Quantità: ${itemPosted.quantity}</p>
                    <p>Descrizione: ${itemPosted.description}</p>
                    <p>Categoria: ${itemPosted.category}</p>
                </c:when>
                <c:when test="${not empty vendor && empty login_error}">
                <h2 class="greybg">Inserisci il tuo annuncio</h2>
                <a href="venditore.html?UpdateItem=true"><button class="btn-std">Modify/delete existing item</button></a>
                <div class="sellerform">
                  <form method="get" action="venditore.html">
                     <div class="input-wrap">
                        <label for="itemName">Nome Articolo: </label>
                        <input id="itemName" type="text" name="itemName">
                     </div>
                     <div class="input-wrap">
                        <label for="imgUrl">Immagine (url) : </label>
                        <input id="imgUrl" type="url" name="imgUrl">
                     </div>
                      <div class="input-wrap">
                        <label for="itemCat">Categoria: </label>                    
                        <select name="itemCat" id="itemCat">
                          <option value="Desktop">Desktop</option>
                          <option value="Tablet">Tablet</option>
                          <option value="Smartphone">Smartphone</option>
                          <option value="Laptop">Laptop</option>
                        </select>
                     </div>
                     <div class="input-wrap">
                        <label for="itemDesc">Descrizione: </label>
                        <textarea rows="5" cols="30" id="itemDesc" name="itemDesc"></textarea>
                     </div>
                     <div class="input-wrap">
                        <label for="itemPrice">Prezzo: </label>
                        <input id="itemPrice" type="number" min="0" step="0.01" name="itemPrice">
                     </div>
                     <div class="input-wrap">
                        <label for="itemQuantity">Quantità: </label>
                        <input id="itemQuantity" type="number" min="1" step="1" name="itemQuantity">
                     </div>
                     <c:if test="${not empty input_error}">
                      <div class="error-msg">Verifica di aver inserito i dati correttamente.</div>
                     </c:if>
                     <div class="input-wrap"> 
                     <input type="submit" name="SubmitItem" value="INSERISCI OGGETTO" class="btn-std">
                     </div>
                     </form>
                    
               </div>
                </c:when>
               <c:when test="${not empty login_error}">
                   <div class="error-msg">Zona riservata. Effettua il login.</div>
               </c:when>
            </c:choose>
         </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>
