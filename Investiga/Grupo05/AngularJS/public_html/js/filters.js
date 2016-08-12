

angular.module('demoFilters', []).filter('oddeven', function () {
    return function(rows, row) {
        return rows.indexOf(row) % 2 == 1 ? 'even' : 'odd';
    };
});