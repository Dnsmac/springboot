package org.example.common;

@Data
public class JSONResult<T> {
    private Integer code;
    private String msg;
    private  T data;

     public static JSONResult ok(){
         JSONResult jsonResult = new JSONResult();
         jsonResult.setCode(200);
         return jsonResult;
     }



    public static JSONResult ok(Object obj){
        JSONResult jsonResult = new JSONResult();
        jsonResult.setCode(200);
        jsonResult.setData(obj);
        return jsonResult;
    }
}
