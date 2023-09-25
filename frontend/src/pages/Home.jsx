import { useContext, useEffect } from "react";
import Header from "../components/Header";
import ProductContext from "../context/ProductContext";
import CardProduct from "../components/CardProduct";
import "../styles/Home.css";

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
    <div className="container-home">
      <Header />
      {products?.map((product) => (
        <CardProduct key={product.id} product={product} />
      ))}
    </div>
    )
}

export default Home;
