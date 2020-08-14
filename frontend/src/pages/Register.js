import React, { Component } from 'react';
import axios from 'axios';

axios.defaults.xsrfCookieName = 'csrftoken'
axios.defaults.xsrfHeaderName = "X-CSRFTOKEN"


export default class Register extends Component {
  constructor(props) {
    super (props);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.state = {
      username: "",
      email: "",
      password: "",
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

  onSubmit(e) {
    e.preventDefault()
    const registerObject = {
      username: this.state.username,
      email: this.state.email,
      password: this.state.password
    };
    axios.post('127.0.0.1:8080/registration', registerObject)
   .then((res) => {
     console.log(res.data)
   }).catch((error) => {
     console.log(error)
   })
 };

  render() {
    return (
    )
  }
}
