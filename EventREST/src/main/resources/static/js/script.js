window.addEventListener('load', getAllEvents);
var submitEvent = document.getElementsByName('submit')[0];
submitEvent.addEventListener('click', createEvent);
var deleteButton = document.getElementsByName('delete')[0];
deleteButton.addEventListener('click', deleteEvent);


function getAllEvents(e) {
	e.preventDefault();
	var xhr = new XMLHttpRequest();
	xhr.open('GET', "api/events/", true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			var events = JSON.parse(xhr.responseText);
			console.log(events);
			var eventList = document.createElement('ul');
			var dataDiv = document.getElementById('eventData');
			dataDiv.appendChild(eventList);

			if (events != null) {
				for (var i = 0; i < events.length; i++) {
					var eventList = document.createElement('ul');
					var dataDiv = document.getElementById('eventData');
					dataDiv.appendChild(eventList);
					var event = events[i];

					var time = document.createElement('li');
					eventList.appendChild(time);
					time.textContent = ("Time: " + event.time);

					var date = document.createElement('li');
					eventList.appendChild(date);
					date.textContent = ("Date: " + event.date);


					if (event.coffee !== null) {
						if (event.amount !== 0) {
							var coffeeO = document.createElement('li');
							eventList.appendChild(coffeeO);
							coffeeO.textContent = "Amount: "
									+ event.amount + "oz";
						}
					}
					;

				}
			}
			;
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			return null;
		}
	};
	xhr.send();
}
function deleteEvent(id){

	var ev = document.getElementById('deletedEvent');
	var eventId = document.deleteForm.eventId.value;
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', "api/event/"+id, true);
	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		  if (xhr.readyState === 4 ) {
		    if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
		      var data = JSON.parse(xhr.responseText);
		      console.log(data);
		      ev.textContent = "Film Deleted" + data;
		    }
		    else {
		      console.log("Delete request failed.");
		      console.error(xhr.status + ': ' + xhr.responseText);
		    }
		  }
		};

		var eventJson = JSON.stringify(eventId); // Convert JS object to JSON string

		xhr.send(eventJson);
		
};


function createEvent(e){
	e.preventDefault();
	var event={};
	var ev = document.getElementsByName('createEvent')[0];
	event.time = ev.time.value;
	event.date = ev.date.value;
	event.amount = ev.coffee.value;
	
	var xhr = new XMLHttpRequest();
	xhr.open('POST', "api/event", true);
	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		  if (xhr.readyState === 4 ) {
		    if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
		      var data = JSON.parse(xhr.responseText);
		      console.log(data);
		    }
		    else {
		      console.log("POST request failed.");
		      console.error(xhr.status + ': ' + xhr.responseText);
		    }
		  }
		};

		var eventJson = JSON.stringify(event); // Convert JS object to JSON string

		xhr.send(eventJson);
		console.log(eventJson);
};
