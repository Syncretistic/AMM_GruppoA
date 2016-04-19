<%-- 
    Document   : descrizione
    Created on : 15-apr-2016, 13.17.11
    Author     : Saverio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tonino Shop</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Compravendita e assistenza tecnica per dispositivi elettronici usati">
        <meta name="keywords" content="Tonino, Shop, Elettronica, Usato, Tablet, Smartphone">
        <meta name="author" content="Saverio Salaris">
        <link rel="stylesheet" type="text/css" href="M2/style.css">
    </head>
    <body class="descrizione">
        <%@ include file="header.jsp" %>
        <div class="container">
            <h1>Tonino Shop</h1>
            <%@ include file="sidebar.jsp" %>
            <div class="content">
            <p>
                Tonino Shop è un marketplace online per la compravendita di dispositivi elettronici nuovi e usati. Lo Shop può inoltre valutare e acquistare il vostro usato. 
            </p>
            <h2>Servizi</h2>
            <ul class="features">
                <li><a href='#vendita'>Vendita online</a></li>
                <li><a href='#acquisto'>Acquisto</a></li>
                <li><a href='#riparazione'>Riparazione e assistenza tecnica</a></li>
                <li><a href='#usato'>Rivalutazione usato</a></li>
            </ul>
            <h3 id='vendita'>Vendita online</h3>
            <p>Su Tonino puoi vendere il tuo usato agli altri utenti, attraverso il comodo sistema di annunci del nostro marketplace. Ti basta inserire nome del modello, scheda tecnica e almeno una fotografia dell'oggetto, inserire un prezzo e aspettare che qualcuno lo acquisti!</p>
            <h3 id='acquisto'>Acquisto</h3>
            <p>Acquista pc, cellulari, tablet usati, garantiti da Tonino Shop, a prezzi super convenienti, risparmia oltre 50% sul prezzo di listino.</p>
            <h3 id='riparazione'>Riparazione e assistenza tecnica</h3>
            <p>Tonino offre anche servizi di riparazione agli utenti, che dovranno spedire i loro dispositivi ai nostri magazzini, dove verranno processati e riparati in tempi brevissimi, grazie al nostro staff affidabile e competente. Offriamo inoltre assistenza dei nostri tecnici via remoto per problemi di tipo software.</p>
            <h3 id='usato'>Rivalutazione usato</h3>
            <p>Tonino acquista il vostro usato, anche non funzionante, a prezzi vantaggiosi!. Liberatevi delle vostre cianfrusaglie elettroniche e guadagnate allo stesso tempo.</p>
            </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
