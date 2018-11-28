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

module.exports = {
  playlists,
  playlistsTypesFromWeater,
}
