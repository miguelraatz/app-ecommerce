import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import ToastComponent from './components/ToastComponent';
import 'react-toastify/dist/ReactToastify.min.css';
import ProductProvider from './context/ProductProvider';


ReactDOM.createRoot(document.getElementById('root')).render(
  <ProductProvider>
    <BrowserRouter>
      <App />
      <ToastComponent />
    </BrowserRouter>
  </ProductProvider>,
)
