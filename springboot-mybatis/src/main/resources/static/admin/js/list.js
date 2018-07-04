 var tale = new $.tale();
function openModal(){
	var projectId = $("#projectId").val();
	if (projectId == '') {
		tale.alertWarn('请在设置项添加具体模块!!!!');
		return;
	}
	$('#modal').modal();
}		

