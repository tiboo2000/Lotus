import React from 'react';
import './page.css'; // Assurez-vous que vos styles sont définis dans ce fichier CSS

const products = [
  { id: '12345', category: 'Electronics', price: '$99.99' },
  { id: '23456', category: 'Home & Kitchen', price: '$59.99' },
  { id: '34567', category: 'Sports & Outdoors', price: '$79.99' },
];

const ProductCard = ({ product }) => (
  <div className="product-card">
    <div className="product-title">Product {product.id.slice(-1)}</div>
    <div className="product-category">Category: {product.category}</div>
    <div className="product-id">Product ID: {product.id}</div>
    <div className="product-price">{product.price}</div>
    <div className="product-quantity">
      Quantity
      <input type="number" defaultValue={1} min={1} />
    </div>
    <button className="add-to-cart-btn">Add to Cart</button>
  </div>
);

const Page = () => (
  <div className="product-catalog">
    <h2>Our Products</h2>
    <div className="product-list">
      {products.map(product => (
        <ProductCard key={product.id} product={product} />
      ))}
    </div>
  </div>
);

export default Page;