/**
 * 
 */
Ext.define('login.controller.loginControl', {
	extend : 'Ext.app.Controller',

	views: ['register'],
	
	refs : [
        {
        	ref : 'registerWindow', 
        	selector : 'registerWindow',
        	autoCreate: true,
            xtype: 'registerWindow'
    	}
    ],
	
	init : function() {
		this.control({
			'viewer button[action=login]' : {
				click : this.onLogin
			},
			'viewer button[action=showRegisterWindow]' : {
				click : this.showRegisterWindow
			}
		});
	},
	onLogin : function(){
		Ext.Ajax.request({
		    url : '/todo/rest/oauth2/userinfo',
		    method : "GET",
		    success : function (response) {
		    	Ext.Msg.alert('','驗證成功');
		    },
		    failure : function (response) {
		    	Ext.Msg.alert('','驗證失敗');
		    }
		});
	},
	showRegisterWindow : function(){
		this.getRegisterWindow().show();
	}
});