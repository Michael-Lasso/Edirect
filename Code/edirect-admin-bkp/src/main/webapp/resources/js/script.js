$(document).on("ready", function() {
	$('#tab a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});
});

function checkLogin() {
	var email = $("input[id='form-login:Email']").val();
	var pass = $("input[id='form-login:Password']").val();
	if (email) {
		if (pass) {
			login(email, pass);
		} else {
			alert("password please");
		}
	} else {
		alert("Email please");
	}
}