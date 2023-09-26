import logo from '../images/logo.png';
import '../styles/Header.css';
import { AiOutlineShoppingCart, AiOutlineLogout } from 'react-icons/ai';
import { useHistory } from 'react-router-dom';
import { toast } from 'react-toastify';

function Header() {

  const history = useHistory();

  return (
    <header className="header">
      <button type="button" className="button-header" onClick={ () => history.push('/home') }>
        <img src={logo} alt="Logo" className="header__logo" />
      </button>
      <div className="container-cart">
        <h2 onClick={ () => history.push('/cart') }>Meu Carrinho <AiOutlineShoppingCart className="icon" /></h2>
        <h2 onClick={ () => {
          toast.success('Logout efetuado com sucesso!');
          localStorage.clear();
          history.push('/');
        } }>Sair <AiOutlineLogout className="icon" /></h2>
      </div>
    </header>
  )
}

export default Header;
