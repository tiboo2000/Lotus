import React,{useState,useEffect} from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Spinner from 'react-bootstrap/Spinner';
import Alert from 'react-bootstrap/Alert';

const Category = () => {
  const [data, setData] = useState(null);
  const [error, setError] = useState("");
  const [loaded, setLoaded] = useState(false);
  const axios = require('axios');
  let res = [];
  useEffect(() => {
    axios
      .get('https://virtserver.swaggerhub.com/KOUPTCHINSKYNG/test/1.0.1/category/0')
      .then((response) => setData(response.data))
      .catch((error) => setError(error.message))
      .finally(() => setLoaded(true));
  }, []);
  if(!loaded){
    return(<>
      <Button variant="primary" disabled>
          <Spinner
            as="span"
            animation="border"
            size="sm"
            role="status"
            aria-hidden="true"
          />
          <span className="visually-hidden">Loading...</span>
      </Button>{' '}
    </>)
  }
  else if(error!==""){
    return(<>
      <Alert variant="danger">
          <Alert.Heading>Erreur lors du chargement</Alert.Heading>
          <p>
            {error}
          </p>
      </Alert>
    </>)
  }
  else{
    console.log(data.id);
    return (
      <div className="Category">
        <Card style={{ width: '18rem' }}>
          <Card.Img variant="top" src="holder.js/100px180" />
          <Card.Body>
            <Card.Title>{data.name}</Card.Title>
            <Card.Text>
              ID={data.id}
            </Card.Text>
            <Button variant="primary">Go somewhere</Button>
          </Card.Body>
        </Card>
      </div>
    )
  }
}

export default Category