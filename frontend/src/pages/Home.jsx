import { useContext, useEffect } from "react";
import Header from "../components/Header";
import ProductContext from "../context/ProductContext";
import CardProduct from "../components/CardProduct";

function Home() {
  const { products, setProducts } = useContext(ProductContext);

  useEffect(() => {  
    async function fetchData() {
      const response = await fetch('http://localhost:8080/home', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        },
      });
      const data = await response.json();
      setProducts(data);
      return data;
    }
    fetchData();
  }, []);  
  return(
    <>
      <Header />
      {products?.map((product) => (
        <CardProduct key={product.id} product={product} />
      ))}
    </>
    )
}

export default Home;
