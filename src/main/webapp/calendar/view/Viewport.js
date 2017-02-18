/**
 * calendar page Viewport
 */
Ext.define('calendar.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires: [ 'calendar.view.Viewer' ],
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
