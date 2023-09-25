import '../styles/CardProduct.css';

function CardProduct({ product }) {
    return (
        <section className="card-container">
            <h2 className="card-name">{product.name}</h2>
            <img src={product.image} alt={product.name} className="card-image"/>
            <div className="card-body">
                <p className="card-description">{product.description}</p>
                <p className="card-price">R$ {product.price}</p>
                <button
                  type="button"
                  className="button-login"
                  onClick={(e) => handleClick(e)}
                >
                  Adicionar ao carrinho
                </button>
            </div>
          </section>
    )
}

export default CardProduct;
