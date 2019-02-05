window.addEventListener('load', getAllEvents);
	
	function getAllEvents(e){
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
						
						var name = document.createElement('li');
						eventList.appendChild(name);
						var event = events[i];
						name.textContent = (event.user.firstName+" "+event.user.lastName);
						
						var time = document.createElement('li');
						eventList.appendChild(time);
						time.textContent = ("Time: "+ event.time);
						
						var date = document.createElement('li');
						eventList.appendChild(date);
						date.textContent = ("Date: "+event.date);
						
						var cs = document.createElement('li');
						eventList.appendChild(cs);
						cs.textContent = ("Cognitive Status: "+event.cs.cognitiveStatus);
						
						
						if (event.coffee !== null){
							if( event.coffee.amount !== 0){
								var coffeeO = document.createElement('li');
								eventList.appendChild(coffeeO);
							coffeeO.textContent = "Amount: " + event.coffee.amount+"oz";
							}
						};
						

					}
				};
			}
			if (xhr.readyState === 4 && xhr.status >= 400) {
				return null;
			}
		};
		xhr.send();
		
		
		}
	