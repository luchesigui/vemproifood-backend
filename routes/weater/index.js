const fetch = require('node-fetch');

const openWeatherRootUrl = 'http://api.openweathermap.org/data/2.5/weather'
const openWeatherApiKey = 'b77e07f479efe92156376a8b07640ced'
const kelvinToCelcius = kelvin => Math.round(kelvin - 273.15)

const fetchWeater = (openWeatherApiUrl) => fetch( openWeatherApiUrl )
  .then( res => res.json() )
  .then( res => res.main.temp )
  .then( kelvinToCelcius )

module.exports = {
  openWeatherRootUrl,
  openWeatherApiKey,
  kelvinToCelcius,
  fetchWeater,
}
