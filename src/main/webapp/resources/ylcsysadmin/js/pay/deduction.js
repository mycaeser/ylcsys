/**
 * 
 */
$(function(){
	var getDuesListUrl='/ylcsys/youthorgduesadmin/getlistall';
	$.getJSON(getDuesListUrl,function(item,data){
		var viewHTML1='<div class="table-responsive"><table class="table"><thead><tr><th>ID</th><th>姓名</th><th>金额</th><th>费用所属日期</th><th>提交日期</th><th>减免状态</th><th>操作</th></tr></thead><tbody>';
		var viewHTML2=' </tbody></table></div>';
		var tmpHTML='';
		var duesObj=item.youthOrgDuesList;
		duesObj.map(function(item,data){
			var duesId=item.id;
			var duesUserId=item.userId;
			var duesUserName=item.userNameString;
			var duesValue=item.duesValue;
			var duesDate=item.duesDate;//费用所属日期
			var duesCreateTime=item.createTime;//提交日期
			var duesIsDeduction=item.isDeduction;//是否减免
			var createdTime=new Date(duesCreateTime); 
			var y=createdTime.getFullYear(),m=createdTime.getMonth()+1,d=createdTime.getDate();
			var finalDate=y+'-'+(m<10?'0'+m:m)+'-'+(d<10?'0'+d:d);
			var duesStatusString='未减免';
			var opALabel='<a onclick="return confirm(\'请确认\');" href="/ylcsys/youthorgduesadmin/updateduestoabyid?id='+duesId+'">减免</a>&nbsp;&nbsp;/&nbsp;&nbsp;';
			if(duesIsDeduction==1){
				duesStatusString='已减免';
				opALabel='';
			}
			tmpHTML=tmpHTML+'<tr><td>'+duesId+
			'</td><td>'+duesUserName+
			'</td><td>'+duesValue+
			'</td><td>'+duesDate+
			'</td><td>'+finalDate+
			'</td><td>'+duesStatusString+
			'</td><td>'+opALabel+'<a onclick="return confirm(\'请确认删除\');"  href="/ylcsys/youthorgduesadmin/deletebyid?id='+duesId+'">删除</a>'+
			'</td></tr>';
		});
		$('#pview').html(viewHTML1+tmpHTML+viewHTML2);
	});
	
})