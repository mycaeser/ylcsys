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
			'</td><td>'+'<a href="javascript:;">缴费</a>'+
			'</td></tr>';
		});
		$('#pview').html(viewHTML1+tmpHTML+viewHTML2);
	});
})