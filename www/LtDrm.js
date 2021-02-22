var exec = require('cordova/exec');

exports.start = function (success, error) {
    exec(success, error, 'LtDrm', 'start', []);
};

exports.stop = function (success, error) {
    exec(success, error, 'LtDrm', 'stop', []);
};
