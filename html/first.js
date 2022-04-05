
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}








document.getElementsByClassName("contact")[0].addEventListener("click", function () {
  window.scrollTo(0, document.querySelector(".contactUs").offsetTop);
});


