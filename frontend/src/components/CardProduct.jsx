import { useContext } from 'react';
import '../styles/CardProduct.css';
import ProductContext from '../context/ProductContext';
import requestUserApi from '../helpers/requestUserApi';
import { useLocation } from 'react-router-dom';

function CardProduct({ product }) {

  const location = useLocation();

  const { setCart } = useContext(ProductContext);
    
  const handleClick = async () => {
    const userJSON = localStorage.getItem('user');
    if (!userJSON) {
      throw new Error('Usuário não encontrado');
    }
    const user = JSON.parse(userJSON);
    setCart((prevCart) => [...prevCart, product]);
    await requestUserApi('home', 'POST', { userId: user.id, productId: product.id });
  };

  return (
    <section className="card-container">
      <h2 className="card-name">{product.name}</h2>
      <img src={product.image} alt={product.name} className="card-image"/>
      <div className="card-body">
          <p className="card-description">{product.description}</p>
          <p className="card-price">R$ {product.price}</p>
          {location.pathname === '/home' && 
          <button
          type="button"
          value={product}
          className="button-login"
          onClick={ handleClick }
        >
          Adicionar ao carrinho
        </button>}
      </div>
    </section>
  )
}

export default CardProduct;
