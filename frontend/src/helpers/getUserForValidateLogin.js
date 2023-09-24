const getUserForValidateLogin = async (body) => {
  const response = await fetch(`http://localhost:8080/user`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    });

    if (!response.ok) throw new Error('Usuário ou senha incorretos!');
    
    const data = await response.json();
    return data;
}

export default getUserForValidateLogin;