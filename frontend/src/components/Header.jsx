import logo from '../images/logo.png';
import '../styles/Header.css';
import { AiOutlineShoppingCart, AiOutlineLogout } from 'react-icons/ai';
import { useHistory } from 'react-router-dom';
import { toast } from 'react-toastify';

function Header() {

  const history = useHistory();

  const handleClick = () => {
    toast.success('Logout efetuado com sucesso!');
    history.push('/');
  }

  return (
    <header className="header">
      <img src={logo} alt="Logo" className="header__logo" />
      <div className="container-cart">
        <h2>Meu Carrinho <AiOutlineShoppingCart className="icon" /></h2>
        <h2 onClick={ handleClick }>Sair <AiOutlineLogout className="icon" /></h2>
      </div>
    </header>
  )
}

export default Header;
