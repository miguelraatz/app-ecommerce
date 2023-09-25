import { useContext } from "react";
import ProductContext from "../context/ProductContext";
import Header from "../components/Header";
import CardProduct from "../components/CardProduct";
import "../styles/Cart.css";
import Swal from 'sweetalert2/dist/sweetalert2.js'

import 'sweetalert2/src/sweetalert2.scss'

function Cart() {

  const { cart, setCart } = useContext(ProductContext);

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
            onClick={() => {
              Swal.fire({
                title: 'Deseja efetuar o pagamento?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                cancelButtonText:'Cancelar',
                confirmButtonText: 'Sim'
              }).then((result) => {
                if (result.isConfirmed) {
                  const user = localStorage.getItem('user');
                  const { email } = JSON.parse(user);
                  Swal.fire(
                    'Seu pagamento foi confirmado!',
                    `Confira as informações no e-mail ${email}.`,
                    'success'
                  )
                  setCart([]);
                }
              })
            }}
          >
            Efetue o pagamento
          </button>
        </div>
      </div>
    </>
  )
}

export default Cart;
