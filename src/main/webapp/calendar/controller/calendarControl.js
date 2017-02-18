/**
 * 
 */
Ext.define('calendar.controller.calendarControl', {
	extend : 'Ext.app.Controller',

	init : function() {
		this.control({
			'calendar button[action=create]' : {
				click : this.onCreate
			}
		});
	},
	onCreate : function(){
		alert();
//		Ext.Ajax.request({
//		    url : '/todo/rest/oauth2/userinfo',
//		    method : "GET",
//		    success : function (response) {
//		    	if(response.responseText == "infinitiessoft.com"){
//		    		Ext.Msg.alert('','驗證成功');
//		    	}else{
//		    		Ext.Msg.alert('','驗證失敗');
//		    	}
//		    },
//		    failure : function (response) {
//		    	Ext.Msg.alert('','驗證失敗');
//		    }
//		});
	}
});