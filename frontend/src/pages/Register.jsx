import { useHistory } from 'react-router';
import '../styles/Register.css';

function Register() {

  const history = useHistory();

  const handleClick = (e) => {
    e.preventDefault();
    history.goBack();
  }

  return (
  <form className="container-register">
  <section className="container-register__section">
    <input type="text" placeholder="Digite seu nome completo" className="input-register" />
    <input type="text" placeholder="Digite seu e-mail" className="input-register" />
    <input type="password" placeholder="Digite sua senha" className="input-register" />
    <button
      type="button"
      className="button-register"
      onClick={ (e) => handleClick(e) }
    >
      Registrar
    </button>
  </section>
</form>
);
}

export default Register;
