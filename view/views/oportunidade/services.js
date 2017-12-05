'use strict'

var oportunidadeServices = angular.module('rs.oportunidade.services', []);

oportunidadeServices.module('rs.oportunidade.services',[]).factory('Oportunidade',function($resource){
    return $resource('http://localhost:8080/rsuva/api/oportunidades/:id',{id:'@_id'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});