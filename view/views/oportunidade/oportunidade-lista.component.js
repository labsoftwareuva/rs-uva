'use strict';

console.log("Log: Componente 'Oportunidade Lista' carregado com sucesso.");

// Registra o componente 'oportunidadeLista', atrelado ao seu modulo e juntamente com o controlador associado
var app = angular.module("oportunidadeLista", [])

app.component("oportunidadeLista", {
	templateUrl: 'views/oportunidade/_oportunidade-lista.html',
	controller: function OportunidadeListaController () {
		this.oportunidades = [
			{
				cargo: 'Coordenador de RH',
		    	area: 'Gerência de RH',
		    	descricao: 'Reportandando-se ao Gerente de RH, o candidato deverá ter sólidos conhecimentos em processos seletivos, treinamentos',
		    	detalhes: 'mais',
		    	cidade: 'Rio de Janeiro',
		    	estado: 'RJ',
		    	criacao: '29/04/2017'
		    },
		    { 
		    	cargo: 'Analista Contábil',
		    	area: 'Gerência de Controladoria',
		    	descricao: 'Analista contábil com experiência em fechamento, obrigações fiscais como ECD, ECF, LALUR, SPED',
		    	detalhes: 'mais',
	    		cidade: 'São Paulo',
	    		estado: 'SP',
	    		criacao: '29/04/2017'
		    },
		    {
		    	cargo: 'Analista Financeiro',
		    	area: 'Gerência de Controladoria',
		    	descricao: 'Conhecimento em processos da área financeira, conciliação bancária, CNAB, borderô de pagamentos',
		    	detalhes: 'mais',
	    		cidade: 'São Paulo',
	    		estado: 'SP',
	    		criacao: '29/04/2017'
		    },
		    {
		    	cargo: 'Auxiliar Administrativo',
		    	area: 'Gerência Administrativa',
		    	descricao: 'Conhecimento em processos administrativos, processos bancários, pagamentos, recebimentos, emissão de notas fiscais',
		    	detalhes: 'mais',
	    		cidade: 'São Paulo',
	    		estado: 'SP',
	    		criacao: '29/04/2017'
		    },
		    {
		    	cargo: 'Analista de Suporte',
		    	area: 'Gerência de TI',
		    	descricao: 'Prestará suporte aos usuários local e remoto, conhecimento em Windows Server 2008/2012, Ubuntu, Windows 7',
		    	detalhes: 'mais',
	    		cidade: 'Belo Horizonte',
	    		estado: 'MG',
	    		criacao: '10/04/2017'
		    },
		    {
		    	cargo: 'Coordenador de Suprimentos',
		    	area: 'Gerência de Suprimentos',
		    	descricao: 'Reportando-se ao gerente de suprimentos, irá coordenar a equipe de suprimentos',
		    	detalhes: 'mais',
	    		cidade: 'Rio de Janeiro',
	    		estado: 'RJ',
	    		criacao: '07/04/2017'
		    }
		]
	}
});