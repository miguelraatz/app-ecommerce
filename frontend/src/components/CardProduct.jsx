import { useCallback, useContext, useEffect, useState } from 'react';
import '../styles/CardProduct.css';
import ProductContext from '../context/ProductContext';

function CardProduct({ product }) {

  const { setCart } = useContext(ProductContext);

  const handleClick = useCallback (() => {
    setCart((prevCart) => [...prevCart, product]);
  }, [product, setCart]);

  return (
    <section className="card-container">
      <h2 className="card-name">{product.name}</h2>
      <img src={product.image} alt={product.name} className="card-image"/>
      <div className="card-body">
          <p className="card-description">{product.description}</p>
          <p className="card-price">R$ {product.price}</p>
          <button
            type="button"
            value={product}
            className="button-login"
            onClick={ handleClick }
          >
            Adicionar ao carrinho
          </button>
      </div>
    </section>
  )
}

export default CardProduct;
