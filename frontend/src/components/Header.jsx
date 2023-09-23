import logo from '../images/logo.png';
import '../styles/Header.css';

function Header() {
  return (
    <header className="header">
      <img src={logo} alt="Logo" className="header__logo" />
    </header>
  )
}

export default Header;
