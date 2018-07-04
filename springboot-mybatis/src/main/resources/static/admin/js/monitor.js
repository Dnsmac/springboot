
function deal(id,projectId,pageNow,obj) {
	$.ajax({
        url: "/monitor/deal",
        type: "post",
        async: true,
        data : {
            'id':id
            },
        dataType: "json",
        success: function (data) {
        	alert('标记为已处理成功！');
        	var msg = $('#platform').val();
        	var dataType = $('#dateTime').val();
        	var isDeal = $('#isDeal').val();
        	$.get(
        			'/admin/view/monitor/'+projectId,
        			{"msg":msg, "dataType":dataType, "pageNow":pageNow, "isDeal":isDeal},
        			function(data){
        				
        				$(".content").html(data);
        			});
        }
    });
};

function query(projectId) {
	var msg = $('#platform').val();
	var dataType = $('#dateTime').val();
	var isDeal = $('#isDeal').val();
	$.get(
			'/admin/view/monitor/'+projectId,
			{"msg":msg, "dataType":dataType, "isDeal":isDeal},
			function(data){
				
				$(".content").html(data);
			});
	
};

