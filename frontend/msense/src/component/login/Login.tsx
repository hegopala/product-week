import React from 'react';
import { Link } from 'react-router-dom';
import InputField from '../inputfield/InputField';
import './Login.css';

const Login: React.FC = () => {
  return (
    <div className="login-wrapper">
      <h1>Login</h1>
      <form>
        <InputField placeholder="Email" type="email" />
        <InputField placeholder="Password" type="password" />
        <Link to="/forgotpassword">
          <p>forgot password ?</p>
        </Link>
        <Link to="/dashboard">
          <InputField type="submit" />
        </Link>
        <p>not a member ? &nbsp;&nbsp;<Link to="/register">Register</Link></p>
      </form>
    </div>
  )
}

export default Login;