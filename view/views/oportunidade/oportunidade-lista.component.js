'use strict';

// Registra o componente 'oportunidadeLista', atrelado ao seu modulo e juntamente com o controlador associado
var app = angular.module("oportunidadeLista", [])

app.component("oportunidadeLista", {
	templateUrl: 'views/oportunidade/_oportunidade-lista.html',
	styleUrls: ['views/oportunidade/oportunidade.style.css'],
	controller: function oportunidadeListaCtrl () {
		
		console.log("in controller...");
		this.novaOportunidade = {};
		this.info = "";
		
		this.oportunidades = [
			{
                id: 1,
                published_at: "2015-08-05T08:40:51.620Z",
                processo: 123456,
                areaAtuacao: 1, // Recursos Humanos
                cargo: "Gerencia de RH",
                descricao: 'Reportandando-se ao Gerente de RH, o candidato devera ter solidos conhecimentos em processos seletivos, treinamentos',
                requisitos: 'Ensino superior completo; experiencia na area de gestao de pessoas.',
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
			{
                id: 2,
                published_at: "2015-08-05T08:40:51.620Z",
                processo: 123456,
                areaAtuacao: 3, // Contabilidade
                cargo: 'Analista Contábil',
                descricao: 'Analista contábil com experiência em fechamento, obrigações fiscais como ECD, ECF, LALUR, SPED',
                requisitos: 'Ensino superior completo; experiência na área de gestão de pessoas.',
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
                salario: 1010.01
			},
			{
                id: 3,
                published_at: "2015-08-05T08:40:51.620Z",
                processo: 123456,
                areaAtuacao: 2, // Financeiro
                cargo: 'Analista Financeiro',
		    	descricao: 'Conhecimento em processos da área financeira, conciliação bancária, CNAB, borderô de pagamentos',
                requisitos: 'Ensino superior completo; experiência na área de gestão de pessoas.',
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
                salario: 1010.01
			},
			{
                id: 4,
                published_at: "2015-08-05T08:40:51.620Z",
                processo: 123456,
                areaAtuacao: 1, // Recursos Humanos
                cargo: 'Auxiliar Administrativo',
		    	descricao: 'Conhecimento em processos administrativos, processos bancários, pagamentos, recebimentos, emissão de notas fiscais',
                requisitos: 'Cursando Ensino superior.',
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
                salario: 1010.01
			},
			{
                id: 5,
                published_at: "2015-08-05T08:40:51.620Z",
                processo: 123456,
                areaAtuacao: 4, // Tecnologia da Informação
                cargo: 'Analista de Suporte',
		    	descricao: 'Prestará suporte aos usuários local e remoto, conhecimento em Windows Server 2008/2012, Ubuntu, Windows 7',
                requisitos: 'Ensino superior completo; experiência na área de gestão de pessoas.',
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
                salario: 1010.01
			},
		    {
                id: 6,
                published_at: "2015-08-05T08:40:51.620Z",
                processo: 123456,
                areaAtuacao: 4, // Tecnologia da Informação
                cargo: 'Analista de Suporte',
		    	descricao: 'Prestará suporte aos usuários local e remoto, conhecimento em Windows Server 2008/2012, Ubuntu, Windows 7',
                requisitos: 'Ensino superior completo; experiência na área de gestão de pessoas.',
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
                salario: 1010.01
			},
		];
		
		this.salvarOportunidade = function(){
			console.log("Saving..."); 
			this.oportunidades.push($scope.novaOportunidade);
			this.info = "Oportunidade cadastrada com sucesso!";
			this.novaOportunidade = {};
		};

		this.oportunidadeSelecionada = function(oportunidade){
			this.oportunidadeClicada = oportunidade;
		};

		this.removerOportunidade = function(){
			console.log($scope.oportunidades.indexOf($scope.clickedUser));
			this.oportunidades.splice($scope.oportunidades.indexOf($scope.oportunidadeClicada), 1);
			this.info = "User Deleted Successfully!";
		};

		this.limparInfo = function(){
			this.info = "";
		};
		
	}
});