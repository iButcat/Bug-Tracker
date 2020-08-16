import React, { Component } from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from 'react-router-dom';
import PropTypes from 'prop-types';

// css
import './App.css';

// components
import Navbar from './components/Navbar';

// pages
import Login from './pages/Login';
import Register from './pages/Register';
import Home from './pages/Home';


export default class App extends Component {
  render() {
    return (
    <Router>
      <div>
        <Link to="/">Home</Link>
        <Link to="/register">Register</Link>
        <Link to="/login">Login</Link>
      </div>
      <Switch>
        <Route exact={true} path="/" component = {Home} />
        <Route exact={true} path="/register" component={Register} />
        <Route exact={true} path="/login" component={Login} />
      </Switch>
    </Router>
    )
  }
}
