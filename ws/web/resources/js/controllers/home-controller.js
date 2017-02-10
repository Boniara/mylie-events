/**
 * Created by bogdan on 1/8/2017.
 */

'use strict';

home_app.controller('HomeController', ['$scope', 'HomeService', '$mdDialog', function($scope, HomeService,  $mdDialog) {

    $scope.user = 'Bogdan Rutskov';

    $scope.events = [];

    function getHomePage() {
        HomeService.getHomePage()
            .then(
                function (data) {
                    console.log('Success to getting home page');
                },
                function (errorData) {
                    console.log('Error wile getting home page');
                }
            )
    }

    function getAllEvents(){
        HomeService.getAllEvents()
            .then(
                function(data) {
                    $scope.events = data;
                },
                function(errorData){
                    console.log('Error while fetching events');
                }
            );
    }

    function createEvent(event){
        HomeService.createEvent(event)
            .then(
                getAllEvents,
                function(errorData){
                    console.log('Error while creating event');
                }
            );
    }

    function updateEvent(event, id){
        HomeService.updateEvent(event, id)
            .then(
                getAllEvents,
                function(errorData){
                    console.log('Error while updating event');
                }
            );
    }

    function deleteEvent(id){
        HomeService.deleteEvent(id)
            .then(
                getAllEvents,
                function(errorData){
                    console.log('Error while deleting event');
                }
            );
    }

    $scope.imagePath = 'img/washedout.png';
    $scope.currentNavItem = 'events_page';

    $scope.getTab = function (tab) {
        return $scope.currentNavItem === tab;
    };

    $scope.likes = 0;

    $scope.addLike = function () {
        $scope.likes = $scope.likes + 1;
    };

    $scope.openImageModal = function(ev) {
        $mdDialog.show({
            controller: ImageController,
            templateUrl: 'resources/modals/image-modal.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: true
        })
            .then(function(answer) {

            }, function() {

            });
    };

    function ImageController($scope, $mdDialog) {
        $scope.hide = function() {
            $mdDialog.hide();
        };

        $scope.cancel = function() {
            $mdDialog.cancel();
        };

        $scope.answer = function(answer) {
            $mdDialog.hide(answer);
        };
    }

    (function init() {
        if($scope.currentNavItem == 'events_page')
            initEvent();
    })();

    function initEvent() {
        getAllEvents();
    }
}]);