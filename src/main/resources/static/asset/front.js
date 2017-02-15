$().ready(function(){
  getAllComment();
})


function getAllComment(){
  $.ajax({
    type : "GET",
    url : "/comment",
    success : render,
    dataType : 'json',
    contentType: 'application/json'
  });

}

function postComment(){
  var comment = $('#comment').val();
  console.log(comment);
  $.ajax({
    type : "POST",
    url : "/comment",
    data : JSON.stringify({detail : comment}),
    success : render,
    dataType : 'json',
		contentType: 'application/json'

  });
  $('#comment').val('');
}


function render(data){
  $("#details").html("");
  for(var i=0;i<data.length;i++){
    $("#details").append("<div style = 'border:1px solid #000; padding:5px; margin:5px;'>"+
                          data[i].detail+
                          "</div>"
                          +"<div>Test</div>");
  }
}
