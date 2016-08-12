
var context = null;

var DemoController = ["$scope", function($scope) {
    $scope.tempUser = new User();
    $scope.users = [];
    $scope.users.push(new User("admin", "admin123", "Administrator", "admin@gmail.com"));
    $scope.users.push(new User("jason", "jason123xx$s", "Jason Trueman", "jason@gmail.com"));
    $scope.users.push(new User("Jack", "jj@ck", "Jack.R.Bot", "jack.r.bot@imail.com"));

    $scope.addUser = function() {
        $scope.users.push($scope.tempUser);
        $scope.tempUser = new User();
    };

    var editingUser = null;
    $scope.editUser = function(user) {
        var index = $scope.users.indexOf(user);
        var $tr = $(".data tbody").children().eq(index);
        $tr.addClass("editing");
        editingUser = user.clone();
    };
    $scope.updateUser = function (user) {
        var index = $scope.users.indexOf(user);
        var $tr = $(".data tbody").children().eq(index);
        $tr.removeClass("editing");
    };
    $scope.cancelEdit = function (user) {
        var index = $scope.users.indexOf(user);
        var $tr = $(".data tbody").children().eq(index);
        $tr.removeClass("editing");
        user.updateFrom(editingUser);
    };
    $scope.deleteUser = function(user) {
        var index = $scope.users.indexOf(user);
        $scope.users.splice(index, 1);
    };
    context = $scope;
}];

var User = function(username, password, displayName, email) {
    this.username = username == undefined ? "" : username;
    this.password = password == undefined ? "" : password;
    this.displayName = displayName == undefined ? "" : displayName;
    this.email = email == undefined ? "" : email;
};

User.prototype.clone = function() {
    return new User(this.username, this.password, this.displayName, this.email);
};

User.prototype.updateFrom = function(user) {
    this.username = user.username;
    this.password = user.password;
    this.displayName = user.displayName;
    this.email = user.email;
};