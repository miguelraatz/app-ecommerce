export default async function requestGetApi(endpoint) {
  const response = await fetch(`http://localhost:8080/${endpoint}`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    },
  });
  const data = await response.json();
  return data;
}