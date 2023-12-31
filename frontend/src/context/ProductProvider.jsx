import { useMemo, useState } from "react";
import PropTypes from "prop-types";
import ProductContext from "./ProductContext";

function ProductProvider({ children }) {
  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);

  const data = useMemo(() => {
    return { products, setProducts, cart, setCart };
  }, [products, cart]);

  return (
    <ProductContext.Provider value={ data }>{children}</ProductContext.Provider>
  )
}

ProductProvider.propTypes = {
  children: PropTypes.node.isRequired,
};

export default ProductProvider;
