import React, { Component } from 'react';
import axios from 'axios';


export default class Login extends Component {
  constructor(props) {
    super (props);
    this.onSubmit = this.onSubmit.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.state = {
      username: '',
      password: '',
    }
  }

  onChangeUsername(e) {
    this.setState({ username: e.target.value})
  }

  onChangePassword(e) {
    this.setState({ password: e.target.value })
  }

  onSubmit(e) {
    e.preventDefault();
    const loginObject = {
      username: this.state.username,
      password: this.state.password,
    };
    axios.post('/login', loginObject)
   .then((res) => {
     console.log(res.data)
   }).catch((error) => {
     console.log(error)
   })
  }

  render() {
    return (
      <div>
        <h1>Login</h1>
        <form onSubmit={this.onSubmit}>

          <div className="form-group">
            <label>Username: </label>
            <input
              type="text"
              onChange={this.onChangeUsername}
              value={this.state.username}
              placeholder="Username"
              />
          </div>

          <div className="form-group">
            <label>Password: </label>
            <input
              type="password"
              onChange={this.onChangePassword}
              value={this.state.password}
              placeholder="Password" />
          </div>
          <button type="submit">
            Login
          </button>

        </form>
      </div>
    )
  }
}
