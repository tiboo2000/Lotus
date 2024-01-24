import React, { useState } from 'react';
import axios from 'axios'; // Importez Axios
import Bag from './bag';

const NavBar = ({ onAddProduct, onRemoveProduct, onGoToCart }) => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [newProduct, setNewProduct] = useState({
    id: '',
    name: '',
    price: '',
    categoryId: '',
  });

  const [cart, setCart] = useState(false);
  const handleAddProductClick = () => {
    setIsModalOpen(true);
  };

  const handleModalClose = () => {
    setIsModalOpen(false);
  };

  const handleShowcartClick = () => {
      setCart(!cart);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewProduct({ ...newProduct, [name]: value });
  };

  const handleAddProduct = () => {
    // Envoyer les informations du produit à votre API ici en utilisant Axios
    axios
      .post('http://localhost:9090/product', newProduct, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
        console.log('Produit ajouté avec succès:', response.data);
        handleModalClose();
      })
      .catch((error) => {
        console.error('Erreur lors de l\'ajout du produit:', error);
        handleModalClose();
      });
  };

  return (
    <nav className="navbar">
      <button onClick={handleAddProductClick} className="nav-btn">
        Ajouter Produit
      </button>
      <button onClick={handleShowcartClick} className="nav-btn nav-btn-cart">
        Panier
      </button>

      {isModalOpen && (
        <div className="modal">
          <div className="modal-content">
            <h3>Ajouter un Produit</h3>
            <div>
              {/* <label>ID du produit:</label>
              <input
                type="number"
                name="id"
                value={newProduct.id}
                onChange={handleInputChange}
              /> */}
            </div>
            <div>
              <label>Nom du produit:</label>
              <input
                type="text"
                name="name"
                value={newProduct.name}
                onChange={handleInputChange}
              />
            </div>
            <div>
              <label>Prix du produit:</label>
              <input
                type="number"
                name="price"
                value={newProduct.price}
                onChange={handleInputChange}
              />
            </div>
            <div>
              <label>Catégorie du produit:</label>
              <input
                type="text"
                name="categoryId"
                value={newProduct.categoryId}
                onChange={handleInputChange}
              />
            </div>
            <button onClick={handleModalClose}>Annuler</button>
            <button onClick={handleAddProduct}>Confirmer</button>
          </div>
        </div>
      )}
      {cart && <Bag/>}
    </nav>
  );
};

export default NavBar;
