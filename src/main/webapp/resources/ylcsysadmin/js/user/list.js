/**
 * 
 */
$(function(){
	var getUserListUrl='/ylcsys/userinfoadmin/getuserinfolist';
	$.ajaxSetup({async:false});
	var userinfoObj={};
	var viewHTMLarray=new Array();
	$.getJSON(getUserListUrl,function(item,data){
		var viewHTML1='<div class="table-responsive"><table class="table"><thead><tr><th>ID</th><th>姓名</th><th>性别</th><th>手机号</th><th>学院</th><th>班级</th><th>操作</th></tr></thead><tbody>';
		var viewHTML2=' </tbody></table></div>';
		var tmpHTML='';
		userinfoObj=item.userInfoList;
		var iNum=0;
		var pageNP=0;
		var pageNM=userinfoObj.length;
		var pageNN=Math.ceil(pageNM/10);
		var tmpHTMLP='';
		var tmp2HTML='';
		//console.log('topage='+pageNN);
		for(var a=0;a<pageNN;a++){
			if(a==0){
				tmpHTMLP=tmpHTMLP+'&nbsp;&nbsp;&nbsp;&nbsp;<a id="toPage'+a+'" href="/ylcsys/user/list"><i  class="mdi mdi-numeric-'+(a+1)+'-box-multiple-outline"></i></a>';
			}else{
				tmpHTMLP=tmpHTMLP+'&nbsp;&nbsp;&nbsp;&nbsp;<a id="toPage'+a+'" href="javascript:void(0)"><i  class="mdi mdi-numeric-'+(a+1)+'-box-multiple-outline"></i></a>';
			}
			
		}
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
			tmp2HTML=tmp2HTML+'<tr><td>'+userId+
			'</td><td>'+userName+
			'</td><td>'+genderString+
			'</td><td>'+userPhone+
			'</td><td>'+userUnionName+
			'</td><td>'+userClassName+
			'</td><td>'+'<a onClick="viewOperation('+userId+',\''+userName+'\','+userGender+',\''+userIdCard+'\',\''+userPhone+'\',\''+userUnionName+'\',\''+userClassName+'\',\''+userPriority+'\',\''+userYouthOrgTime+'\',\''+userApplyPartyTime+'\',\''+userAdmitPartyTime+'\',\''+userPartyBranchId+'\',1)" href="javascript:void(0)">查看</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a onClick="viewOperation('+userId+',\''+userName+'\','+userGender+',\''+userIdCard+'\',\''+userPhone+'\',\''+userUnionName+'\',\''+userClassName+'\',\''+userPriority+'\',\''+userYouthOrgTime+'\',\''+userApplyPartyTime+'\',\''+userAdmitPartyTime+'\',\''+userPartyBranchId+'\',2)" href="javascript:void(0)">修改</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a onclick="return confirm(\'请确认删除\');" href="/ylcsys/userinfoadmin/deleteuserinfobyid?userId='+userId+'">删除</a>'+
			'</td></tr>';
			tmpHTML=tmpHTML+'<tr><td>'+userId+
			'</td><td>'+userName+
			'</td><td>'+genderString+
			'</td><td>'+userPhone+
			'</td><td>'+userUnionName+
			'</td><td>'+userClassName+
			'</td><td>'+'<a onClick="viewOperation('+userId+',\''+userName+'\','+userGender+',\''+userIdCard+'\',\''+userPhone+'\',\''+userUnionName+'\',\''+userClassName+'\',\''+userPriority+'\',\''+userYouthOrgTime+'\',\''+userApplyPartyTime+'\',\''+userAdmitPartyTime+'\',\''+userPartyBranchId+'\',1)" href="javascript:void(0)">查看</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a onClick="viewOperation('+userId+',\''+userName+'\','+userGender+',\''+userIdCard+'\',\''+userPhone+'\',\''+userUnionName+'\',\''+userClassName+'\',\''+userPriority+'\',\''+userYouthOrgTime+'\',\''+userApplyPartyTime+'\',\''+userAdmitPartyTime+'\',\''+userPartyBranchId+'\',2)" href="javascript:void(0)">修改</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a onclick="return confirm(\'请确认删除\');" href="/ylcsys/userinfoadmin/deleteuserinfobyid?userId='+userId+'">删除</a>'+
			'</td></tr>';
			iNum++;
			if((iNum%10)==0){
				viewHTMLarray[pageNP]=viewHTML1+tmp2HTML+viewHTML2+'<div col-md-5 col-8 align-self-center>'+tmpHTMLP+'</div>';
				//console.log('【】'+viewHTMLarray[pageNP]);
				tmp2HTML='';
				pageNP++;
			}else	if(iNum==pageNM){
				//console.log('------iNum='+iNum+'-----');
				viewHTMLarray[pageNP]=viewHTML1+tmp2HTML+viewHTML2+'<div col-md-5 col-8 align-self-center>'+tmpHTMLP+'</div>';
				//console.log('【】'+viewHTMLarray[pageNP]);
				tmp2HTML='';
				pageNP++;
			}
		});
		
		iNum=Math.ceil(iNum/10);
		
		
		$('#pview').html(viewHTMLarray[0]);
		//console.log('END====='+iNum+'END=====');
		for(var c=0;c<viewHTMLarray.length;c++){
			$('#toPage'+c).click(function(){
				//alert(c);
				//console.log(viewHTMLarray[b-1]);
				if(c>0){
					$('#pview').html(viewHTMLarray[c-1]);
				}
				
			});
		}
		
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
	function searchOperation(){
		var viewHTMLb1='<div class="table-responsive"><table class="table"><thead><tr><th>ID</th><th>姓名</th><th>性别</th><th>手机号</th><th>学院</th><th>班级</th><th>操作</th></tr></thead><tbody>';
		var viewHTMLb2=' </tbody></table></div>';
		var inputContent=$('#searchContent').val();
		if(inputContent!=''&&inputContent!=null){
			if(userinfoObj!=null){
				var tmpHTMLb='';
				userinfoObj.map(function(item,data){
					if(item.name.indexOf(inputContent)>-1){
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
						tmpHTMLb=tmpHTMLb+'<tr><td>'+userId+
						'</td><td>'+userName+
						'</td><td>'+genderString+
						'</td><td>'+userPhone+
						'</td><td>'+userUnionName+
						'</td><td>'+userClassName+
						'</td><td>'+'<a onClick="viewOperation('+userId+',\''+userName+'\','+userGender+',\''+userIdCard+'\',\''+userPhone+'\',\''+userUnionName+'\',\''+userClassName+'\',\''+userPriority+'\',\''+userYouthOrgTime+'\',\''+userApplyPartyTime+'\',\''+userAdmitPartyTime+'\',\''+userPartyBranchId+'\',1)" href="javascript:void(0)">查看</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a onClick="viewOperation('+userId+',\''+userName+'\','+userGender+',\''+userIdCard+'\',\''+userPhone+'\',\''+userUnionName+'\',\''+userClassName+'\',\''+userPriority+'\',\''+userYouthOrgTime+'\',\''+userApplyPartyTime+'\',\''+userAdmitPartyTime+'\',\''+userPartyBranchId+'\',2)" href="javascript:void(0)">修改</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a onclick="return confirm(\'请确认删除\');" href="/ylcsys/userinfoadmin/deleteuserinfobyid?userId='+userId+'">删除</a>'+
						'</td></tr>';
					}
				});
				$('#pview').html(viewHTMLb1+tmpHTMLb+viewHTMLb2);
			}
		}else{
			self.location='/ylcsys/user/list';
		}
	}
	$('#searchContent').keyup(function(event){
		if(event.keyCode ==13){
			searchOperation();
		  }
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
						
						self.location='/ylcsys/user/list';
					}
					
				}
			});
		});
	}