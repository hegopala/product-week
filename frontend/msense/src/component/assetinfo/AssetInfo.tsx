import React from "react";
import AssetInfoProps from "../../model/AssetInfoProp";
import Header from "../header/Header";
import NotificationPane from "../notification/NotificationPane";

const AssetInfo: React.FC<AssetInfoProps> = (props) => {

    const [isHistoryVisible, setHistoryVisibility] = React.useState(false);
    const [isNotificationPaneVisible, setNotificationPaneVisiblity] = React.useState(false);

    const date = new Date();
    date.setDate(17);
    date.setMonth(10);
    date.setFullYear(2019);

    const assetInfo = {
        id: props.assetId,
        name: 'Machine',
        lastUpdatedHealth: 1,
        lastMaintenanceDate: date
    }

    return (
        <div className="assetinfo">
            <div className="header-container dashboard-item">
                <Header notificationClickAction={() => setNotificationPaneVisiblity(!isNotificationPaneVisible)} />
            </div>
            
            <div>
                <NotificationPane visible={isNotificationPaneVisible} />
            </div>
        </div>
    );
}

export default AssetInfo;