/**
 * login page Viewport
 */
Ext.define('login.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires: [ 'login.view.Viewer' ],
    layout: {
        type: 'vbox',
        align: 'center',
        pack: 'center'
    },
    items: [
        {
            xtype: 'viewer'
        }
    ]
});
