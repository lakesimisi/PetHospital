layui.use([ 'element', 'table', 'form', 'jquery' ], function() {
	var element = layui.element;
	var table = layui.table;
	var form = layui.form;
	var $ = layui.jquery;
	getCurUser();

	// 展示已知数据
	table.render({
		elem : '#regisTable',
		id : 'regisTable',
		url : '/PetHospital/servlet/RegistrationServlet',
		where : {
			type : 'queryAllRegistration',
			doctorId : curUserId,
			state : '预约成功'
		},
		request : {
			pageName : 'curr' // 页码的参数名称，默认：page
			,
			limitName : 'nums' // 每页数据量的参数名，默认：limit
		},
		method : 'post',
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		cols : [ [ // 标题栏
		{
			field : 'registrationCode',
			title : '编号',
			width : 80,
			sort : true
		}, {
			field : 'customerName',
			title : '主人姓名',
			width : 120
		}, {
			field : 'customerPhone',
			title : '手机号码',
			minWidth : 120
		}, {
			field : 'petName',
			title : '宠物姓名',
			minWidth : 80
		}, {
			field : 'category',
			title : '宠物类别',
			minWidth : 80
		}, {
			field : 'regisTime',
			title : '预约时间',
			width : 160
		}, {
			field : 'state',
			title : '状态',
			width : 100
		}, {
			field : 'operate',
			title : '操作',
			width : 180,
			align : 'center',
			toolbar : '#regisTool'
		} ] ], 
		skin : 'line' // 表格风格
		,
		page : true // 是否显示分页
		,
		limits : [ 5, 7, 10 ],
		limit : 5 // 每页默认显示的数量
		,
		response : {
			statusName : 'code' // 数据状态的字段名称，默认：code
			,
			statusCode : 0 // 成功的状态码，默认：0
			,
			msgName : 'msg' // 状态信息的字段名称，默认：msg
			,
			countName : 'count' // 数据总数的字段名称，默认：count
			,
			dataName : 'data' // 数据列表的字段名称，默认：data
		}
	});

	var active = {
		reload : function() {
			var selContent = $('#selContent').val();// 获取输入框的值
			var selItem = $("#select").val();
			// 执行重载
			table.reload('regisTable', {
				page : {
					curr : 1
				// 重新从第 1 页开始
				},
				where : {
					type : 'selectRegistration',
					doctorId : curUserId,
					selContent : selContent,
					selItem : selItem
				},// 这里传参 向后台
				url : '/PetHospital/servlet/RegistrationServlet',// 后台做模糊搜索接口路径
				method : 'post'
			});
		}
	};
	$('#selectRe').on('click', function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});
	table.on('tool(demo)', function(obj) {
		var data = obj.data;
		location.href = "prescribe.html?registrationCode="
				+ data.registrationCode;

	})

})
