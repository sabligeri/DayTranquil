/* eslint-disable @typescript-eslint/no-var-requires */
// eslint-disable-next-line no-undef
const  express = require('express') ;

// eslint-disable-next-line no-undef
const {createProxyMiddleware} = require('http-proxy-middleware')  ;

const app = express();

app.use('/api', createProxyMiddleware({
  target: 'http://app-notes:8080',
  changeOrigin: true
}));

// Handle SPA routes
app.get('*', (req, res) => {
  res.sendFile(path.resolve(__dirname, 'public', 'index.html'));
});

app.use(express.urlencoded({extended:true}));
app.use(express.json());
app.use(express.static('public'));

app.listen(9090, () => console.log("server is running on port 9090"));