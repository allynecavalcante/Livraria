function logar()
{
	
	let email = document.getElementById ('InputEmail').value;
	let senha = document.getElementById ('InputPassword').value;

fetch("/Login").then (function(response)
		{
	
	if (response.status >= 200 && response.status <= 300) {
		
		response.jason().then(function(data){
	     for (let i = 0; i< data.content.length ; i++){
	    	 let a = data.content[i];
	    	 
	    	 if(`${a.email}`== email && `${a.senha}` == senha){
	    		 localStorage.setItem("user", a.id);
	    		 
	    		 console.log(localStorange);
	    		 //alert ("usuario: " `${a.id}` + "-" + localStorage);
	    		 document.location = 'index.html';
	    	 }
	     }
		});
		
	}
	
}).catch(function (error){
	console.log(error);
	
});



}
function login()
{
	
	let email = document.getElementById ('InputEmail').value;
	let senha = document.getElementById ('InputPassword').value;
	
	let data = {
			
			"email"
	}
 
	fetch("/login", {
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(data)
		}).then(function(response){
			
			response.json().then(function(user){
//			console.log(user);
//			console.log(user.id);
			
			localStorage.setItem("user", user.id);
			
		console.log(localStorage);
		document.location= 'usuario.html';
			
		}).catch(function(error){
			console.log(error);
			
		});
			
}
		
}




