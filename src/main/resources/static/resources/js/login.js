$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 输入框获取焦点后出现下划线
	$('.form-control').focus(function() {
		$(this).parent().addClass('fg-toggled');
	}).blur(function() {
		$(this).parent().removeClass('fg-toggled');
	});
});
Checkbix.init();
$(function() {;
	// 回车事件
	$('#username, #password').keypress(function (event) {
		if (13 == event.keyCode) {
			console.log("222")
		}
	});
});