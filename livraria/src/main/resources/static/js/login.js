function logar()
{

fetch("/LoginController",
		{
	
	
	method: "POST",
	headers: {
		"content-type": "application/JSON"
	},
	
	body: JSON.stringify(novo_login)
}. then(function (response)
{
	LocalStorage.setItem ("user", {"name": "Allyne"})
	
};



}