import { useContext } from "react";
import ProductContext from "../context/ProductContext";
import Header from "../components/Header";
import CardProduct from "../components/CardProduct";
import "../styles/Cart.css";

function Cart() {

  const { cart } = useContext(ProductContext);

  return (
    <>
      <Header />
      <div className="cart-container">
        <div className="container-products-cart">
          {cart?.map((product) => (
            <CardProduct key={product.id} product={product} />
          ))}
        </div>
        <div className="container-button-value-cart">
          <h2 className="title-cart">Valor total: R$ {
            cart?.reduce((acc, product) => acc + product.price, 0).toFixed(2)
          }</h2>
          <button
            type="button"
            className="button-login"
            onClick={(e) => handleClick(e)}
          >
            Efetue o pagamento
          </button>
        </div>
      </div>
    </>
  )
}

export default Cart;
