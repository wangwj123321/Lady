$(document).ready(function(){
	$(".del").click(function(){
		var p=$(this);
		var id=$(this).attr("id");
		$.get("servlet/CollectServlet","opr=delCollect&id="+id,succ,"text");
		function succ(data){
			if(data=="true"){
				p.parent().remove();
			}else{
				
			}
		}
	});
});