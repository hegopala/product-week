import React from 'react';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import AssetInfo from '../assetinfo/AssetInfo';
import Dashboard from '../dashboard/Dashboard';
import Login from '../login/Login';
import NotFound from '../notfound/NotFound';
import Register from '../register/Register';
import './app.css';

function App() {
  const localStorageAuthKey = "auth-state";
  const localAuthState = localStorage.getItem(localStorageAuthKey) === "true";
  const [isAuthenticated, setAuthenticationState] = React.useState(localAuthState);
  const onAuthenticationStateChangeListener = (authState: boolean) => {
    localStorage.setItem(localStorageAuthKey, String(authState));
    setAuthenticationState(authState);
  }

  return (
    <div className="app">
      <BrowserRouter>
        <Switch>
          <Route exact path="/">
            <Redirect to="/login" />
          </Route>
          <Route exact path="/login">
            {isAuthenticated ? (<Redirect to="/dashboard" />) : (<Login onAuthenticationStateChange={onAuthenticationStateChangeListener} />)}
          </Route>
          <Route exact path="/register">
            {isAuthenticated ? (<Redirect to="/dashboard" />) : (<Register onAuthenticationStateChange={onAuthenticationStateChangeListener} />)}
          </Route>
          <Route exact path="/dashboard">
            {isAuthenticated ? (<Dashboard onAuthenticationStateChange={onAuthenticationStateChangeListener} />) : (<Redirect to="/login" />)}
          </Route>
          <Route
            exact
            path="/asset/:assetId">
            {isAuthenticated ? (<AssetInfo onAuthenticationStateChange={onAuthenticationStateChangeListener} />) : (<Redirect to="/login" />)}
          </Route>
          <Route path="/404-not-found" exact>
            <NotFound />
          </Route>
          <Route path="*">
            <Redirect to="/404-not-found" />
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
