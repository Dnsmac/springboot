

$(document).keyup(function(event){
	  if(event.keyCode ==13){
		  faMornSearch();
	  }
	});


$('#order').change(function(event) {
	faMornSearch()
});
$(".docSearch").on("click", function(){
	faMornSearch();
})


    $('.gl-item').on('mouseover', function(event) {
  	   $(this).find(".gl_hide").hide();
  	   $(this).find(".gl_show").show();
          event.preventDefault();
      });
      
      
      
      $('.gl-item').on('mouseout', function(event) {
      	$(this).find(".gl_hide").show();
      	$(this).find(".gl_show").hide();
          event.preventDefault();
      });


function faMornSearch(){
	   var msg = $("input[name=msg]").val();
	   var projectId = $("#projectid").val();
	   var dataType = $("#order").val();
	   $.post(
			   '/admin/view/morn/search',
			   {"msg":msg, "projectId" : projectId, "dataType" : dataType },
			   function(data){
				      $(".content").html(data);
			   })
	   $(".row gl-content").show();
}

function addEditView(seriesId, projectId){
	   $.get(
			   "/Editor/view/"+seriesId+"/"+projectId,
			   function(data){
				      $(".content").html(data);
			   })
}




function saveSeriesType(){
	var seriesName = $("#seriesName").val();
	var projectId = $("#projectid").val();
	var seriesImg = $("#seriesImg").val();
	if (seriesName == '') {
        tale.alertWarn('请输入名称');
        return;
    }
	var datad = {"name" : seriesName, "projectId" : projectId, "seriesImg" : seriesImg}
	 $.ajax({
		   url: "/save/series",
         type: "post",
         data :  JSON.stringify(datad),
         contentType : "application/json;charset=utf-8",
         dataType: "json",
         success: function (data) {
        	 $(".close").click();
         }
     });
		
	 
	 
}


//新增API模块
function saveProjectType(){
	var name = $("input[name=name]").val();
	if (name == '') {
        tale.alertWarn('请输入名称');
        return;
    }
	 $.ajax({
         url: "/save/projectTitle",
         type: "post",
         async: true,
         data : "name="+name,
         dataType: "json",
         success: function (data) {
        	 window.location.reload();
         }
     });
}

//新增模块
function saveCategoryType(){
	var categoryName = $("#categoryName").val();
	var categoryImg = $("#categoryImg").val();
	var categoryUrl = $("#categoryUrl").val();
	
	if (categoryName == '') {
        tale.alertWarn('请输入名称');
        return;
    }
	if (categoryUrl == '') {
		tale.alertWarn('请输入模块URL入口');
		return;
	}
	var datad = {"categoryName" : categoryName, "categoryImg" : categoryImg, "categoryUrl" : categoryUrl}
	 $.ajax({
         url: "/save/CategoryType",
         type: "post",
         data :  JSON.stringify(datad),
         contentType : "application/json;charset=utf-8",
         dataType: "json",
         success: function (data) {
        	 window.location.reload();
         }
     });
}