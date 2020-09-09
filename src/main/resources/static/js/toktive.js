// do an AJAX call GET /toktive
// i'm not too motivated to use jquery here
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("demo").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "/toktive", true);
  xhttp.send();
}

function createCheckboxes(resp) {
	socialJson = JSON.parse(resp);
	//get social network
	//parse social network to checkbox values
	resp.ge
}

function setCheckboxesToDocument(){
	//set to document
}

// document ready