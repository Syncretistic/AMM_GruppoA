<div id="header">
    <ul>
        <li class="descrizione"><a href="descrizione.html">Home</a></li>
        <li class="cliente"><a href="cliente.html">Compra</a></li>
        <li class="venditore"><a href="venditore.html">Vendi</a></li>
        <c:if test="${empty loggedBuyer && empty loggedVendor}">
            <li class="login"><a href="login.html">Login</a></li>
        </c:if>
        <c:if test="${not empty loggedBuyer || not empty loggedVendor}">
            <li class="logout"><a href="login.html?logout=true">Logout</a></li>
        </c:if>
    </ul>
</div>