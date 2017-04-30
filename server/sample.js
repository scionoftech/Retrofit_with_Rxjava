var express = require('express');
var app = express();
var http = require('http').createServer(app);


app.get('/hello_world', function(req, res){

var response={};
response.status="ok";
response.message="hello world";

   res.end(JSON.stringify(response));
});


http.listen(3000, function () {
    console.log('listening on *:3000');
});