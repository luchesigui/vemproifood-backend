const fetch = require('node-fetch')

const { spotifyAuthenticate } = require('./auth')

const playlists = {
  'party': '37i9dQZF1DX8mBRYewE6or',
  'pop': '37i9dQZF1DWVLcZxJO5zyf',
  'rock': '37i9dQZF1DX1rVvRgjX59F',
  'classical': '37i9dQZF1DWWEJlAGA9gs0',
}

const playlistsTypesFromWeater = (weater) => {
  if (weater > 30) {
    return 'party'
  }

  if (weater >= 15) {
    return 'pop'
  }

  if (weater >= 10){
    return 'rock'
  }

  if (weater < 10){
    return 'classical'
  }

  return false
}

const tracksFromPlaylistType = async (playlistsType) => {
  const playlistId = playlists[playlistsType]

  if( !playlistId ) {
    return {
      error: 'Tipo de playlist invalido'
    }
  }

  const limit = 20
  const authenticatedHeader = await spotifyAuthenticate()
  const tracks = fetch(`https://api.spotify.com/v1/playlists/${playlistId}/tracks?limit=${limit}`, authenticatedHeader)
    .then( res => res.json () )
    .then( res => res.items )
    .then( trackObjects => trackObjects
        .map(trackObject => trackObject.track.name)
    )

  return tracks
}

module.exports = {
  playlists,
  playlistsTypesFromWeater,
  tracksFromPlaylistType,
}
