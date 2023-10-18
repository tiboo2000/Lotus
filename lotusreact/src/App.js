import logo from './logo.svg';
import './App.css';

function App() {
  const axios = require('axios');

  let config = {
    method: 'get',
    maxBodyLength: Infinity,
    url: 'https://virtserver.swaggerhub.com/KOUPTCHINSKYNG/test/1.0.1/category/0',
    headers: { }
  };

  axios.request(config)
  .then((response) => {
    console.log(JSON.stringify(response.data));
  })
  .catch((error) => {
    console.log(error);
  });
  
  return (
    <div className="App">
      
    </div>
  );
}

export default App;
