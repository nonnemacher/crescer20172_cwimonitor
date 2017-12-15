(function () {
    'use strict';

    angular.module('app')
        .directive('compareTo', compareTo);

    function compareTo() {
        return {
            require: 'ngModel',
            scope: {
                otherModelValue: '=compareTo'
            },
            link: function (scope, element, attributes, ngModel) {
                ngModel.$validators.compareTo = function(modelValue) {
                    if (!modelValue) return true;
                    return modelValue == scope.otherModelValue;
                };

                scope.$watch('otherModelValue', function() {
                    ngModel.$validate();
                });
            }
        };
    };
})();