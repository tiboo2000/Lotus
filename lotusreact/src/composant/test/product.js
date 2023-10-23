import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Container, Row, Card, Button, Modal, Form } from 'react-bootstrap';

const Product = () => {
  const [products, setProducts] = useState([]);
  const [newProduct, setNewProduct] = useState({ name: '', prix: 0 });
  const [deleteProductId, setDeleteProductId] = useState(null);
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    const getProducts = async () => {
      try {
        const response = await axios.get('https://virtserver.swaggerhub.com/tiboo2000/test/1.0.3/Product/');
        setProducts(response.data);
      } catch (error) {
        console.error('Erreur lors de la récupération des produits :', error);
      }
    };

    getProducts();
  }, []);

  const addProduct = async () => {
    try {
      const response = await axios.post('https://virtserver.swaggerhub.com/tiboo2000/test/1.0.3/Product/', newProduct);
      setProducts([...products, response.data]);
      setNewProduct({ name: '', prix: 0 });
      setShowModal(false); // Fermer la fenêtre modale après l'ajout
    } catch (error) {
      console.error('Erreur lors de l\'ajout du produit :', error);
    }
  };

  const deleteProduct = async () => {
    try {
      if (deleteProductId !== null) {
        await axios.delete(`https://virtserver.swaggerhub.com/tiboo2000/test/1.0.3/Product/${deleteProductId}`);
        setProducts(products.filter((product) => product.id !== deleteProductId));
        setDeleteProductId(null);
      }
    } catch (error) {
      console.error('Erreur lors de la suppression du produit :', error);
    }
  };

  return (
    <Container>
      <h1 className="my-4">Liste des produits</h1>
      <Row>
        {products.map((product) => (
          <Card key={product.id} className="m-3" style={{ width: '18rem' }}>
            <Card.Body>
              <Card.Title>{product.name}</Card.Title>
              <Card.Text>Prix : {product.prix}</Card.Text>
              <Button variant="danger" onClick={() => setDeleteProductId(product.id)}>
                Supprimer
              </Button>
            </Card.Body>
          </Card>
        ))}
      </Row>

      <h2 className="my-4">Ajouter un produit</h2>
      <Button variant="primary" onClick={() => setShowModal(true)}>
        Ajouter un produit
      </Button>

      <Modal show={showModal} onHide={() => setShowModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>Ajouter un produit</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group>
              <Form.Label>Nom du produit</Form.Label>
              <Form.Control
                type="text"
                value={newProduct.name}
                onChange={(e) => setNewProduct({ ...newProduct, name: e.target.value })}
              />
            </Form.Group>
            <Form.Group>
              <Form.Label>Prix du produit</Form.Label>
              <Form.Control
                type="number"
                value={newProduct.prix}
                onChange={(e) => setNewProduct({ ...newProduct, prix: parseFloat(e.target.value) })}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>
            Annuler
          </Button>
          <Button variant="primary" onClick={addProduct}>
            Ajouter
          </Button>
        </Modal.Footer>
      </Modal>
    </Container>
  );
};

export default Product;