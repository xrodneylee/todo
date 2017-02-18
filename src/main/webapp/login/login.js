function verification(token, accessToken, email){
	Ext.Ajax.request({
	    url : '/todo/rest/v1/oauth2/verification/'+token+'/'+accessToken,
	    method : "GET",
	    success : function (response) {
	    	if(response.responseText == "true"){
	    		Ext.Msg.alert('','驗證成功');
	    		window.location.replace('/todo/calendar/calendar.jsp?email='+email);
	    	}else{
	    		Ext.Msg.alert('','驗證失敗');
	    	}
	    },
	    failure : function (response) {
	    	Ext.Msg.alert('','驗證失敗');
	    }
	});
}