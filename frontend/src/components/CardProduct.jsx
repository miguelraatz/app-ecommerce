function CardProduct({ product }) {
    return (
        <div className="card">
            <img src={product.image} alt={product.name} className="card-image"/>
            <div className="card-body">
                <h2 className="card-name">{product.name}</h2>
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
        </div>
    )
}

export default CardProduct;
