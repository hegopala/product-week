import React from 'react';
import { Link } from 'react-router-dom';
import InputField from '../inputfield/InputField';
import './Login.css';
import isEmail from 'validator/lib/isEmail';

const Login: React.FC = () => {
  const [isEmailError, setEmailError] = React.useState(false);
  const [isPasswordError, setPasswordError] = React.useState(false);

  let email: (string | undefined);
  let password: (string | undefined);

  const onEmailChange = (val?: string) => {
    email = val;
    validateEmail()
  }

  const onPasswordChange = (val?: string) => {
    password = val;
    validatePassword()
  }

  const validateEmail = () => {
    if (!(email && isEmail(email))) {
      setEmailError(true);
      return false;
    }
    setEmailError(false);
    return true;
  }

  const validatePassword = () => {
    if (!password || password?.length === 0) {
      setPasswordError(true);
      return false;
    }
    setPasswordError(false);
    return true;
  }

  const onFormSubmit = (event: React.MouseEvent) => {
    if (!validateEmail() || !validatePassword()) {
      event.preventDefault();
    }
  }

  return (
    <div className="login-wrapper">
      <h1>Login</h1>
      <div>
        <InputField value={email} onInputChange={onEmailChange} placeholder="Email" type="email" />
        {isEmailError ? (<p>Not valid Email</p>) : (<p></p>)}
        <InputField value={password} onInputChange={onPasswordChange} placeholder="Password" type="password" />
        {isPasswordError ? (<p>Not valid Password</p>) : (<p></p>)}
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