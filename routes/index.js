const express = require('express');
const router = express.Router();

const {
  openWeatherRootUrl,
  openWeatherApiKey,
  fetchWeater,
} = require('./weater/index');

const {
  tracksFromWeater,
} = require('./spotify/index');

router.get('/city', async (req, res) => {
  const city = req.query.name

  if( !city ){
    res.status(500).send({
      error: 'Favor informar o nome da cidade desejada'
    })
  }

  const openWeatherApiUrl = `${openWeatherRootUrl}?q=${city}&appid=${openWeatherApiKey}`
  const temperatura = await fetchWeater( openWeatherApiUrl )
  const tracks = await tracksFromWeater( temperatura )

  res.send( tracks )
});

router.get('/coord', async (req, res) => {
  const { lat, lon } = req.query

  if( !lat || !lon ){
    res.status(500).send({
      error: 'Favor informar latitude e longitude'
    })
  }

  const openWeatherApiUrl = `${openWeatherRootUrl}?lat=${lat}&lon=${lon}&appid=${openWeatherApiKey}`
  const temperatura = await fetchWeater( openWeatherApiUrl )
  const tracks = await tracksFromWeater( temperatura )

  res.send( tracks )
});

module.exports = router;
