$(document).ready(function() {
	$('#multiple-checkboxes').multiselect({
		includeSelectAllOption: true,
	});
	
});

function serversToBuy() {
	var selectedItems = $('#multiple-checkboxes');
	var selected1 = [];
	for (var i = 0; i < selectedItems.length; i++) {
		for (var j = 0; j < selectedItems[i].options.length; j++) {
			if (selectedItems[i].options[j].selected) selected1.push(selectedItems[i].options[j].value);
		}

	}
    var seletedIds =  selected1.join();
  
    var input = $("<input>")
               .attr("type", "hidden")
               .attr("name", "submittedIds").val(seletedIds);
    $('#selectedServers').append(input);

    $('#selectedServers').submit();
}

function submitOrder(){
	var quanityInput = $("[id^=quantity_]");
	
	var quantityReceived=0;
	for(var i=0;i<quanityInput.length;i++){
		 quantityReceived = quantityReceived + parseInt(quanityInput[i].value) ;
	}
	if(quantityReceived>2){
		alert("Total quantity must be equal to  2");
		return false;
	}
	
	var serverRows = $("[id^=server_]");
	
	var objSeverArr=[];
	for(var i=0;i<serverRows.length;i++){
	  var rowid = serverRows[i].id;
	  var idPart= rowid.split("_");
	  var idNum = idPart[1];
	  
	  var serverName = $('#serverName_'+idNum)[0].innerHTML;
	  var serverPrice = $('#serverPrice_'+idNum)[0].innerHTML;
	  var serverQuantity = $('#quantity_'+idNum)[0].value;
	  
	  var server ={};
	  server.serverId=idNum;
	  server.serverName = serverName;
	  server.serverPrice = serverPrice;
	  server.quantity = serverQuantity;
	  
	  objSeverArr.push(server);
		 
	}
	calculatePrice(objSeverArr);
	return false;
}


function calculatePrice(objSeverArr){

	$.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/calculatePrice",
        data :JSON.stringify(objSeverArr), 
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
           if(data && data.formattedPrice){
            console.log("SUCCESS: ", data.formattedPrice);
            $('#total').text(data.formattedPrice);
            $('#totalAmount').css("visibility", "visible")
           
           }
           
            
        },
        error : function(e) {
            console.log("ERROR: ", e);
           
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}