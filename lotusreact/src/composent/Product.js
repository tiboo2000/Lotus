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
      <input type="number" min="1" max="10" step="1" defaultValue={1} id={"inputquantitytocart" + product.id}/>
    </div>
    <div className="ajout-panier">
      <button onClick={() => onAddToCart(product,document.getElementById("inputquantitytocart" + product.id).value)}>Ajouter au Panier</button>
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

  const handleAddToCart = (product,newquantity) => {
    // on ajoute le produit au panier
    try {
      axios.delete('http://localhost:9090/bag/delete/product', {
          params: { nameuser:"test" },
          data: product
      });
  } catch (error) {
      console.error('Failed to delete product:', error);
  }
    axios.post('http://localhost:9090/bag/add',
                {id: product.id,
                name: product.name,
                price: product.price,
                categoryId: product.categoryId},
                 {
                params: {
                    nameuser: "test"
                }
    })
    //on change la quantite de produit
    try {
      axios.put('http://localhost:9090/bag/update',
              {
              id: product.id,
              name: product.name,
              price: product.price,
              categoryId: product.categoryId
              },
              {
              params: {
                  nameuser: "test",
                  quantity: newquantity,
                  operation: "set"
              }
      })
      }
  catch (error) {
      console.error('Failed change quantity product:', error);
  }
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