/**
 * Created by bogdan on 1/6/2017.
 */

var HOME_URL = 'http://localhost:8081/home';
var EVENT_URL = 'http://localhost:8081/events/all';

home_app.factory('HomeService', ['$http', '$q', function ($http, $q) {

    var factory = {
        createEvent: createEvent,
        getAllEvents: getAllEvents,
        updateEvent: updateEvent,
        deleteEvent: deleteEvent
    };

    return factory;

    function getHomePage() {
        $http.get(HOME_URL).then(function (responseData) {
                deferred.resolve(responseData.data);
            }, function (errorData) {
                console.log('Error get home page');
                deferred.reject(errorData);
            }
        );
        return deferred.promise;
    }

    function createEvent(event) {
        var deferred = $q.defer();
        $http.post(HOME_URL, event).then(function (responseData) {
                deferred.resolve(responseData.data);
            }, function (errorData) {
                console.log('Error creating event');
                deferred.reject(errorData);
            }
        );
        return deferred.promise;
    }

    function getAllEvents() {
        var deferred = $q.defer();
        $http.get(EVENT_URL).then(function (responseData) {
                deferred.resolve(responseData.data);
            }, function (errorData) {
                console.log('Error get all events');
                deferred.reject(errorData);
            }
        );
        return deferred.promise;
    }

    function updateEvent(event, id) {
        var deferred = $q.defer();
        $http.put(HOME_URL + id, event).then(function (responseData) {
                deferred.resolve(responseData.data);
            }, function (errorData) {
                console.log('Error updating event');
                deferred.reject(errorData);
            }
        );
        return deferred.promise;
    }

    function deleteEvent(id) {
        var deferred = $q.defer();
        $http.delete(HOME_URL + id).then(function (responseData) {
                deferred.resolve(responseData.data);
            }, function (errorData) {
                console.log('Error deleting event');
                deferred.reject(errorData);
            }
        );
        return deferred.promise;
    }

}]);
