import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

axios.defaults.xsrfCookieName = 'csrftoken'
axios.defaults.xsrfHeaderName = "X-CSRFTOKEN"


export default class Register extends Component {
  constructor(props) {
    super (props);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.onChangePasswordMatches = this.onChangePasswordMatches.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.state = {
      username: "",
      email: "",
      password: "",
      passwordMatches: "",
      login: false
    }
  }

  onChangeUsername(e) {
    this.setState({username: e.target.value})
  }

  onChangeEmail(e) {
    this.setState({email: e.target.value})
  }

  onChangePassword(e) {
    this.setState({password: e.target.value})
  }

  onChangePasswordMatches(e) {
    this.setState({passwordMatches: e.target.value})
  }

  onSubmit(e) {
    e.preventDefault()
    const registerObject = {
      username: this.state.username,
      email: this.state.email,
      password: this.state.password,
      passwordMatches: this.state.passwordMatches
    };
    axios.post('/register', registerObject)
   .then((res) => {
     console.log(res.data)
   }).catch((error) => {
     console.log(error)
   })
 };

  render() {
    return (
      <form onSubmit={this.onSubmit}>
        <div className="form-group">
          <label>Username: </label>
          <input
            type="text"
            className="form-control"
            onChange={this.onChangeUsername}
            value={this.state.username}
            placeholder="Username"
            />
        </div>

        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            onChange={this.onChangeEmail}
            value={this.state.email}
            placeholder="Email"
            />
        </div>

        <div className="form-group">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            onChange={this.onChangePassword}
            value={this.state.password}
            placeholder="Password"
            />
        </div>

        <div className="form-group">
          <label>Confirm Password</label>
          <input
            type="password"
            className="form-control"
            onChange={this.onChangePasswordMatches}
            value={this.state.passwordMatches}
            placeholder="Repeat Password"
            />
        </div>

        <button type="submit">
        <Link to="/login">
          Register
          </Link>
        </button>
      </form>
    )
  }
}
