$(document).keyup(function(event){
	  if(event.keyCode ==13){
		  teclgSearch();
	  }
	});


$('.teclgSearch').change(function(event) {
	teclgSearch()
});
$('#order').change(function(event) {
	teclgSearch()
});
$(".faSearch").on("click", function(){
	teclgSearch();
})

/*$('.gl-item .auth-time').on('mouseenter', function(event) {
	alert(1111)
   $(this).find(".gl_hide").hide();
   $(this).find(".gl_show").show();
       event.preventDefault();
   });
       
  $('.gl-item .auth-time').on('mouseleave', function(event) {
	  alert(2222)
   	$(this).find(".gl_hide").show();
   	$(this).find(".gl_show").hide();
       event.preventDefault();
   });*/


    function t_mouseover(tag){
    	$(tag).find('.auth-time').hide();
    	$(tag).find('.auth-edit').show();
    }
    function t_mouseout(tag){
    	$(tag).find('.auth-time').show();
    	$(tag).find('.auth-edit').hide();
    }

function teclgSearch(){
	   var msg = $("input[name=msg]").val();
	   var projectId = $("#projectid").val();
	   var dataType = $("#order").val();
	   var sort = $(".teclgSearch").val();
	   $.post(
			   '/admin/view/teclg/search',
			   {"msg":msg, "projectId" : projectId, "sort" : sort, "dataType": dataType },
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
