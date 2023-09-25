import { useContext } from "react";
import ProductContext from "../context/ProductContext";
import CardProduct from "../components/CardProduct";
import Header from "../components/Header";

function Cart() {

  const { cart } = useContext(ProductContext);
  console.log(cart);

  return (
    <div className="container-cart">
      <Header />
      {cart?.map((product) => (
        <div className="section-cart">
          <h2 className="card-name">{product.name}</h2>
          <img src={product.image} alt={product.name} className="card-image"/>
          <div div className="card-body">
            <p className="card-description">{product.description}</p>
            <p className="card-price">R$ {product.price}</p>
          </div>
        </div>
      ))}
    </div>
  )
}

export default Cart;
