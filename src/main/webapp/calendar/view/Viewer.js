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
			xtype : 'fieldset',
			layout : 'hbox',
			border : false,
			style: 'padding-left: 0px;',
			items : [
				{
				    xtype: 'datefield',
				    id : "start",
				    fieldLabel: '起',
				    name: 'start',
				    format: 'Y-m-d',
				    allowBlank : false
				},
				{
				    xtype : 'timefield',
				    id : 'in',
				    format : 'H:i:s',
				    minValue : '00:00',
		            maxValue : '23:59',
				    increment : 30,
				    width : 175,
				    allowBlank : false
				}
			],
		},
		{
			xtype : 'fieldset',
			layout : 'hbox',
			border : false,
			style : 'padding-left: 0px;',
			items : [
				{
		            xtype: 'datefield',
		            id : "end",
		            fieldLabel: '迄',
		            name: 'end',
		            format: 'Y-m-d',
		            allowBlank : false
		        },
		        {
		            xtype : 'timefield',
		            id : 'out',
		            format : 'H:i:s',
		            minValue : '00:00',
		            maxValue : '23:59',
		            increment : 30,
		            width : 175,
		            allowBlank : false
		        }
			],
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
        text: '檢視',
        action : 'view'
    },{
        text: '建立',
        action : 'create',
        formBind : true
    }]

});