const path = require('path');
module.exports = {
  entry: './ppt.js',
    mode: "development",

  output: {
    path: path.resolve('./'),
    filename: './dist/bundle.js'
  },

  module: {
    rules: [{
      test: /\.js$/,
      use: 'babel-loader'
    }]
  },
devServer: {
    open: true, // Here
    openPage: './ppt.html' // And here
}
};