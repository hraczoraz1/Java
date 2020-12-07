
    var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: parseFloat(personLocation.lat), lng: parseFloat(personLocation.lng) },
        zoom: 15,
        scrollwheel: false
    });
	
	var personMarker = new google.maps.Marker({
            position: { lat: parseFloat(personLocation.lat), lng: parseFloat(personLocation.lng) },
            map: map,
			icon: "http://maps.google.com/mapfiles/kml/shapes/man.png"
        
        })

	
    for (i=0; i<busLocations.length; i++){
        var marker = new google.maps.Marker({
            position: { lat: parseFloat(busLocations[i].LATITUDE), lng: parseFloat(busLocations[i].LONGITUDE) },
            map: map,
			icon: "http://maps.google.com/mapfiles/kml/shapes/bus.png"
        
        })
        
        var infowindow = new google.maps.InfoWindow();
        infowindow.setContent(busLocations[i].VEHICLE);
      
        
 		//creates an infowindow 'key' in the marker.
		marker.infowindow = infowindow;

		//finally call the explicit infowindow object
		marker.addListener('click', function() {
		return this.infowindow.open(map, this);
		})

		// Alternate way of adding infowindow listeners
		google.maps.event.addListener(marker, 'click', function() {
	 	this.infowindow.open(map, this); 
		});

    }
}

