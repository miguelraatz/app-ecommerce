import { Switch, Route } from 'react-router-dom';
import Login from './pages/Login';
import Register from './pages/Register';
import Home from './pages/Home';
import Cart from './pages/Cart';

function App() {

  return (
    <Switch>
      <Route path="/cart" component={ Cart } />
      <Route path="/home" component={ Home } />
      <Route path="/register" component={ Register } />
      <Route path="/" exact component={ Login } />
    </Switch>
  )
}

export default App
