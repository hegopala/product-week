import { Button, FormControl, Input, InputLabel, Link as LinkUI } from '@material-ui/core';
import React from 'react';
import isEmail from 'validator/lib/isEmail';
import AuthStateProps from '../../model/props/AuthStateProp';
import Loader from '../loader/Loader';
import './login.css';

const Login: React.FC<AuthStateProps> = (props) => {
  const [isEmailError, setEmailError] = React.useState(false);
  const [isLoading, setLoading] = React.useState(false);

  const [email, setEmail] = React.useState<string | undefined>();
  const [password, setPassword] = React.useState<string | undefined>();

  const onEmailChange = (val?: string) => {
    if (!val || !isEmail(val)) {
      setEmailError(true);
      return false;
    }
    setEmail(val);
    setEmailError(false);
    return true;
  }

  const onPasswordChange = (val?: string) => {
    setPassword(val);
  }

  const onFormSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    // Preventing form from getting submitted
    event.preventDefault();
    // Checking for valid email
    if (isEmailError) return

    // Form is Valid
    setLoading(true);
    // Call Login api with credentials and check for validity
    setTimeout(() => {
      setLoading(false);
      props.onAuthenticationStateChange?.(true);
    }, 2000);
  }

  return (
    <div className="login-wrapper">
      {isLoading ? (<Loader />) : ""}
      <div className="login-form">
        <h1 className="product-heading">MSense</h1>
        <form onSubmit={event => onFormSubmit(event)} action="/dashboard">
          <FormControl fullWidth={true} required={true} error={isEmailError}>
            <InputLabel htmlFor="email">Email</InputLabel>
            <Input onChange={(event) => onEmailChange(event.target.value)} id="email" type="email" autoComplete="off" />
          </FormControl>
          <FormControl fullWidth={true} required={true}>
            <InputLabel htmlFor="password">Password</InputLabel>
            <Input onChange={(event) => onPasswordChange(event.target.value)} id="password" type="password" autoComplete="off" />
          </FormControl>
          <div className="login-forgot-password-wrapper">
            <LinkUI href="/forgot" variant="body2">
              Forgot password?
            </LinkUI>
          </div>
          <FormControl fullWidth={true}>
            <Button disabled={isLoading} variant="contained" color="secondary" style={{ backgroundColor: "cornflowerblue" }} type="submit">
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