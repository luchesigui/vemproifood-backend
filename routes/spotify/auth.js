const { URLSearchParams } = require('url');
const fetch = require('node-fetch');

const apiKeys = {
  clientId: 'b52731ae8adc47c582bd7fb4ab81e960',
  clientSecret: 'e3869e0c323a4de098454be7ead76395',
}

const tokenHeader = {
  'Content-Type': 'application/x-www-form-urlencoded',
  'Authorization': `Basic ${Buffer.from(`${apiKeys.clientId}:${apiKeys.clientSecret}`).toString('base64')}`,
}

const bodyPayload = new URLSearchParams({
  'grant_type': 'client_credentials',
})

const getAuthenticatedHeader = (token) => ({
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded',
    'Authorization': `Bearer ${token}`,
  }
})

const spotifyAuthenticate = () => fetch(`https://accounts.spotify.com/api/token`, {
    method: 'POST',
    body: bodyPayload,
    headers: tokenHeader,
  })
  .then( res => res.json() )
  .then( res => res.access_token )
  .then( getAuthenticatedHeader )
  .catch( console.error )

module.exports = {
  spotifyAuthenticate
}
