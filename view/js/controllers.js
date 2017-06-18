// controller.js
angular.module("app").controller("CurriculoCtrl",function($scope, myResource, $rootScope, $http){

  $scope.anosFormacao = [];
  for(ano = 2027; ano >= 1950; ano--){
      $scope.anosFormacao.push(ano);
  }

  // Formação Acadêmica
  $scope.listaCursos = [];
  $scope.adicionarCurso = function(curso){
    curso.indice = $scope.listaCursos.lenght;
    $scope.listaCursos.push(angular.copy(curso));
    delete $scope.curso;
  }

  $scope.removerCursos = function(){

    $scope.listaCursos = $scope.listaCursos.filter(function (curso){
      if(! curso.selecionado) return curso;
    });
  }

  $scope.go = function ( path ) {
    location.href = path;
  }

  // formacaoComplementar

  $scope.listaCursosCompl = [];
  $scope.adicionarCursoCompl = function(curso){
    curso.indice = $scope.listaCursosCompl.lenght;
    $scope.listaCursosCompl.push(angular.copy(curso));
    delete $scope.curso;
  }

  $scope.removerCursosCompl = function(){

    $scope.listaCursosCompl = $scope.listaCursosCompl.filter(function (curso){
      if(! curso.selecionado) return curso;
    });
  }

  // Experiencia profissional

  $scope.listaExperiencia = [];
  $scope.adicionarExperiencia = function(experiencia){
    experiencia.indice = $scope.listaExperiencia.lenght;
    $scope.listaExperiencia.push(angular.copy(experiencia));
    delete $scope.experiencia;
  }

  $scope.removerExperiencia = function(){

    $scope.listaExperiencia = $scope.listaExperiencia.filter(function (experiencia){
      if(! experiencia.selecionado) return experiencia;
    });
  }

  // Tratamentos para variáveis de sessão
  $scope.session_curriculo_dados_gerais = $rootScope.global_curriculo_dados_gerais;
  $scope.session_curriculo_formacao_academica = $rootScope.global_curriculo_formacao_academica;
  $scope.session_curriculo_formacao_complementar = $rootScope.global_curriculo_formacao_complementar;
  $scope.session_curriculo_experiencia_profissional = $rootScope.global_curriculo_experiencia_profissional;

  $scope.session = function( pagina, form ){
    if(pagina == 1)
      $rootScope.global_curriculo_dados_gerais = form;
    else if (pagina == 2) {
      $rootScope.global_curriculo_formacao_academica = form;
    }else if (pagina == 3) {
      $rootScope.global_curriculo_formacao_complementar = form;
    }else if (pagina == 4) {
      $rootScope.global_curriculo_experiencia_profissional = form;
      $scope.session_curriculo_experiencia_profissional = form;
    }
  }

  $scope.geraJsonCandidato = function(){

    // Cria objeto base
    var candidato = {
      experienciasProfissionais: [],
      formacoes: [],
      formacoesComplementares: [],
      processosSeletivos: [],
      perfil: {},
      usuario: {},
      cpf: '',
      endereco: '',
      numero: 0,
      complemento: '',
      cep: '',
      estado: '',
      cidade: '',
      dataNascimento: '',
      rg: '',
      emissor: '',
      expedicao: '',
      sexo: '',
      telefone: 0,
      celular: 0,
      uf: ''
    };

    // Popula objeto com dados armazenados dos formulários.
    // Experiencia profissional
    for(i = 0; i < $scope.session_curriculo_experiencia_profissional.length; i++){

        candidato.experienciasProfissionais.push({
            empresa: $scope.session_curriculo_experiencia_profissional[i].empresa,
            pais: $scope.session_curriculo_experiencia_profissional[i].pais,
            estado: $scope.session_curriculo_experiencia_profissional[i].estado,
            tituloCargo: $scope.session_curriculo_experiencia_profissional[i].cargo,
            setor: $scope.session_curriculo_experiencia_profissional[i].setor,
            atualidade: $scope.session_curriculo_experiencia_profissional[i].atualidade,
            atividades: $scope.session_curriculo_experiencia_profissional[i].descricao,
            inicioPeriodo: $scope.convertDate($scope.session_curriculo_experiencia_profissional[i].periodo_de),
            fimPeriodo: $scope.convertDate($scope.session_curriculo_experiencia_profissional[i].periodo_ate)
        });
    }
    // Formação Academica
    for(i = 0; i < $scope.session_curriculo_formacao_academica.length; i++){

        candidato.formacoes.push({
            curso: $scope.session_curriculo_formacao_academica[i].nome,
            nivel: $scope.session_curriculo_formacao_academica[i].nivel,
            instituicao: $scope.session_curriculo_formacao_academica[i].instituicao,
            estadoAtual: $scope.session_curriculo_formacao_academica[i].situacao,
            outros: '',
            mesConclusao: $scope.session_curriculo_formacao_academica[i].mesConclusao,
            anoConclusao: $scope.session_curriculo_formacao_academica[i].conclusao,
            estado: $scope.session_curriculo_formacao_academica[i].estado,
            pais: $scope.session_curriculo_formacao_academica[i].pais
        });
    }
    // Formações Complementares
    for(i = 0; i < $scope.session_curriculo_formacao_complementar.length; i++){

        candidato.formacoesComplementares.push({
            instituicao: $scope.session_curriculo_formacao_complementar[i].instituicao,
            curso: $scope.session_curriculo_formacao_complementar[i].nome,
            tipoCurso: $scope.session_curriculo_formacao_complementar[i].tipo,
            pais: $scope.session_curriculo_formacao_complementar[i].pais,
            estado: $scope.session_curriculo_formacao_complementar[i].estado,
            duracao: $scope.session_curriculo_formacao_complementar[i].duracao,
            situacao: $scope.session_curriculo_formacao_complementar[i].situacao,
            mesConclusao: $scope.session_curriculo_formacao_complementar[i].mesConclusao,
            anoConclusao: $scope.session_curriculo_formacao_complementar[i].conclusao

        });
    }

    // Dados gerais

    candidato.usuario = {
      nome: $scope.session_curriculo_dados_gerais.nome,
      senha: $scope.session_curriculo_dados_gerais.senha,
      email: $scope.session_curriculo_dados_gerais.email
    };

    candidato.cpf = $scope.session_curriculo_dados_gerais.cpf;
    candidato.endereco = $scope.session_curriculo_dados_gerais.logradouro;
    candidato.numero = $scope.session_curriculo_dados_gerais.numero;
    candidato.complemento = $scope.session_curriculo_dados_gerais.complemento;
    candidato.cep = $scope.session_curriculo_dados_gerais.cep;
    candidato.estado = $scope.session_curriculo_dados_gerais.estado;
    candidato.cidade = $scope.session_curriculo_dados_gerais.localidade;
    candidato.dataNascimento = $scope.convertDate($scope.session_curriculo_dados_gerais.data_nascimento);
    candidato.rg = $scope.session_curriculo_dados_gerais.rg;
    candidato.emissor = $scope.session_curriculo_dados_gerais.rg_emissor;
    candidato.expedicao = $scope.convertDate($scope.session_curriculo_dados_gerais.rg_emissao);
    candidato.sexo = $scope.session_curriculo_dados_gerais.sexo;
    candidato.telefone = $scope.session_curriculo_dados_gerais.telefone;
    candidato.celular = $scope.session_curriculo_dados_gerais.celular;
    candidato.uf = $scope.session_curriculo_dados_gerais.uf;

    return candidato;

  }

  $scope.convertDate = function(dataString){

      var parts = [];
      var date;

      if(dataString){
        parts = dataString.split('/');
        date = new Date(parts[2],parts[1]-1,parts[0]);
      }else{
        date = new Date();
      }

      return date;
  }

  $scope.candidatoSubmitRest = function(){

      var candidato = $scope.geraJsonCandidato();
      //console.log(angular.toJson(candidato));

      $http.post('./rest/candidato/cadastrar', candidato).then(
        function(response) {
            console.log(response, 'res');
    		},
        function(error) {
  			    console.log(error, 'Erro ao conectar ao servico REST.');
  		});
  }

  $scope.estados = ["Acre", "Alagoas", "Amazonas", "Amapa", "Bahia", "Ceara", "Distrito Federal", "Espirito Santo", "Goias", "Maranhao",
                    "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Para", "Paraiba", "Parana", "Pernambuco", "Piaui", "Rio de Janeiro",
                    "Rio Grande do Norte", "Rondonia", "Rio Grande do Sul", "Roraima", "Santa Catarina", "Sergipe", "Sao Paulo", "Tocantins"];

  $scope.paises = ['Afeganistao','Africa do Sul','Albania','Alemanha','Andorra','Angola','Antiga e Barbuda','Arabia Saudita',
                   'Argelia','Argentina','Armenia','Australia','Austria','Azerbaijao','Bahamas','Bangladexe','Barbados','Barem',
                   'Belgica','Belize','Benim','Bielorrussia','Bolivia','Bosnia e Herzegovina','Botsuana','Brasil','Brunei','Bulgaria',
                   'Burquina Faso','Burundi','Butao','Cabo Verde','Camaroes','Camboja','Canada','Catar','Cazaquistao','Chade','Chile',
                   'China','Chipre','Colombia','Comores','Congo-Brazzaville','Coreia do Norte','Coreia do Sul','Cosovo','Costa do Marfim',
                   'Costa Rica','Croacia','Cuaite','Cuba','Dinamarca','Dominica','Egito','Emirados arabes Unidos','Equador','Eritreia',
                   'Eslovaquia','Eslovenia','Espanha','Estado da Palestina','Estados Unidos','Estonia','Etiopia','Fiji','Filipinas',
                   'Finlandia','Franca','Gabao','Gambia','Gana','Georgia','Granada','Grecia','Guatemala','Guiana','Guine','Guine Equatorial',
                   'Guine-Bissau','Haiti','Honduras','Hungria','Iemen','Ilhas Marechal','Índia','Indonesia','Irao','Iraque','Irlanda',
                   'Islandia','Israel','Italia','Jamaica','Japao','Jibuti','Jordania','Laus','Lesoto','Letonia','Libano','Liberia','Libia',
                   'Listenstaine','Lituania','Luxemburgo','Macedonia','Madagascar','Malasia','Malaui','Maldivas','Mali','Malta','Marrocos',
                   'Mauricia','Mauritania','Mexico','Mianmar','Micronesia','Mocambique','Moldavia','Monaco','Mongolia','Montenegro','Namibia',
                   'Nauru','Nepal','Nicaragua','Niger','Nigeria','Noruega','Nova Zelandia','Oma','Paises Baixos','Palau','Panama','Papua Nova Guine',
                   'Paquistao','Paraguai','Peru','Polonia','Portugal','Quenia','Quirguistao','Quiribati','Reino Unido','Republica Centro-Africana',
                   'Republica Checa','Republica Democratica do Congo','Republica Dominicana','Romenia','Ruanda','Russia','Salomao','Salvador',
                   'Samoa','Santa Lucia','Sao Cristovao e Neves','Sao Marinho','Sao Tome e Principe','Sao Vicente e Granadinas','Seicheles',
                   'Senegal','Serra Leoa','Servia','Singapura','Siria','Somalia','Sri Lanca','Suazilandia','Sudao','Sudao do Sul','Suecia',
                   'Suica','Suriname','Tailandia','Taiua','Tajiquistao','Tanzania','Timor-Leste','Togo','Tonga','Trindade e Tobago','Tunisia',
                   'Turcomenistao','Turquia','Tuvalu','Ucrania','Uganda','Uruguai','Usbequistao','Vanuatu','Vaticano','Venezuela','Vietname',
                   'Zambia','Zimbabue'];

  $scope.findCep = function () {
     myResource.get({'cep': $scope.dados_gerais.cep}).$promise
     .then(function success(result){
        $scope.dados_gerais.logradouro = result.logradouro;
        $scope.dados_gerais.bairro     = result.bairro;
        $scope.dados_gerais.localidade = result.localidade;
        $scope.dados_gerais.uf         = result.uf;
     }).catch(function error(msg) {
       console.error('Error');
     });
  };

})
.factory('myResource', function ($resource) {
    var rest = $resource(
        'https://viacep.com.br/ws/:cep/json/',
        {
           'cep': ''
        }
    );
    return rest;
});
