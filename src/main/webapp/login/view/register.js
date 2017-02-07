/**
 * register window class - widget.registerWindow
 */
Ext.define('login.view.register', {
	extend : 'Ext.window.Window',
	
	alias: 'widget.registerWindow',
	
	requires: ['Ext.form.Panel'],
	
	width : 500,
	title : '註冊',
	modal : true,
	plain: true,
	
	defaultFocus: '#user',
	
	initComponent : function(){
		Ext.apply(this, {
			items: [{
			    xtype: 'form',
			    bodyPadding: '12 10 10',
			    border: false,
			    unstyled: true,
			    fieldDefaults: {
			        labelAlign: 'right',
			        labelWidth: 70,
			        msgTarget: 'side'
			    },
			    buttons : [{
					text : '註冊'
				}],
			    items: [{
			        xtype: 'fieldset',
			        title: '使用者資訊(必填)',
			        defaultType: 'textfield',
			        defaults: {
			            anchor: '100%'
			        },
			        items: [
			            { allowBlank:false, fieldLabel: '帳號', name: 'user', itemId : 'user' },
			            { allowBlank:false, fieldLabel: '密碼', name: 'pass', inputType: 'password' },
			            { allowBlank:false, fieldLabel: '密碼驗證', name: 'pass', inputType: 'password' }
			        ]
			    },
			    {
			        xtype: 'fieldset',
			        title: '聯絡資訊',
			        defaultType: 'textfield',
			        defaults: {
			            anchor: '100%'
			        },
			        items: [{
			            fieldLabel: '姓',
			            name: 'first'
			        },
			        {
			            fieldLabel: '名',
			            name: 'last'
			        },
			        {
			            fieldLabel: '電子郵件',
			            name: 'email',
			            vtype: 'email'
			        },
			        {
			            xtype: 'datefield',
			            fieldLabel: '生日',
			            name: 'dob',
			            maxValue: new Date()
			        }]
			    }]
			}]
		});
		
		this.callParent(arguments);
	}
});