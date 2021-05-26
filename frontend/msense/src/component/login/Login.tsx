import React from 'react';
import { Link } from 'react-router-dom';
import InputField from '../inputfield/InputField';
import './Login.css';
import isEmail from 'validator/lib/isEmail';

const Login: React.FC = () => {
  const [isEmailError, setEmailError] = React.useState(false);
  //password
  let email: (string | undefined);
  const onInputChange = (val?: string) => {
    email = val;
  }

  const onFormSubmit = (event: React.MouseEvent) => {

    if (!(email && isEmail(email))) {
      setEmailError(true);
      event.preventDefault();
    }
  }

  return (
    <div className="login-wrapper">
      <h1>Login</h1>
      <div>
        <InputField onInputChange={onInputChange} placeholder="Email" type="email" />
        {isEmailError ? (<p>Not valid Email</p>) : (<p></p>)}
        <InputField placeholder="Password" type="password" />
        <Link to="/forgotpassword">
          <p>forgot password ?</p>
        </Link>

        <Link to="/dashboard" onClick={event => onFormSubmit(event)}>
          <button >Submit</button>
        </Link>
        <p>not a member ? &nbsp;&nbsp;<Link to="/register">Register</Link></p>
      </div>
    </div>
  )
}

export default Login;