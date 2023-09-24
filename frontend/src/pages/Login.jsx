import { NavLink, useHistory } from 'react-router-dom';
import logo from '../images/logo.png';
import '../styles/Login.css';
import { useState } from 'react';
import getUserForValidateLoginApi from '../helpers/getUserForValidateLoginApi';
import { toast } from 'react-toastify'

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const history = useHistory();

  const fetchUser = async () => {
    try {
      if (!email || !password) return toast.error('Preencha todos os campos!');
      const user = await getUserForValidateLoginApi({ email, password });
      if (user.email === email && user.password === password) {
        history.push('/home');
        toast.success('Login efetuado com sucesso!');
      }
    } catch (error) {
      toast.error('Email ou senha inválidos');
    }
  }

  const handleClick = async (e) => {
    e.preventDefault();
    await fetchUser();
  }

  return (
      <form className="container-login">
      <section className="container-login__section">
        <img src={logo} alt="logo-login" className="logo-login" />
        <input
          type="text"
          placeholder="Digite seu e-mail"
          className="input-login"
          value={email}
          onChange={(e) => setEmail(e.target.value)} />
        <input
          type="password"
          placeholder="Digite sua senha"
          className="input-login"
          value={password}
          onChange={(e) => setPassword(e.target.value)} />
        <button
          type="button"
          className="button-login"
          onClick={(e) => handleClick(e)}
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
