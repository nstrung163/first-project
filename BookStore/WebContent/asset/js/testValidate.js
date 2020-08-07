function validate(){ 
/*	   var s = "Hello A "; 
	   if ( $('#bookId') =='' ) {
		   alert("BookId is required!");
	   } else {
		  	 alert(s); 				   
	 }*/
	var bookId	= document.getElementById("bookId");
	var name	= document.getElementById("name");
	var totalPage = document.getElementById("totalPage");
	var quantity  = document.getElementById("quantity");
	
	var bookIdValue	= document.getElementById("bookId").value;
	var nameValue	= document.getElementById("name").value;
	var totalPageValue	= document.getElementById("totalPage").value;
	var quantityValue 	= document.getElementById("quantity").value;
	
	var valid = true;
	if(bookId.value.length <= 0 || name.value.length <= 0 || totalPage.value.length <= 0 || quantity.value.length <= 0) {
		alert("BookID, Name, Total Page, Quantity is required");
		valid = false;
	} else {
		if(isNaN(totalPageValue) || isNaN(quantityValue)){
			alert("Enter a number");
			valid = false;
		}
	}
	return valid;
}