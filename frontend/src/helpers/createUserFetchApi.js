const createUserFetchApi = async (body) => {
  const response = await fetch(`http://localhost:8080/register`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    });

    if (!response.ok) throw new Error('Usuário já cadastrado!');
    
    const data = await response.json();
    return data;
}

export default createUserFetchApi;
