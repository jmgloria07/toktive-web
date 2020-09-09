// do an AJAX call GET /toktive
// i'm not too motivated to use jquery here
function loadSocialNetworks() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			processNetworks(this.responseText);
		}
	};
	xhttp.open("GET", "/toktive", true);
	xhttp.send();
}

function processNetworks(resp) {
	let socialJson = JSON.parse(resp);
	for (let index in socialJson) {
		addCheckboxToDocument(socialJson[index]);
	}
}

function addCheckboxToDocument(network) {
	//TODO: clean this code up
	let template = document.createElement("template");
	let checkboxId = 'cb-' + network.value;
	htmlString = '<div><input type="checkbox" id="' + checkboxId + '" value="' +  network.value + '" name="networks"/><label for="' + checkboxId + '" class="radio">' + network.displayName + '</label></div>'
	template.innerHTML = htmlString.trim();
	
	let elem = template.content.firstChild;
	if (network.deprecated) {
		elem.className = 'strikethrough';
		document.getElementById('toktive-network-cbs').appendChild(elem);
		document.getElementById(checkboxId).disabled = true;
	} else {
		document.getElementById('toktive-network-cbs').appendChild(elem);
	}
}

window.onload = loadSocialNetworks;
//document.addEventListener('load', loadSocialNetworks);