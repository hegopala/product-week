import React from "react";
import AssetHistoryItem from "./assethistoryitem/AssetHistoryItem";
import "./assethistory.css";

const AssetHistory: React.FC = () => {
    return (
        <div className="assethistory-container">
            <div>
                <AssetHistoryItem name="Velocity" />
            </div>
            <div>
                <AssetHistoryItem name="Pressure" />
            </div>
            <div>
                <AssetHistoryItem name="Temperature" />
            </div>
            <div>
                <AssetHistoryItem name="Acceleration" />
            </div>
        </div>
    );
}

export default AssetHistory;