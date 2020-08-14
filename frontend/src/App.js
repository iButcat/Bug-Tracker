import React, { Component } from 'react';

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
        <Home />
    )
  }
}
