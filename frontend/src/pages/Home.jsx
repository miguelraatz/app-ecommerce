import { useContext, useEffect } from "react";
import Header from "../components/Header";
import ProductContext from "../context/ProductContext";
import CardProduct from "../components/CardProduct";
import requestGetApi from "../helpers/requestGetApi";
import "../styles/Home.css";

function Home() {
  const { products, setProducts } = useContext(ProductContext);

  useEffect(() => {
    async function fetchData() {
      const data = await requestGetApi("home")
      setProducts(data);
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
