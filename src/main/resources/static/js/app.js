(function () {
    'use strict';

    function string2json(str) {
        return eval("(" + str + ")");
    }

    function callSync(method, url, defaultValue) {
        var request = new XMLHttpRequest();
        request.open(method, url, false);
        request.send(null);

        if (request.status === 200) {
            return request.response;
        }
        return defaultValue;
    }

    var app = angular.module('example', ['nvd3', 'angularGrid']);

    app.constant('HttpConfig', {
        url: "http://localhost:9880/",
        weatherUrl: "http://api.openweathermap.org/data/2.5/weather"
    });

    app.controller('WeatherController', function ($scope, $http, HttpConfig) {
        // Search field
        $scope.cityName = "";

        $scope.cityIds = []; // Array[Long]
        $scope.citiesData = {}; // Map[id , Array[WeatherData]]
        function refreshCities() {
            $scope.citiesData = {}; // Map[id , Array[WeatherData]]
            $http.get('weather/cityIds').then(function (res) {
                console.log(res.data);
                $scope.cityIds = res.data;

                for(var i=0 ; i < $scope.cityIds.length ; i++) {
                    var id = $scope.cityIds[i];
                    $http.get('weather/cities/'+id).success(function(res /*List[WeatherData]*/){
                        for(var j=0 ; j < res.length ; j++) {
                            var cityDatas = $scope.citiesData[res[j].id];
                            if(cityDatas == undefined) {
                                cityDatas = [];
                                $scope.citiesData[res[j].id] = cityDatas;
                            }
                            console.log(res[j]);
                            cityDatas.push(res[j]);
                        }
                    });
                }

            });
        }


        $scope.fetchWeather = function (cityName) {
            if(cityName == null || cityName.length == 0) {
                refreshCities();
                return;
            }

            $http.get(HttpConfig.weatherUrl + "?q=" + cityName).success(function (res) {
                console.log("storing data:" + res);
                $http.post("weather/store", res).success(function () {
                    refreshCities();
                });
                $scope.cityName = "";
            });
        };
    });

})();