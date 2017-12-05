'use strict'

var oportunidadeControllers = angular.module('rs.oportunidade.controllers', []);

oportunidadeControllers.controller('OportunidadeController', function($scope, $state, popupService, $window, Oportunidade) {
	$scope.oportunidades=Oportunidade.query();

    $scope.deleteOportunidade=function(oportunidade){
        if(popupService.showPopup('Deseja realmente deletar esta oportunidade?')){
            movie.$delete(function(){
                $window.location.href='';
            });
        }
    }
})

.controller('OportunidadeViewController', function($scope, $stateParams, Oportunidade) {
	$scope.oportunidade=Oportunidade.get({id:$stateParams.id});
})

.controller('OportunidadeCreateController', function($scope, $stateParams, Oportunidade) {
	$scope.oportunidade=new Oportunidade();

    $scope.addOportunidade=function(){
        $scope.oportunidade.$save(function(){
            $state.go('oportunidade');
        });
    }	
})

.controller('OportunidadeEditController', function($scope, $stateParams, Oportunidade) {
	$scope.updateOportunidade=function(){
        $scope.oportunidade.$update(function(){
            $state.go('oportunidade');
        });
    };

    $scope.loadOportunidade=function(){
        $scope.oportunidade=Oportunidade.get({id:$stateParams.id});
    };

    $scope.loadOportunidade();
})