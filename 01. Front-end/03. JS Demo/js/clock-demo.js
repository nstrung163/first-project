function runClock() {
	
	
	var currentTime = new Date();
	var hour = currentTime.getHours();
	var min = currentTime.getMinutes();
	var second = currentTime.getSeconds();
	
	document.getElementById("hour").innerHTML = checkTime(hour);
	document.getElementById("min").innerHTML = checkTime(min);
	document.getElementById("second").innerHTML = checkTime(second);
}
runClock();
var timer = setInterval(runClock, 500);

function checkTime(i) {
  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
  return i;
}