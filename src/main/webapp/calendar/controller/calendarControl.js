/**
 * 
 */
Ext.define('calendar.controller.calendarControl', {
	extend : 'Ext.app.Controller',

	init : function() {
		this.control({
			'viewer button[action=view]' : {
				click : this.onView
			},
			'viewer button[action=create]' : {
				click : this.onCreate
			}
		});
	},
	onView : function(){
		window.open('https://calendar.google.com');
	},
	onCreate : function(){
		var event = new Object();
		event.summary = Ext.getCmp('summary').getValue();
		event.description = Ext.getCmp('description').getValue();
		event.start = Ext.getCmp('start').getRawValue()+'T'+Ext.getCmp('in').getRawValue()+'+08:00';
		event.end = Ext.getCmp('end').getRawValue()+'T'+Ext.getCmp('out').getRawValue()+'+08:00';
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