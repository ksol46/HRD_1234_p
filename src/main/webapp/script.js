function fn_submit(){
	var fn = document.frm;
	
	if(fn.custname.value ==""){
		alert("회원성명이 입력되지 않았습니다.");
		fn.custname.focus();
		return false;
	}
}