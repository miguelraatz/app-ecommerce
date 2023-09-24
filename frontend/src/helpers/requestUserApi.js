const requestUserApi = async (endpoint, method, body) => {
  const response = await fetch(`http://localhost:8080/${endpoint}`, {
      method: method,
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    });    
    const data = await response.json();
    return data;
}

export default requestUserApi;
