/**
 * user.html
 */
$(document).ready(function () {
           $("#jqGrid").jqGrid({
               url: 'http://localhost:8989/api/Customers',
               mtype: "GET",
			styleUI : 'Bootstrap',
               datatype: "json",
               colNames: ['Customer ID', 'Customer Name', 'Customer No', 'Edit', 'Delete' ],
               colModel: [ 
                   {name:'id',index:'id',width:50},
                   {name:'name',index:'name',width:80},
                   {name:'customerNo',index:'customerNo', width:100},
                   {name:'edit',index: 'id', width: 50},
                   {name:'delete',search:false,index:'id',width:35,sortable: false,formatter: deleteLink},      
               ],
			viewrecords: true,
               height: 250,
               rowNum: 20,
               pager: "#jqGridPager",
               gridComplete: function(){
           		var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
           		for(var i=0;i < ids.length;i++){
           			var cl = ids[i];
           			be = "<input style='height:22px;width:50px;' type='button' value='Edit' onclick=\"EditCustomer('"+cl+"')\"  />";  
           			jQuery("#jqGrid").jqGrid('setRowData',ids[i],{edit:be});
           		}	
           	},
           });
       });
//jQuery("#jqGrid").jqGrid('navGrid',"#prowed2",{edit:false,add:false,del:false});

function EditCustomer(ID) {
	window.location.href = 'http://localhost:8989/customerdetail.html?id=' + ID;
}

function deleteLink(cellValue, options, rowdata, action)  {
    //return "<a href='javascript:deleteRecord(" + rowdata.userId + ")' class='ui-icon ui-icon-closethick'></a>";
}
function deleteRecord(id){
    var result = confirm("Are you sure you Want to delete?");
    if (result==true) {
        window.location.href="<%=request.getContextPath()%>/Admin/deleteUser/"+id;
    }
}