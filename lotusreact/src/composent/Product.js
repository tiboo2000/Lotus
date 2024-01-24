import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Product.css'; // Assurez-vous que le fichier CSS existe et est correctement configuré

const ProductCard = ({ product, onAddToCart, onDeleteProduct }) => (
  <div className="product-card">
    <div className="product-title">{product.name}</div>
    <div className="product-id">Id: {product.id}</div>
    <div className="product-price">Prix: {product.price} €</div>
    <div className="product-category">Id de la catégorie: {product.categoryId}</div>
    <div className="quantity-product">
      <input type="number" min="1" max="10" step="1" value="1" />
    </div>
    <div className="ajout-panier">
      <button onClick={() => onAddToCart(product)}>Ajouter au Panier</button>
    </div>
    <div className="supprimer-produit">
      <button onClick={() => onDeleteProduct(product.id)}>Supprimer Produit</button>
    </div>
  </div>
);

const Product = () => {
  const [products, setProducts] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [productToAdd, setProductToAdd] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:9090/products/all')
      .then(response => {
        setProducts(response.data);
      })
      .catch(error => {
        console.error("Erreur lors de la récupération des produits:", error);
      });
  }, []);

  const handleAddToCart = (product) => {
    //Ajouter le code pour ajouter au panier
  };

  const handleConfirmAddToCart = () => {
    // Effectuer la requête POST pour ajouter le produit
    axios.post('http://localhost:9090/product', productToAdd)
      .then(response => {
        // Le produit a été ajouté avec succès
        console.log("Produit ajouté avec succès:", response.data);
        setIsModalOpen(false);
      })
      .catch(error => {
        console.error("Erreur lors de l'ajout du produit:", error);
        setIsModalOpen(false);
      });
  };

  const handleDeleteProduct = (productId) => {
    // Effectuer la requête DELETE pour supprimer le produit
    axios.delete(`http://localhost:9090/product/${productId}`)
      .then(response => {
        // Le produit a été supprimé avec succès
        console.log("Produit supprimé avec succès:", response.data);
        // Mettre à jour la liste des produits après la suppression
        setProducts(products.filter(product => product.id !== productId));
      })
      .catch(error => {
        console.error("Erreur lors de la suppression du produit:", error);
      });
  };

  return (
    <div className="product-catalog">
      <h2>Lotus Market</h2>
      <div className="product-list">
        {products.map(product => (
          <ProductCard
            key={product.id}
            product={product}
            onAddToCart={handleAddToCart}
            onDeleteProduct={handleDeleteProduct}
          />
        ))}
      </div>

      {isModalOpen && (
        <div className="modal">
          <div className="modal-content">
            <h3>Ajouter au Panier</h3>
            <p>Informations sur le produit:</p>
            <p>Nom: {productToAdd.name}</p>
            <p>Prix: {productToAdd.price} €</p>
            <p>Catégorie ID: {productToAdd.categoryId}</p>
            <button onClick={handleConfirmAddToCart}>Confirmer</button>
            <button onClick={() => setIsModalOpen(false)}>Annuler</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default Product;