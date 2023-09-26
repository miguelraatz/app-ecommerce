import { useContext, useEffect } from "react";
import ProductContext from "../context/ProductContext";
import Header from "../components/Header";
import CardProduct from "../components/CardProduct";
import requestGetApi from "../helpers/requestGetApi";
import "../styles/Cart.css";
import Swal from 'sweetalert2/dist/sweetalert2.js'

import 'sweetalert2/src/sweetalert2.scss'
import requestDeleteApi from "../helpers/requestDeleteApi";

function Cart() {

  const { cart, setCart } = useContext(ProductContext);
  
  useEffect(() => {
    async function fetchData() {
      const data = await requestGetApi("cart")
      const products = data.map((product) => product.products);
      setCart(products);
    }
    fetchData();
  }, []);
  
  const sendEmail = async (to) => {
    await fetch(`http://localhost:8080/email/send?to=${to}&subject=Compra realizada com 
    sucesso&message=Obrigado por comprar conosco!`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
    });
  }

  const handleClick = () => {
    Swal.fire({
      title: 'Deseja efetuar o pagamento?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText:'Cancelar',
      confirmButtonText: 'Sim'
    }).then(async (result) => {
      if (result.isConfirmed) {
        const user = localStorage.getItem('user');
        const { email, id } = JSON.parse(user);
        sendEmail(email);
        Swal.fire(
          'Seu pagamento foi confirmado!',
          `Confira as informações no e-mail ${email}`,
          'success'
        )
        setCart([]);
        cart?.map((products) => products.map(async (product) => {
          await requestDeleteApi('cart', id, product.id);
        }));
        
      }
    })
  }

  return (
    <>
      <Header />
      <div className="cart-container">
        <div className="container-products-cart">
          {cart?.map((products) => products.map((product) => (
            <CardProduct key={product.id} product={product} />
          )
          ))}
        </div>
        <div className="container-button-value-cart">
          <h2 className="title-cart">Valor total: R$ {
            cart?.map((products) => products
            .reduce((acc, product) => acc + product.price, 0).toFixed(2))
          }
          </h2>
          <button
            type="button"
            className="button-login"
            onClick={ handleClick }
          >
            Efetue o pagamento
          </button>
        </div>
      </div>
    </>
  )
}

export default Cart;
