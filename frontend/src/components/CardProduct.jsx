import '../styles/CardProduct.css';
import requestApi from '../helpers/requestApi';
import { useLocation } from 'react-router-dom';
import requestDeleteApi from '../helpers/requestDeleteApi';
import { toast } from 'react-toastify';
import { useEffect, useState } from 'react';

function CardProduct({ product }) {

  const [user, setUser] = useState({});

  const location = useLocation();
    
  const handleClick = async () => {
    if (location.pathname === '/home') {
      await requestApi('home', 'POST', { userId: user.id, productId: product.id });
      toast.success('Produtos adicionado com sucesso!');
    } else {
      await requestDeleteApi('cart', user.id, product.id);
      toast.success('Produto removido com sucesso!');
    }
  };

  useEffect(() => {
    const userJSON = localStorage.getItem('user');
    if (!userJSON) {
      throw new Error('Usuário não encontrado');
    }
    const user = JSON.parse(userJSON);
    setUser(user);
  }, []);

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
          {location.pathname === '/home' ? 'Adicionar ao carrinho' : 'Remover'}
        </button>
      </div>
    </section>
  )
}

export default CardProduct;
