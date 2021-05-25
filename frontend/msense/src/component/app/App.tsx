import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import AssetInfo from '../assetinfo/AssetInfo';
import Dashboard from '../dashboard/Dashboard';
import Login from '../login/Login';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Switch>
          <Route exact path="/">
            <Login />
          </Route>
          <Route exact path="/dashboard">
            <Dashboard />
          </Route>
          <Route
            exact
            path="/dashboard/asset/:assetId"
            render={(props) => (<AssetInfo assetId={props.match.params.assetId} />)}
          />
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
