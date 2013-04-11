var resultado = {
		'formatList' : function (porras){
			var array = new Array();
			porras.forEach( function(porra) {
				array.push(porra.competicion);
				
				var vista = '<li>';
				
				vista = vista + "<h2>Competici&oacute;n: " + porra.competicion + "</h2></br></br>";
				
				porra.partidosRellenadosDTO.forEach( function (partido){
	 				vista = vista + partido.local + " vs " + partido.visitante + "</br>";
	 			});
				
				
				vista = vista + '</li>';
				
				$('#slider').append(vista)
				.anythingSlider({
					navigationFormatter: function(index, panel) {
				        return array[index-1];
				    }
				});
				
	 			
			});
		}
};