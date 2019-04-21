/**
 * 
 */
$(function(){
	var getUserListUrl='/ylcsys/userinfoadmin/getuserinfolist';
	var getYouthOrgListUrl='/ylcsys/orgadmin/getyouthorglistall';
	$.ajaxSetup({async:false});
	var youthObj={};
	var userinfoObj={};
	var viewHTMLarray=new Array();
	$.getJSON(getYouthOrgListUrl,function(item,data){
		youthObj=item.youthOrgList;
	});
	$.getJSON(getUserListUrl,function(item,data){
		var viewHTML1='<div class="table-responsive"><table class="table"><thead><tr><th>ID</th><th>姓名</th><th>学院</th><th>班级</th><th>团组织名称</th><th>地址</th><th>操作</th></tr></thead><tbody>';
		var viewHTML2=' </tbody></table></div>';
		var tmpHTML='';
		userinfoObj=item.userInfoList;
		var iNum=0;
		var pageNP=0;
		var pageNM=userinfoObj.length;
		var pageNN=Math.ceil(pageNM/10);
		var tmpHTMLP='';
		var tmp2HTML='';
		for(var a=0;a<pageNN;a++){
			if(a==0){
				tmpHTMLP=tmpHTMLP+'&nbsp;&nbsp;&nbsp;&nbsp;<a id="toPage'+a+'" href="/ylcsys/org/youth"><i  class="mdi mdi-numeric-'+(a+1)+'-box-multiple-outline"></i></a>';
			}else{
				tmpHTMLP=tmpHTMLP+'&nbsp;&nbsp;&nbsp;&nbsp;<a id="toPage'+a+'" href="javascript:void(0)"><i  class="mdi mdi-numeric-'+(a+1)+'-box-multiple-outline"></i></a>';
			}
			
		}
		userinfoObj.map(function(item,data){
			var youthOrgA='';
			var youthOrgAContent='';
			var userId=item.id;
			var userName=item.name;
			var userGender=item.gender;
			var userIdCard=item.idCard;
			var userPhone=item.phone;
			var userUnionName=item.unionName;
			var userClassName=item.className;
			var addBtnALabel='<a id="addBtn'+userId+'" href="javascript:void(0)">填写</a>';
			var updateBtnALabel='<a   href="javascript:void(0)">修改</a>&nbsp;/&nbsp;<a onclick="return confirm(\'请确认删除\')" href="/ylcsys/orgadmin/deletebyuserid?userId='+userId+'">删除</a>';
			var orgNameValue='';
			var orgContentValue='';
			var inputEableStatus='';
			if(youthObj!=null){
				youthObj.map(function(item,data){
					if(userId==item.userId){
						orgNameValue=item.name;
						orgContentValue=item.content;
						inputEableStatus='disabled="true"';
						addBtnALabel='';
						updateBtnALabel='<a onclick="viewOperation('+userId+',\''+userName+'\',\''+orgNameValue+'\',\''+orgContentValue+'\')"  href="javascript:void(0)">修改</a>&nbsp;/&nbsp;<a onclick="return confirm(\'请确认删除\')" href="/ylcsys/orgadmin/deletebyuserid?userId='+userId+'">删除</a>';
					}
				})
			}
			if(addBtnALabel!=''){
				updateBtnALabel='';
			}
			tmp2HTML=tmp2HTML+'<tr><td>'+userId+
			'</td><td>'+userName+
			'</td><td>'+userUnionName+
			'</td><td>'+userClassName+
			'</td><td><input type="text" value="'+orgNameValue+'" id="youthOrgName'+userId+'" '+inputEableStatus+'>'+
			'</td><td><input type="text" value="'+orgContentValue+'" id="youthOrgContent'+userId+'" '+inputEableStatus+'>'+
			'</td><td>'+addBtnALabel+updateBtnALabel+
			'</td></tr>';
			tmpHTML=tmpHTML+'<tr><td>'+userId+
			'</td><td>'+userName+
			'</td><td>'+userUnionName+
			'</td><td>'+userClassName+
			'</td><td><input type="text" value="'+orgNameValue+'" id="youthOrgName'+userId+'" '+inputEableStatus+'>'+
			'</td><td><input type="text" value="'+orgContentValue+'" id="youthOrgContent'+userId+'" '+inputEableStatus+'>'+
			'</td><td>'+addBtnALabel+updateBtnALabel+
			'</td></tr>';
			iNum++;
			if((iNum%10)==0){
				viewHTMLarray[pageNP]=viewHTML1+tmp2HTML+viewHTML2+'<div col-md-5 col-8 align-self-center>'+tmpHTMLP+'</div>';

				tmp2HTML='';
				pageNP++;
			}else	if(iNum==pageNM){
				
				viewHTMLarray[pageNP]=viewHTML1+tmp2HTML+viewHTML2+'<div col-md-5 col-8 align-self-center>'+tmpHTMLP+'</div>';
				
				tmp2HTML='';
				pageNP++;
			}
		});
		$('#pview').html(viewHTMLarray[0]);
		userinfoObj.map(function(item,data){
			$('#addBtn'+item.id).click(function(){
				var addYouthUrl='/ylcsys/orgadmin/addyouth';
				var inputYouthName=$('#youthOrgName'+item.id).val();
				var inputYouthContent=$('#youthOrgContent'+item.id).val();
				if(inputYouthName==null||inputYouthName==''||inputYouthContent==null||inputYouthContent==''){
					alert('请输入完整');
					return;
				}
				var formData = new FormData();
				formData.append('inputYouthName',inputYouthName);
				formData.append('inputYouthContent',inputYouthContent);
				formData.append('id',item.id);
				//发送请求
				$.ajax({
					url : addYouthUrl,
					type : 'POST',
					data : formData,
					contentType : false,
					processData : false,
					cache : false,
					success : function(data) {
						if(data.success){
							alert('添加成功！');
							self.location='/ylcsys/org/youth';
						}
						
					}
				});
			});
		})
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
		var viewHTMLb1='<div class="table-responsive"><table class="table"><thead><tr><th>ID</th><th>姓名</th><th>学院</th><th>班级</th><th>团组织名称</th><th>地址</th><th>操作</th></tr></thead><tbody>';
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
						var addBtnALabel='<a id="addBtn'+userId+'" href="javascript:void(0)">填写</a>';
						var updateBtnALabel='<a   href="javascript:void(0)">修改</a>&nbsp;/&nbsp;<a onclick="return confirm(\'请确认删除\')" href="/ylcsys/orgadmin/deletebyuserid?userId='+userId+'">删除</a>';
						var orgNameValue='';
						var orgContentValue='';
						var inputEableStatus='';
						if(youthObj!=null){
							youthObj.map(function(item,data){
								if(userId==item.userId){
									orgNameValue=item.name;
									orgContentValue=item.content;
									inputEableStatus='disabled="true"';
									addBtnALabel='';
									updateBtnALabel='<a onclick="viewOperation('+userId+',\''+userName+'\',\''+orgNameValue+'\',\''+orgContentValue+'\')"  href="javascript:void(0)">修改</a>&nbsp;/&nbsp;<a onclick="return confirm(\'请确认删除\')" href="/ylcsys/orgadmin/deletebyuserid?userId='+userId+'">删除</a>';
								}
							})
						}
						if(addBtnALabel!=''){
							updateBtnALabel='';
						}
						tmpHTMLb=tmpHTMLb+'<tr><td>'+userId+
						'</td><td>'+userName+
						'</td><td>'+userUnionName+
						'</td><td>'+userClassName+
						'</td><td><input type="text" value="'+orgNameValue+'" id="youthOrgName'+userId+'" '+inputEableStatus+'>'+
						'</td><td><input type="text" value="'+orgContentValue+'" id="youthOrgContent'+userId+'" '+inputEableStatus+'>'+
						'</td><td>'+addBtnALabel+updateBtnALabel+
						'</td></tr>';
					}
				});
				$('#pview').html(viewHTMLb1+tmpHTMLb+viewHTMLb2);
			}
		}else{
			self.location='/ylcsys/org/youth';
		}
	}
	$('#searchContent').keyup(function(event){
		if(event.keyCode ==13){
			searchOperation();
		  }
	});
})
function viewOperation(userId,userName,youthOrgName,youthOrgContent){
		
		var viewHTMLa1='<div class="card-block">'+
        '<form class="form-horizontal form-material">'+
        ' <div class="form-group">'+
             '<label class="col-md-12">姓名</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="userName" value="'+userName+'" class="form-control form-control-line" disabled="true">'+
             '</div></div>'+
         '<div class="form-group">'+
             '<label for="example-email" class="col-md-12">团组织名称</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="orgName" value="'+youthOrgName+'"  class="form-control form-control-line"  >'+
             '</div></div>'+
         '<div class="form-group">'+
             '<label class="col-md-12">地址</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="orgContent" value="'+youthOrgContent+'" class="form-control form-control-line"  >'+
             '</div></div>'+
         '<div class="form-group">'+
             '<div class="col-sm-12">'+
                 '<button class="btn btn-success" id="submitBtn1" >提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                 '<a href="/ylcsys/org/youth" class="btn waves-effect waves-light btn-warning hidden-md-down"> 返回</a>'+
             '</div></div></form></div>';
		$('#payOpView').html(viewHTMLa1);
		$('#submitBtn1').click(function(){
			var updateYouthUrl='/ylcsys/orgadmin/updateyouthbyid';
			var orgNameI=$('#orgName').val();
			var orgContentI=$('#orgContent').val();
			if(orgNameI==''||orgContentI==''){
				alert('请填写完整');
				return;
			}
			var formData = new FormData();
			formData.append('orgName',orgNameI);
			formData.append('orgContent',orgContentI);
			formData.append('userId',userId);
			$.ajax({
				url : updateYouthUrl,
				type : 'POST',
				data : formData,
				contentType : false,
				processData : false,
				cache : false,
				success : function(data) {
					if(data.success){
						
						self.location='/ylcsys/org/youth';
					}
					
				}
			});
		});
	}