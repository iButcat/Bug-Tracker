import React, { Component } from 'react';
import { CookiesProvider } from 'react-cookie';

import './App.css';

import Home from './pages/Home';

export default class App extends Component {
  render() {
    return (
      <CookiesProvider>
        <Home />
      </CookiesProvider>
    )
  }
}
