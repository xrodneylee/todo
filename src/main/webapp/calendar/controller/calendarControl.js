/**
 * 
 */
Ext.define('calendar.controller.calendarControl', {
	extend : 'Ext.app.Controller',

	init : function() {
		this.control({
			'viewer button[action=create]' : {
				click : this.onCreate
			}
		});
	},
	onCreate : function(){
		var event = new Object();
		event.summary = Ext.getCmp('summary').getValue();
		event.description = Ext.getCmp('description').getValue();
		event.start = Ext.getCmp('start').getRawValue();
		event.end = Ext.getCmp('end').getRawValue();
		event.email = email;
		Ext.Ajax.request({
		    url : '/todo/rest/v1/oauth2/calendarInsert',
		    method : "POST",
		    params :{
		    	event : Ext.encode(event)
			},
		    success : function (response) {
		    	Ext.Msg.alert('','建立成功');
		    },
		    failure : function (response) {
		    	Ext.Msg.alert('','建立失敗');
		    }
		});
	}
});