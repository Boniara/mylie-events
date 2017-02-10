/**
 * Created by bogdan on 1/5/2017.
 */

'use strict';

var home_app = angular.module('homeApp', [ 'ngRoute', 'ngMaterial', 'ngAria', 'ngAnimate',  'ngMessages'])

.config(function($mdThemingProvider) {
    $mdThemingProvider.definePalette('mylie-pallet', {
        '50': '337ab7',
        '100': '337ab7',
        '200': '337ab7',
        '300': '337ab7',
        '400': '337ab7',
        '500': '337ab7',
        '600': '337ab7',
        '700': '337ab7',
        '800': '337ab7',
        '900': '337ab7',
        'A100': '337ab7',
        'A200': '337ab7',
        'A400': '337ab7',
        'A700': '337ab7',
        'contrastDefaultColor': 'light',    // whether, by default, text (contrast)
                                            // on this palette should be dark or light

        'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
            '200', '300', '400', 'A100'],
        'contrastLightColors': undefined    // could also specify this if default was 'dark'
    });
    $mdThemingProvider.theme('default')
        .primaryPalette('mylie-pallet')
        .accentPalette('mylie-pallet');
});