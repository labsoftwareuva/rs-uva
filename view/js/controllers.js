// controller.js
angular.module("app").controller("CurriculoCtrl",function($scope, myResource){
  
  $scope.estados = [
    {nome: "Acre"               , uf: "AC"},
    {nome: "Alagoas"            , uf: "AL"},
    {nome: "Amapá"              , uf: "AP"},
    {nome: "Amazonas"           , uf: "AM"},
    {nome: "Bahia"              , uf: "BA"},
    {nome: "Ceará"              , uf: "CE"},
    {nome: "Distrito Federal"   , uf: "DF"},
    {nome: "Espirito Santo"     , uf: "ES"},
    {nome: "Goiás"              , uf: "GO"},
    {nome: "Maranhão"           , uf: "MA"},
    {nome: "Mato Grosso do Sul" , uf: "MS"},
    {nome: "Mato Grosso"        , uf: "MT"},
    {nome: "Minas Gerais"       , uf: "MG"},
    {nome: "Pará"               , uf: "PA"},
    {nome: "Paraíba"            , uf: "PB"},
    {nome: "Paraná"             , uf: "PR"},
    {nome: "Pernanbuco"         , uf: "PE"},
    {nome: "Piauí"              , uf: "PI"},
    {nome: "Rio de Janeiro"     , uf: "RJ"},
    {nome: "Rio Grande do Norte", uf: "RN"},
    {nome: "Rio Grande do Sul"  , uf: "RS"},
    {nome: "Rondônia"           , uf: "RO"},
    {nome: "Roraima"            , uf: "RR"},
    {nome: "Santa Catarina"     , uf: "SC"},
    {nome: "São Paula"          , uf: "SP"},
    {nome: "Sergipe"            , uf: "SE"},
    {nome: "Tocantins"          , uf: "TO"}
  ];

  $scope.niveisEscolaridade = [
    {codigo: "0", descricao: "Analfabeto"},
    {codigo: "1", descricao: "Ensino fundamental incompleto"},
    {codigo: "2", descricao: "Ensino fundamental completo"},
    {codigo: "3", descricao: "Ensino médio incompleto"},
    {codigo: "4", descricao: "Ensino médio completo"},
    {codigo: "5", descricao: "Ensino superior incompleto"},
    {codigo: "6", descricao: "Ensino superior completo"},
    {codigo: "7", descricao: "Pós graduação"},
    {codigo: "8", descricao: "Mestrado"},
    {codigo: "9", descricao: "Doutorado"},
    {codigo: "10", descricao: "Pós doutorado"}
  ];

  $scope.listaCursos = [];
  $scope.adicionarCurso = function(curso){
    $scope.listaCursos.push(angular.copy(curso));
    delete $scope.curso;
  }

  $scope.tipoCursos = [
    {codigo: "1", descricao: "Curso superior"},
    {codigo: "2", descricao: "Pós graduação"},
    {codigo: "3", descricao: "Mestrado"},
    {codigo: "4", descricao: "Doutorado"},
    {codigo: "5", descricao: "Formação complementar"}
  ];
  
  
  $scope.findCep = function () {
     myResource.get({'cep': $scope.cep}).$promise
     .then(function success(result){
        $scope.logradouro = result.logradouro;
        $scope.bairro     = result.bairro;
        $scope.localidade = result.localidade;
        $scope.uf         = result.uf;
     }).catch(function error(msg) {
       console.error('Error');
     });
  }

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