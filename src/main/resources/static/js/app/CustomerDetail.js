/**
 * user.html
 */
 
$(document).ready(function() {
	GetCustomerInfo();
})

var xmlHttp = null;
var g_customer = null;
/* get customer info */
function GetCustomerInfo() {
	var id = location.search.split('id=')[1]
	var url = 'http://localhost:8989/api/Customers/Detail/' + id;
	xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = GetCustomerRequest;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

/* Process request get customer */
function GetCustomerRequest() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
		if (xmlHttp.responseText == "Not found") {
			document.getElementById("CustomerName").value = "Not found";
			document.getElementById("CustomerNo").value = "";
		} else {
			g_customer = JSON.parse(xmlHttp.responseText);
			document.getElementById("CustomerName").value = g_customer.name;
			document.getElementById("CustomerNo").value = g_customer.customerNo;
		}
	}
}

/* Save changed data */
function SaveChanges() {
	g_customer.name = document.getElementById("CustomerName").value;
	g_customer.customerNo = document.getElementById("CustomerNo").value;
	var url = 'http://localhost:8989/api/Customers/Update/' + g_customer;
	xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = UpdateCustomerRequest;
	xmlHttp.open("POST", url, true);
	xmlHttp.send(null);
}

/* Process update request */
function UpdateCustomerRequest() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
		if (xmlHttp.responseText == "Not found") {
		} else {
		}
	}
	window.location.href = 'http://localhost:8989/customerdetail.html?id=' + g_customer.id;
}