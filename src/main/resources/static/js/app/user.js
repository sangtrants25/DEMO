/**
 * user.html
 */
$(document).ready(function () {
           $("#jqGrid").jqGrid({
               url: 'http://localhost:8989/api/users',
               mtype: "GET",
			styleUI : 'Bootstrap',
               datatype: "json",
               colModel: [
                   { label: 'UserID', name: 'id', key: true, width: 75 },
                   { label: 'Username', name: 'username', width: 150 },
                   { label: 'Email', name: 'email', width: 150 },
               ],
			viewrecords: true,
               height: 250,
               rowNum: 20,
               pager: "#jqGridPager"
           });
       });