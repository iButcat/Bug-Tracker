import React, { Component } from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from 'react-router-dom';
import { CookiesProvider } from 'react-cookie';
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
    <CookiesProvider>
    <Router>
      <div>
        <Link to="/">Home</Link>
      </div>
      <Switch>
        <Route exact={true} path="/" component = {Home} />
      </Switch>
    </Router>
    </CookiesProvider>
    )
  }
}
