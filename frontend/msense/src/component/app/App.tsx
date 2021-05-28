import React from 'react';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import AssetInfo from '../assetinfo/AssetInfo';
import Dashboard from '../dashboard/Dashboard';
import Login from '../login/Login';
import NotFound from '../notfound/NotFound';
import Register from '../register/Register';
import './app.css'

function App() {
  return (
    <div className="app">
      <BrowserRouter>
        <Switch>
          <Route exact path="/">
            <Redirect to="/login"></Redirect>
          </Route>
          <Route exact path="/login" component={Login} />
          <Route exact path="/register" component={Register} />
          <Route exact path="/dashboard" component={Dashboard} />
          <Route
            exact
            path="/dashboard/asset/:assetId"
            render={(props) => (<AssetInfo assetId={props.match.params.assetId} />)}
          />
          <Route path="/404-not-found" exact component={NotFound} />
          <Route path="*">
            <Redirect to="/404-not-found" />
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
