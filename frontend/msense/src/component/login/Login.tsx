import { Button, FormControl, Input, InputLabel, Link as LinkUI } from '@material-ui/core';
import React from 'react';
import isEmail from 'validator/lib/isEmail';
import './login.css';

const Login: React.FC = () => {
  const [isEmailError, setEmailError] = React.useState(false);

  const validateEmail = (val?: string) => {
    if (!val || !isEmail(val)) {
      setEmailError(true);
      return false;
    }
    setEmailError(false);
    return true;
  }

  const onFormSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    if (isEmailError) event.preventDefault();
  }

  return (
    <div className="login-wrapper">
      <div className="login-form">
        <h1 className="product-heading">MSense</h1>
        <form onSubmit={event => onFormSubmit(event)} action="/dashboard">
          <FormControl fullWidth={true} required={true} error={isEmailError}>
            <InputLabel htmlFor="email">Email</InputLabel>
            <Input onChange={(event) => validateEmail(event.target.value)} id="email" type="email" autoComplete="off" />
          </FormControl>
          <FormControl fullWidth={true} required={true}>
            <InputLabel htmlFor="password">Password</InputLabel>
            <Input id="password" type="password" autoComplete="off" />
          </FormControl>
          <div className="login-forgot-password-wrapper">
            <LinkUI href="/forgot" variant="body2">
              Forgot password?
            </LinkUI>
          </div>
          <FormControl fullWidth={true}>
            <Button variant="contained" color="secondary" style={{ backgroundColor: "cornflowerblue" }} type="submit">
              Login
            </Button>
          </FormControl>
        </form>
        <div className="login-register-wrapper">
          <p>
            Not a member ?&nbsp;
            <LinkUI href="/register" variant="body2">
              Register
            </LinkUI>
          </p>
        </div>
      </div>
    </div>
  )
}

export default Login;