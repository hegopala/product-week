import React from "react";
import ReactSpeedometer, { CustomSegmentLabel, CustomSegmentLabelPosition, Transition } from "react-d3-speedometer";
import './assetlivehealthitem.css';

interface AssetLiveHealthProps {
    minValue: number,
    maxValue: number,
    value: number,
    name: string
}


const AssetLiveHealthItem: React.FC<AssetLiveHealthProps> = (props) => {
    const gaugeLabels: CustomSegmentLabel[] = [
        {
            text: "Bad",
            position: CustomSegmentLabelPosition.Outside
        },
        {
            text: "Moderate",
            position: CustomSegmentLabelPosition.Outside
        },
        {
            text: "Good",
            position: CustomSegmentLabelPosition.Outside
        }];

    const range = props.maxValue - props.minValue;
    const part = range / 3;
    const gaugeStops: number[] = [0, part, part * 2, props.maxValue];

    return (
        <div className="assetlivehealthitem-container">
            <h3>{props.name}</h3>
            <div className="assetlivehealthitem-meter-wrapper">
                <ReactSpeedometer
                    needleHeightRatio={0.8}
                    textColor="black"
                    ringWidth={20}
                    minValue={props.minValue}
                    maxValue={props.maxValue}
                    customSegmentLabels={gaugeLabels}
                    customSegmentStops={gaugeStops}
                    value={props.value}
                    needleTransition={Transition.easeElastic}
                    needleTransitionDuration={1500}
                    valueFormat="d"
                    height={200}
                />
            </div>
        </div>
    );
}

export default AssetLiveHealthItem;