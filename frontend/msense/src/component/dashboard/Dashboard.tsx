import React from 'react';
import Asset from '../../model/pojo/Asset';
import AuthStateProps from '../../model/props/AuthStateProp';
import AssetList from '../assetlist/AssetList';
import AssetStateInfo from '../assetstateinfo/AssetStateInfo';
import Filter from '../filter/Filter';
import Header from '../header/Header';
import Loader from '../loader/Loader';
import NotificationPane from '../notification/NotificationPane';
import './dashboard.css';
import * as NumUtils from "./../../util/NumUtils";
import FilterDetail from '../../model/pojo/FilterDetail';


const Dashboard: React.FC<AuthStateProps> = (props) => {
  const [isNotificationPaneVisible, setNotificationPaneVisiblity] = React.useState(false);
  const [isLoading, setLoading] = React.useState(false);
  const [assets, setAssets] = React.useState<Asset[]>([]);

  const onFilterChange = (detail: FilterDetail) => {
    setLoading(true);
    // call api to get filtered data
    const tempAssets: Asset[] = [];
    for (let i = 1; i <= NumUtils.randomIntFromInterval(20, 25); i++)
      tempAssets.push(new Asset(`${i}`, `Asset ${i}`));
    setTimeout(() => {
      setLoading(false);
      setAssets(tempAssets);
    }, 2000);
  }

  return (
    <div className="dashboard container">
      {isLoading ? (<Loader />) : ""}
      <div className="header-container dashboard-item">
        <Header onAuthenticationStateChange={props.onAuthenticationStateChange} notificationClickAction={() => setNotificationPaneVisiblity(!isNotificationPaneVisible)} />
      </div>
      <div className="filter-container dashboard-item">
        <Filter onFilterChange={onFilterChange} />
      </div>
      <div className="assetstateinfo-container dashboard-item">
        <AssetStateInfo assets={assets} />
      </div>
      <div className="assetlist-container dashboard-item">
        <AssetList assets={assets} />
      </div>
      <div>
        <NotificationPane visible={isNotificationPaneVisible} />
      </div>
    </div>
  );
}

export default Dashboard;