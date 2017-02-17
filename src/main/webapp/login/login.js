function verification(token, accessToken){
	Ext.Ajax.request({
	    url : '/todo/rest/oauth2/verification/'+token+'/'+accessToken,
	    method : "GET",
	    success : function (response) {
	    	if(response.responseText == "true"){
	    		Ext.Msg.alert('','驗證成功');
	    	}else{
	    		Ext.Msg.alert('','驗證失敗');
	    	}
	    },
	    failure : function (response) {
	    	Ext.Msg.alert('','驗證失敗');
	    }
	});
}