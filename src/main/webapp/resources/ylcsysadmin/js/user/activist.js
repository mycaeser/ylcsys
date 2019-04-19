/**
 * 
 */
$(function(){
	var getUserListUrl='/ylcsys/userinfoadmin/getuserinfolist';
	var getActivistUrl='/ylcsys/activistadmin/getactivistlist';
	var activistObj={};
	$.ajaxSetup({async: false});
	$.getJSON(getActivistUrl,function(item,data){
		activistObj=item.partyActivistList;
		var viewHTMLa1='<div class="table-responsive"><table class="table"><thead><tr><th>ID</th><th>姓名</th><th>申请日期</th><th>审核状态</th><th>审核意见</th><th>操作</th></tr></thead><tbody>';
		var viewHTMLa2=' </tbody></table></div>';
		var tmpHTMLa='';
		activistObj.map(function(item,data){
			var actId=item.id;
			var actUserId=item.userId;
			var actUserName=item.userNameString;
			var actApplyDate=item.applyDate;
			var actIsChecked=item.isChecked;
			var actIsCheckedStatusString='未审核';
			var actIsCheckedOpinion='';
			var enableEdit='';
			var actALabel='<a id="applyAct'+actId+'" href="javascript:void(0)">审核通过</a>';
			if(actIsChecked==1){
				actIsCheckedOpinion=item.isCheckedOpinion;
				actIsCheckedStatusString='审核通过';
				enableEdit='disabled="true"';
				actALabel='';
			}
			tmpHTMLa=tmpHTMLa+'<tr><td>'+actId+
			'</td><td>'+actUserName+
			'</td><td>'+actApplyDate+
			'</td><td>'+actIsCheckedStatusString+
			'</td><td><input type="text" value="'+actIsCheckedOpinion+'" id="actOpinion'+actId+'" '+enableEdit+'>'+
			'</td><td>'+actALabel+
			'</td></tr>';
			
		});
		$('#secondTab').html(viewHTMLa1+tmpHTMLa+viewHTMLa2);
		activistObj.map(function(item,data){
			$('#applyAct'+item.id).click(function(){
				var updateActUrl='/ylcsys/activistadmin/updateactivistbyid';
				var inputActOpinion=$('#actOpinion'+item.id).val();
				if(inputActOpinion==null||inputActOpinion==''){
					alert('请输入审核意见');
					return;
				}
				var formData = new FormData();
				formData.append('isCheckedOpinion',inputActOpinion);
				formData.append('id',item.id);
				//发送请求
				$.ajax({
					url : updateActUrl,
					type : 'POST',
					data : formData,
					contentType : false,
					processData : false,
					cache : false,
					success : function(data) {
						if(data.success){
							alert('审核成功！');
							self.location='/ylcsys/activist/list';
						}
						
					}
				});
			});
		})
	});
	$.getJSON(getUserListUrl,function(item,data){
		var viewHTML1='<div class="table-responsive"><table class="table"><thead><tr><th>ID</th><th>姓名</th><th>性别</th><th>手机号</th><th>学院</th><th>班级</th><th>操作</th></tr></thead><tbody>';
		var viewHTML2=' </tbody></table></div>';
		var tmpHTML='';
		var userinfoObj=item.userInfoList;
		userinfoObj.map(function(item,data){
			var userId=item.id;
			var userName=item.name;
			var userGender=item.gender;
			var userIdCard=item.idCard;
			var userPhone=item.phone;
			var userUnionName=item.unionName;
			var userClassName=item.className;
			var userPriority=item.priority;
			var userYouthOrgTime=item.youthOrgTime;
			var userApplyPartyTime=item.applyPartyTime;
			var userAdmitPartyTime=item.admitPartyTime;
			var userPartyBranchId=item.partyBranchId;
			var genderString='男';
			if(userGender==1){
				genderString='男';
			}else if(userGender==0){
				genderString='女';
			}
			var ifActivistFlage=true;
			if(activistObj!=null){
				activistObj.map(function(item,data){
					if(userId==item.userId){
						ifActivistFlage=false;
					}
				})
			}
			if(ifActivistFlage){
				tmpHTML=tmpHTML+'<tr><td>'+userId+
				'</td><td>'+userName+
				'</td><td>'+genderString+
				'</td><td>'+userPhone+
				'</td><td>'+userUnionName+
				'</td><td>'+userClassName+
				'</td><td>'+'<a onclick="return confirm(\'请确认\')" href="/ylcsys/activistadmin/applyactivistbyid?userId='+userId+'">申请</a>'+
				'</td></tr>';
			}
		});
		$('#pview').html(viewHTML1+tmpHTML+viewHTML2);
	});
	$('#submitBtn').click(function(){
		var addUserInfoUrl='/ylcsys/userinfoadmin/adduserinfoobj';
		var genderI=$('input[name="sex"]:checked').val();
		var userNameI=$('#userName').val();
		var idCardI=$('#idCard').val();
		var phoneI=$('#phone').val();
		var unionNameI=$('#unionName').val();
		var classNameI=$('#className').val();
		if(userNameI==''||idCardI==''||phoneI==''||unionNameI==''||classNameI==''){
			alert('请填写完整');
			return;
		}
		var userInfoObj={};
		userInfoObj.name=userNameI;
		userInfoObj.gender=genderI;
		userInfoObj.idCard=idCardI;
		userInfoObj.phone=phoneI;
		userInfoObj.unionName=unionNameI;
		userInfoObj.className=classNameI;
		var formData = new FormData();
		//以用户信息对象的形式传入
		formData.append('userInfoStr',JSON.stringify(userInfoObj));
		//发送请求
		$.ajax({
			url : addUserInfoUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if(data.success){
					alert('添加成功！');
					self.location='/ylcsys/user/list';
				}
				
			}
		});
	});
})
function viewOperation(userId,userName,userGender,userIdCard,userPhone,userUnionName,userClassName,userPriority,userYouthOrgTime,userApplyPartyTime,userAdmitPartyTime,userPartyBranchId,opType){
		var viewHTMLb2='disabled="true"';
		var genderFlagA='checked';
		var genderFlagB='checked';
		if(userGender==0){
			genderFlagA='';
		}else if(userGender==1){
			genderFlagB='';
		}
		if(opType==2){
			viewHTMLb2='';
		}
		var viewHTMLa1='<div class="card-block">'+
        '<form class="form-horizontal form-material">'+
        ' <div class="form-group">'+
             '<label class="col-md-12">姓名</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="userName" value="'+userName+'" class="form-control form-control-line" '+viewHTMLb2+' >'+
             '</div></div>'+
				'<div class="form-group">'+
                '<div class="col-md-12">'+
                   '<div class="radio-box">'+
						'<input name="sex" type="radio" value="1" id="sex-1" '+genderFlagA+'>'+
						'<label for="sex-1">男</label>'+
						'<input type="radio" id="sex-2" value="0" name="sex" '+genderFlagB+'>'+
						'<label for="sex-2">女</label>'+
					'</div>'+
               ' </div></div>'+
         '<div class="form-group">'+
             '<label for="example-email" class="col-md-12">学院</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="unionName" value="'+userUnionName+'"  class="form-control form-control-line" '+viewHTMLb2+' >'+
             '</div></div>'+
         '<div class="form-group">'+
             '<label class="col-md-12">班级</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="className" value="'+userClassName+'" class="form-control form-control-line" '+viewHTMLb2+' >'+
             '</div></div>'+
             '<div class="form-group">'+
             '<label class="col-md-12">学号</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="idCard" value="'+userIdCard+'" class="form-control form-control-line" '+viewHTMLb2+' >'+
             '</div></div>'+
             '<div class="form-group">'+
             '<label class="col-md-12">手机号</label>'+
             '<div class="col-md-12">'+
                 '<input type="text"  id="phone" value="'+userPhone+'" class="form-control form-control-line" '+viewHTMLb2+'>'+
             '</div></div>'+
         '<div class="form-group">'+
             '<div class="col-sm-12">'+
                 '<button class="btn btn-success" id="submitBtn1" '+viewHTMLb2+'>提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                 '<a href="/ylcsys/user/list" class="btn waves-effect waves-light btn-warning hidden-md-down"> 返回</a>'+
             '</div></div></form></div>';
		$('#payOpView').html(viewHTMLa1);
		$('#submitBtn1').click(function(){
			var updateUserInfoUrl='/ylcsys/userinfoadmin/updateuserinfoobj';
			var genderI=$('input[name="sex"]:checked').val();
			var userNameI=$('#userName').val();
			var idCardI=$('#idCard').val();
			var phoneI=$('#phone').val();
			var unionNameI=$('#unionName').val();
			var classNameI=$('#className').val();
			if(userNameI==''||idCardI==''||phoneI==''||unionNameI==''||classNameI==''){
				alert('请填写完整');
				return;
			}
			var userInfoObj={};
			userInfoObj.id=userId;
			userInfoObj.name=userNameI;
			userInfoObj.gender=genderI;
			userInfoObj.idCard=idCardI;
			userInfoObj.phone=phoneI;
			userInfoObj.unionName=unionNameI;
			userInfoObj.className=classNameI;
			var formData = new FormData();
			//以用户信息对象的形式传入
			formData.append('userInfoStr',JSON.stringify(userInfoObj));
			$.ajax({
				url : updateUserInfoUrl,
				type : 'POST',
				data : formData,
				contentType : false,
				processData : false,
				cache : false,
				success : function(data) {
					if(data.success){
						
						self.location='/ylcsys/pay/index';
					}
					
				}
			});
		});
	}