var express = require('express');
var router = express.Router();
let request = require("request");
let apikey = "b77e07f479efe92156376a8b07640ced";


/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/tracks', function(req, res, next) {

  let lat = req.query.lat;
  let lon = req.query.lon;

  console.log(lat, lon);
  let url = `http://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apikey}`

  request(url, function(err, response, body){
    if (err){
      console.log(err);
    }else {
      res.send(body)
    }
  });

});

module.exports = router;
