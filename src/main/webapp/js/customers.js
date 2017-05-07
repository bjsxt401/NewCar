/**
 * Created by Administrator on 2017/5/2.
 */
function check(targetId,regex,resultTrue,resultFlase){
    var value = $("#"+targetId).val();
    var result = regex.test(value);
    var span = $("#"+targetId+"Span");
    if (result){

        span.attr("class","green");
        span[0].innerHTML=resultTrue;
    } else{
         span.attr("class","red");
         if(value==''){
             span[0].innerHTML="不可为空";
         } else{
             span[0].innerHTML=resultFlase;
         }

    }
    return result;
}
//检查证件号
function checkIdentity() {
      var regex = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
     var result = check("identity",regex,"证件号格式正确","证件号格式错误");
     //证件号格式正确 发起ajax请求 查询该证件号是否已注册
    if(result)  {
        var gender = $("#identity").val().substr(16,1);
        gender = parseInt(gender);
        var genderval = $("#gender");

        if(gender%2==0){
            genderval.val("女");
        }else{
            genderval.val("男");
        }
    }
    return result ;
}
 //检查名字
function checkCustName() {
      var regex = /^[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*$/;
    var result = check("custName",regex,"姓名格式正确","姓名格式错误");
    return result ;
}
//检查电话
function checkPhone() {
      var regex = /^(13[0-9]|15[0|1|3|6|7|8|9]|18[8|9])\d{8}$/;
    var result = check("phone",regex,"电话格式正确","电话格式错误");
    return result ;
}
//检查密码
function checkPassword() {
      var regex = /^[a-zA-Z]\w{5,9}$/;
      var result = check("password",regex,"密码格式正确","密码格式错误");
      return result ;
}