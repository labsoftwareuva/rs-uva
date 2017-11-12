'use strict';

// Define o módulo 'oportunidadeModule'
var app = angular.module('oportunidadeModule');

app.factory("demoFac", ['$http',function($http){  
    /*This is an example of how you can process and return the required result*/
       var obj = {};
       obj.getOverallUserInfo = function(){ 
           return $http.get('mockjson/userprofile.json').then(function(response){   //returns a call back
               this.userDetails = response.data;                                       //store data of 1st call in this.userDetails
               return $http.get('mockjson/userfriendlist.json').then(function(response){ //returns a call back
                   this.userDetails.friends = response.data.userfriends;               //Append the response of second call to the data we stored previously
                   return this.userDetails;                                    //Return processed result.
               });
           });
       }
    return obj;
   }]);