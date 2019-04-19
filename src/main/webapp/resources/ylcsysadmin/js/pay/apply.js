/**
 * 
 */
$(function(){
	var getUserListUrl='/ylcsys/userinfoadmin/getuserinfolist';
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
			tmpHTML=tmpHTML+'<tr><td>'+userId+
			'</td><td>'+userName+
			'</td><td>'+genderString+
			'</td><td>'+userPhone+
			'</td><td>'+userUnionName+
			'</td><td>'+userClassName+
			'</td><td>'+'<a onClick="payOperation('+userId+',\''+userName+'\',\''+userUnionName+'\',\''+userClassName+'\')" href="javascript:void(0)">缴费</a>'+
			'</td></tr>';
		});
		$('#pview').html(viewHTML1+tmpHTML+viewHTML2);
	});
	
})
function payOperation(userId,userName,userUnionName,userClassName){
		
		var viewHTMLa1='<div class="card-block">'+
        '<form class="form-horizontal form-material">'+
        ' <div class="form-group">'+
             '<label class="col-md-12">姓名</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="userName" value="'+userName+'" class="form-control form-control-line" disabled="true" >'+
             '</div></div>'+
         '<div class="form-group">'+
             '<label for="example-email" class="col-md-12">学院</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="unionName" value="'+userUnionName+'"  class="form-control form-control-line" disabled="true" >'+
             '</div></div>'+
         '<div class="form-group">'+
             '<label class="col-md-12">班级</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" id="className" value="'+userClassName+'" class="form-control form-control-line"disabled="true" >'+
             '</div></div>'+
         '<div class="form-group">'+
             '<label class="col-md-12">缴费日期</label>'+
             '<div class="col-md-12">'+
                 '<input type="text" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" id="payMonth" class="form-control form-control-line">'+
             '</div></div>'+
             '<div class="form-group">'+
             '<label class="col-md-12">缴费金额</label>'+
             '<div class="col-md-12">'+
                 '<input type="text"  id="payValue" class="form-control form-control-line">'+
             '</div></div>'+
         '<div class="form-group">'+
             '<div class="col-sm-12">'+
                 '<button class="btn btn-success" id="submitBtn">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                 '<a href="/ylcsys/pay/index" class="btn waves-effect waves-light btn-warning hidden-md-down"> 返回</a>'+
             '</div></div></form></div>';
		$('#payOpView').html(viewHTMLa1);
		$('#submitBtn').click(function(){
			var addPayInfoUrl='/ylcsys/youthorgduesadmin/add';
			var duesValue=$('#payValue').val();
			var duesDate=$('#payMonth').val();
			if(duesValue==''||duesDate==''){
				alert('请输入完整');
				return;
			}
			var formData=new FormData();
			formData.append('duesValue',duesValue);
			formData.append('duesDate',duesDate);
			formData.append('userId',userId);
			$.ajax({
				url : addPayInfoUrl,
				type : 'POST',
				data : formData,
				contentType : false,
				processData : false,
				cache : false,
				success : function(data) {
					if(data.success){
						alert('缴费成功');
						self.location='/ylcsys/pay/index';
					}
					
				}
			});
		});
	}