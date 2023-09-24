import { useHistory } from 'react-router';
import '../styles/Register.css';
import { useState } from 'react';
import createUserFetchApi from '../helpers/createUserFetchApi';
import { toast } from 'react-toastify';

function Register() {

  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const history = useHistory();

  const registerUser = async () => {
    try {
      if (!name || !email || !password) return toast.error('Preencha todos os campos!');
      await createUserFetchApi({ name, email, password });
      toast.success('Usuário cadastrado com sucesso!');
      history.goBack();
    } catch (error) {
      toast.error('Email já cadastrado');
      setPassword('');
    }
  }

  const handleClick = async (e) => {
    e.preventDefault();
    await registerUser();
  }

  return (
  <form className="container-register">
  <section className="container-register__section">
    <input
      type="text"
      placeholder="Digite seu nome completo"
      className="input-register"
      value={ name }
      onChange={ (e) => setName(e.target.value) }
    />
    <input
      type="text"
      placeholder="Digite seu e-mail"
      className="input-register"
      value={ email }
      onChange={ (e) => setEmail(e.target.value) }
    />
    <input
      type="password"
      placeholder="Digite sua senha"
      className="input-register"
      value={ password }
      onChange={ (e) => setPassword(e.target.value) }
    />
    <button
      type="button"
      className="button-register"
      onClick={ (e) => handleClick(e) }
    >
      Registrar
    </button>
    <button
      type="button"
      className="button-register"
      onClick={ () => history.goBack() }
    >
      Voltar
    </button>
  </section>
</form>
);
}

export default Register;
