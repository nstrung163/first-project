function validate() {
	var bookId = document.getElementById("bookId");
	var name = document.getElementById("name");
	var totalPage = document.getElementById("totalPage");
	var quantity = document.getElementById("quantity");

	var bookIdValue = document.getElementById("bookId").value;
	var totalPageValue = document.getElementById("totalPage").value;
	var quantityValue = document.getElementById("quantity").value;

	var valid = true;
	if (bookId.value.length <= 0 || name.value.length <= 0 || totalPage.value.length <= 0 || quantity.value.length <= 0) {
		alert("Don't leave the field empty!");
		valid = false;
	} else {
		if (isNaN(totalPageValue) || isNaN(quantityValue) || isNaN(bookIdValue)) {
			alert("Enter BookID, Total page, Quantiy must a number");
			valid = false;
		}
	}
	if (totalPageValue < 10 ) {
		alert("Total page must be greater than 10!");
		valid = false;
	}
	if (quantityValue < 1 ) {
		alert("Quantity must be greater than 1!");
		valid = false;
	}
	return valid;
};