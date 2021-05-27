import React from 'react';
import AssetList from '../assetlist/AssetList';
import AssetStateInfo from '../assetstateinfo/AssetStateInfo';
import Filter from '../filter/Filter';
import Header from '../header/Header';
import NotificationPane from '../notification/NotificationPane';
import './dashboard.css';


const Dashboard: React.FC = () => {
  const [isNotificationPaneVisible, setNotificationPaneVisiblity] = React.useState(false);

  return (
    <div className="dashboard container">
      <div className="header-container dashboard-item">
        <Header notificationClickAction={() => setNotificationPaneVisiblity(!isNotificationPaneVisible)} />
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
      <div>
        <NotificationPane visible={isNotificationPaneVisible} />
      </div>
    </div>
  );
}

export default Dashboard;