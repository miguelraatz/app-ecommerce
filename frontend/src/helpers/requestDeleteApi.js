export default async function(endopoint, user, product) {
  await fetch(`http://localhost:8080/${endopoint}/${user}/${product}`, {
    method: 'DELETE'
  });
}