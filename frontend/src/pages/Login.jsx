import { NavLink, useHistory } from 'react-router-dom';
import logo from '../images/logo.png';
import '../styles/Login.css';

function Login() {

  const history = useHistory();

  const handleClick = (e) => {
    e.preventDefault();
    history.push('/home');
  }

  return (
      <form className="container-login">
        <section className="container-login__section">
          <img src={ logo } alt="logo-login" className="logo-login" />
          <input type="text" placeholder="Digite seu e-mail" className="input-login" />
          <input type="password" placeholder="Digite sua senha" className="input-login" />
          <button
            type="button"
            className="button-login"
            onClick={ (e) => handleClick(e) }
          >
            Entrar
          </button>
          <p>Não tem cadastro?
            <NavLink className="nav-link-register" to="register">Clique-Aqui!</NavLink>
          </p>
        </section>
      </form>
  );
}

export default Login;
