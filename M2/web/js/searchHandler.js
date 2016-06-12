/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function ()
{
   $("#search").keyup(function()
    {  
        var query = $("#search").val();
       
        $.ajax(
        {
            url: "filter",
            data:{
              cmd: "search",
              text: query
            },
            dataType: 'json',
            success : function(data, state){
                refreshItemList(data);
            },
            error : function(data, state){
                console.log("data not found");
            }
        });
  
        function refreshItemList(itemList)
        {
            // Cancella la lista
            $("#itemTable").empty();
            for(var i in itemList)
            {
                var html = "<tr><td><h4>" + itemList[i].name + "</h4><img src=\"" + itemList[i].imgUrl + "\" alt=\"Foto art.\"  width=\"150\" height=\"150\"/></td>";
                html += "<td class=\"itemattr\">Prezzo: " + itemList[i].price + "</td><td class=\"itemattr\">Disponibili: " + itemList[i].quantity + "</td>";
                html += "<td><a href=\"cliente.html?itemId=" + itemList[i].id + "\" class=\"btn-std\">Aggiungi al carrello</a></td></tr>";     
                $("#itemTable").append(html);
            }
        }
    }); 
});