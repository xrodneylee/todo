/**
 * login panel class - widget.viewer
 */
Ext.define('login.view.Viewer', {
	extend: 'Ext.form.Panel',
    alias: 'widget.viewer',
    
    title : '登入',
    frame : true,
    bodyPadding: 10,
    width : 300,
    
    defaultType: 'textfield',
    defaults: {
        anchor: '100%'
    },
    
    items : [ 
	    {
			name : "userid",
			fieldLabel : "帳號 ",
			allowBlank : false
		}, 
		{
			name : "password",
			inputType : "password",
			fieldLabel : "密碼 ",
			allowBlank : false
		} 
	],
	
    buttons: [{
    	text : '註冊',
        action: 'showRegisterWindow'
    }, {
        text: '登入',
        action : 'login',
        formBind : true
    }]

});