import React, { Component } from 'react';
import { CookiesProvider } from 'react-cookies';

import './App.css';

export default class App extends Component {
  render() {
    return (
      <CookiesProvider>
        <Router...>
      </CookiesProvider>
    )
  }
}
