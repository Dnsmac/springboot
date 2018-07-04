/*<![CDATA[*/ 
var testEditor;
    $(function () {
        testEditor = editormd("test-editormd", {
            width: "95%",
            height: 750,
            syncScrolling: "single",
            path: "/static/editor/lib/",
            /**上传图片相关配置如下*/
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/upload/file",//注意你后端的上传图片服务地址
        });
    });
    
    
    var tale = new $.tale();
    function saveHtml(categoryType) {
    	var title = $("input[name=title]").val();
    	var url = $("input[name=url]").val();
    	var content = $("#text").text();
    	var cid = $("#cid").val();
    	var seriesId = $("#seriesId").val();
    	var projectId = $("#projectId").val();
    	var contentType = $(".addType").val();
    	 if (title == '') {
    	        tale.alertWarn('请输入文章标题');
    	        return;
    	    }
    	 if(categoryType == 'API'){
    		 if (url == '') {
     	        tale.alertWarn('请输入接口url');
     	        return;
     	    }
    	 }
    	 
   	    if (content == '') {
   	        tale.alertWarn('请输入文章内容');
   	        return;
   	    }
        var jsons = {
                "content": content,
                "seriesId": seriesId,
                "projectId": projectId,
                "cid": cid,
                "url": url,
                "contentType": contentType,
                "title": title
            }
               console.log(jsons);
        $.ajax({
            url: "/Editor/save",
            type: "post",
            async: true,
            data : JSON.stringify(jsons),
    		contentType : "application/json",
            dataType: "json",
            success: function (data) {
            	 tale.alertWarn('保存成功');
            	 setTimeout(function(){
            	        location.reload();
            	    },1000);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus); // paser error;
            }
        });
    }
    
    function backHtml(){
    	var projectId = $("#projectIdType").val();
    	window.location.href = "/admin/view/"+projectId;
    }
    
    function openModalCategory(){
    	$('#modalCategory').modal();
    }		
    
    $('.addIf').change(function(event) {
    	 $(".addType").find("option").show();
    	 var type = $(this).val();
    	 if(type == 'api'){
    		 $(".addType").find("option[type=1]").hide();
    		 $(".addType").find("option[type=2]").hide();
    	 }
    	 else if(type =='wd'){
    		 $(".addType").find("option[type=1]").hide();
     		 $(".addType").find("option[type=12]").hide();
    	 }else{
    		 $(".addType").find("option[type=2]").hide();
     		 $(".addType").find("option[type=12]").hide();
    	 }
    });
    
/*]]>*/