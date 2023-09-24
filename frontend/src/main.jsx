import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import ToastComponent from './components/ToastComponent';
import 'react-toastify/dist/ReactToastify.min.css';


ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <App />
    <ToastComponent />
  </BrowserRouter>,
)
