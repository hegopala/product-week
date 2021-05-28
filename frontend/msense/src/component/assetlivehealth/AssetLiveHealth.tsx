import React from "react";
import { randomIntFromInterval } from "../../util/NumUtils";
import AssetLiveHealthItem from "./assetlivehealthitem/AssetLiveHealthItem";
import "./assetlivehealth.css";


const AssetLiveHealth: React.FC = (props) => {

    const timeInterval = 2000;
    const minValue = 0;
    const maxValue = 100;

    const [value, setValue] = React.useState(0);
    const [isConstructed, setConstructed] = React.useState(false);

    const generateUpdatedValue = async () => {
        const num = randomIntFromInterval(minValue, maxValue);
        setValue(num);
        setTimeout(generateUpdatedValue, timeInterval);
    }

    if (!isConstructed) {
        setTimeout(generateUpdatedValue, timeInterval);
        setConstructed(true);
    }

    return (
        <div className="assetlivehealth-container">
            <div className="assetlivehealth-container-row">
                <div>
                    <AssetLiveHealthItem value={value} maxValue={maxValue} minValue={minValue} name="Velocity" />
                </div>
                <div>
                    <AssetLiveHealthItem value={value} maxValue={maxValue} minValue={minValue} name="Pressure" />
                </div>
            </div>
            <div className="assetlivehealth-container-row">
                <div>
                    <AssetLiveHealthItem value={value} maxValue={maxValue} minValue={minValue} name="Temperatue" />
                </div>
                <div>
                    <AssetLiveHealthItem value={value} maxValue={maxValue} minValue={minValue} name="Acceleration" />
                </div>
            </div>
        </div >
    );
}

export default AssetLiveHealth;