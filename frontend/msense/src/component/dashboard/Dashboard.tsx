import React from 'react';
import AssetList from '../assetlist/AssetList';
import AssetStateInfo from '../assetstateinfo/AssetStateInfo';
import Filter from '../filter/Filter';
import Header from '../header/Header';

import './dashboard.css';

const Dashboard: React.FC = () => {
  return (
    <div className="dashboard">
      <div className="header-container dashboard-item">
        <Header />
      </div>
      <div className="filter-container dashboard-item">
        <Filter />
      </div>
      <div className="assetstateinfo-container dashboard-item">
        <AssetStateInfo />
      </div>
      <div className="assetlist-container dashboard-item">
        <AssetList />
      </div>
    </div>
  );
}

export default Dashboard;