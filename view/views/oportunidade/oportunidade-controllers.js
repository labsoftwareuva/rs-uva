'use strict'

var oportunidadeControllers = angular.module('rs.oportunidade.controllers', []);

// Listar
oportunidadeControllers.controller("OportunidadeController", ['$scope', '$http',
    function($scope, $http) {
        $http.get('/api/oportunidade').success(function(data) {  
        	$scope.oportunidade = data;
        });
    }
]);

// Deletar
oportunidadeControllers.controller("OportunidadeDeleteController", ['$scope', '$http', '$routeParams', '$location',
    function($scope, $http, $routeParams, $location) {  
        $scope.id = $routeParams.id;  
        $http.get('/api/oportunidade/' + $routeParams.id).success(function(data) {
            $scope.processo = data.processo;
            $scope.areaAtuacao = data.areaAtuacao;
            $scope.cargo = data.cargo;
            $scope.descricao = data.descricao;
            $scope.requisitos = data.requisitos;
            $scope.beneficios = data.beneficios;
            $scope.qtdVagas = data.qtdVagas;
            $scope.dataInicial = data.dataInicial;
            $scope.dataFinal = data.dataFinal;
            $scope.salario = data.salario;
        });  
        $scope.delete = function() {
            $http.delete('/api/oportunidade/' + $scope.id).success(function(data) {
                $location.path('/oportunidade');
            }).error(function(data) {
            	$scope.error = "Erro ao tentar excluir a oportunidade " + data;
        	});  
        };
    }
]);

// Add / Edit
oportunidadeControllers.controller("OportunidadeEditController", ['$scope', '$filter', '$http', '$routeParams', '$location',
    function($scope, $filter, $http, $routeParams, $location) {
        $scope.id = 0;  
        $scope.save = function() {
            var obj = {  
                id: $scope.id,
                processo: $scope.processo,
                areaAtuacao: $scope.areaAtuacao,
                cargo: $scope.cargo,
                descricao: $scope.descricao,
                requisitos: $scope.requisitos,
                beneficios: $scope.beneficios,
                qtdVagas: $scope.qtdVagas,
                dataInicial: $scope.dataInicial,
                dataFinal: $scope.dataFinal,
                salario: $scope.salario
            };
            if ($scope.id == 0) {
                $http.post('/api/oportunidade/', obj).success(function(data) {
                    $location.path('/oportunidade');
                }).error(function(data) {
                    $scope.error = "Erro ao tentar adicionar a oportunidade " + data.ExceptionMessage;
                });
            }
            else {
                $http.put('/api/oportunidade/', obj).success(function(data) {
                    $location.path('/oportunidade');
                }).error(function(data) {
                    console.log(data);
                    $scope.error = "Erro ao tentar adicionar a oportunidade " + data.ExceptionMessage;
                });
            }
        }
        if ($routeParams.id) {
            $scope.id = $routeParams.id;
            $scope.title = "Editar Oportunidade";
            $http.get('/api/oportunidade/' + $routeParams.id).success(function(data) {
                $scope.id = data.id;
                $scope.processo = data.processo;
                $scope.areaAtuacao = data.areaAtuacao;
                $scope.cargo = data.cargo;
                $scope.descricao = data.descricao;
                $scope.requisitos = data.requisitos;
                $scope.beneficios = data.beneficios;
                $scope.qtdVagas = data.qtdVagas;
                $scope.dataInicial = data.dataInicial;
                $scope.dataFinal = data.dataFinal;
                $scope.salario = data.salario;
            });
        }
        else {
            $scope.title = "Criar Oportunidade";
        }
    }  
]);