import React from "react";
import AssetInfoProps from "../../model/AssetInfoProp";
import AssetHistory from "../assethistory/AssetHistory";
import AssetInfoItem from "../assetinfoitem/AssetInfoItem";
import AssetLiveHealth from "../assetlivehealth/AssetLiveHealth";
import Header from "../header/Header";
import NotificationPane from "../notification/NotificationPane";

import './assetinfo.css';

const AssetInfo: React.FC<AssetInfoProps> = (props) => {

    const [isHistoryVisible, setHistoryVisibility] = React.useState(false);
    const [isNotificationPaneVisible, setNotificationPaneVisiblity] = React.useState(false);

    const date = new Date();
    date.setDate(17);
    date.setMonth(10);
    date.setFullYear(2019);

    const assetInfo = {
        id: props.assetId,
        name: "Cutting Machine",
        lastUpdatedHealth: "bad",
        lastMaintenanceDate: date
    }

    return (
        <div className="assetinfo container">
            <div className="header-container dashboard-item">
                <Header notificationClickAction={() => setNotificationPaneVisiblity(!isNotificationPaneVisible)} />
            </div>
            <div className="assetinfo-section">
                <h1>{assetInfo.name}</h1>
                <div className="assetinfo-item-wrapper">
                    <AssetInfoItem text="Asset name" data={assetInfo.name} />
                    <AssetInfoItem text="Asset health status" variant="health" data={assetInfo.lastUpdatedHealth} />
                    <AssetInfoItem text="Past record of service" data={assetInfo.lastMaintenanceDate.toDateString()} />
                </div>
            </div>
            <div className="assetinfo-main-choice-container">
                <div className={`assetinfo-main-choice-${isHistoryVisible ? "in" : ""}active`} onClick={() => setHistoryVisibility(false)}>
                    Live
                </div>
                <div className={`assetinfo-main-choice-${isHistoryVisible ? "" : "in"}active`} onClick={() => setHistoryVisibility(true)}>
                    History
                </div>
            </div>
            <div className="assetinfo-main">
                {
                    isHistoryVisible ? (<AssetHistory />) : (<AssetLiveHealth />)
                }
            </div>
            <div>
                <NotificationPane visible={isNotificationPaneVisible} />
            </div>
        </div>
    );
}

export default AssetInfo;