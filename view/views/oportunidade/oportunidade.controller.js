var app = angular.module("oportunidade", []);

app.controller("oportunidadeCtrl", function($scope){
	console.log("in controller...");
	$scope.novaOportunidade = {};
	$scope.info = "";

	$scope.oportunidades = [
		{
			id: 1,
		    published_at: "2015-08-05T08:40:51.620Z",
		    processo: 123456,
		    areaAtuacao: 1,
		    cargo: "Gerência de RH",
		    descricao: "Reportandando-se ao Gerente de RH, o candidato deverá ter sólidos conhecimentos em processos seletivos, treinamentos",
		    requisitos: "Ensino superior completo; experiência na área de gestão de pessoas.",
		    beneficios: [
		        { valeTransporte: true },
		        { valeAlimentacao: true },
		        { valeRefeicao: false },
		        { comissaoDeVendas: false },
		        { auxilioCombustivel: false },
		        { auxilioMoradia: false },
		        { planoDeSaude: true }
		    ],
		    qtdVagas: 1,
		    dataInicial: "01/10/2017",
		    dataFinal: "01/11/2017",
		    salario: 1234.56
		},
	];

	$scope.salvarOportunidade = function(){
		console.log("Saving...");
		$scope.oportunidades.push($scope.novaOportunidade);
		$scope.info = "Oportunidade cadastrada com sucesso!";
		$scope.novaOportunidade = {};
	};

	$scope.oportunidadeSelecionada = function(oportunidade){
		$scope.oportunidadeClicada = oportunidade;
	};

	$scope.removerOportunidade = function(){
		console.log($scope.oportunidades.indexOf($scope.clickedUser));
		$scope.oportunidades.splice($scope.oportunidades.indexOf($scope.oportunidadeClicada), 1);
		$scope.info = "User Deleted Successfully!";
	};

	$scope.limparInfo = function(){
		$scope.info = "";
	};
});