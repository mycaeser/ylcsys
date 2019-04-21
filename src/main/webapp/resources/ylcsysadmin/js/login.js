/**
 * 
 */
$(function(){
	$('#loginBtn').click(function(){
		var loginName=$('#loginName').val();
		var password=$('#password').val();
		var loginCheckUrl='/ylcsys/login/check';
		var j_captcha=$('#j_captcha').val();
		if(loginName==''||password==''||j_captcha==''){
			alert('请输入完整');
			return;
		}
		var formData = new FormData();
		//以用户信息对象的形式传入
		formData.append('loginName',loginName);
		formData.append('password',password);
		formData.append('verifyCodeActual',j_captcha);
		$.ajax({
			url : loginCheckUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if(data.success){
					alert('登陆成功');
					self.location='/ylcsys/front/index';
				}else{
					alert(data.errMsg);
				}
				
			}
		});
	})
	
})