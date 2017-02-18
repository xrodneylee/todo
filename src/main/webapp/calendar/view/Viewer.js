/**
 * calendar panel class - widget.viewer
 */
Ext.define('calendar.view.Viewer', {
	extend: 'Ext.form.Panel',
    alias: 'widget.viewer',
    
    title : '編輯活動',
    frame : true,
    bodyPadding: 10,
    width : 500,
    
    defaultType: 'textfield',
    defaults: {
        anchor: '100%'
    },
    
    items : [ 
	    {
	    	id : "summary",
			name : "summary",
			fieldLabel : "活動名稱 ",
			allowBlank : false
		},
        {
            xtype: 'datefield',
            id : "start",
            fieldLabel: '起',
            name: 'start',
            format: 'Y-m-d',
            allowBlank : false
        },
        {
            xtype: 'datefield',
            id : "end",
            fieldLabel: '迄',
            name: 'end',
            format: 'Y-m-d',
            allowBlank : false
        }, 
		{
			xtype     : 'textareafield',
			id : "description",
			name : "description",
			fieldLabel : "說明 ",
	        grow      : true,
			allowBlank : false
		} 
	],
	
    buttons: [{
        text: '建立',
        action : 'create',
        formBind : true
    }]

});