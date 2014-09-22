$(function() {
	var nodes = treeVar.jq.find('li.ui-treenode-selected .ui-c');
	$(nodes).each(function(){
		$(this).click();
		$(this).click();
	});
});