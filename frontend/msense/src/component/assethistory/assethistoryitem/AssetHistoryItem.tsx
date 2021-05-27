import { FormControl, Input, InputLabel, NativeSelect } from "@material-ui/core";
import { ArrowDropDown } from "@material-ui/icons";
import React from "react";
import { LineChart, XAxis, YAxis, CartesianGrid, Line, Tooltip, ResponsiveContainer } from "recharts";
import "./assethistoryitem.css";

interface AssetHistoryItemProps {
    name?: string
}

const AssetHistoryItem: React.FC<AssetHistoryItemProps> = (props) => {

    const [selectedTimeFrame, setSelectedTimeFrame] = React.useState("");
    const onTimeFrameChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectedTimeFrame(event.target.value);
    }

    const timeOptions = [
        { text: "Day", value: "day" },
        { text: "Week", value: "week" },
        { text: "Month", value: "month" }];

    const data = [
        { name: 'Page A', uv: 400, pv: 2400, amt: 2400 },
        { name: 'Page B', uv: 500, pv: 2400, amt: 1600 },
        { name: 'Page C', uv: 450, pv: 2400, amt: 1000 },
        { name: 'Page D', uv: 300, pv: 2400, amt: 1500 },
    ];
    return (
        <div className="assethistory-item-container">
            <div>
                <span className="assethistoryitem-name">{props.name}</span>
                <FormControl style={{ width: "100px" }}>
                    <NativeSelect
                        value={selectedTimeFrame}
                        onChange={event => onTimeFrameChange(event)}
                        id="time-frame-selector"
                        input={<Input />}>
                        {timeOptions.map(option => (<option key={option.value} value={option.value}>{option.text}</option>))}
                    </NativeSelect>
                </FormControl>
            </div>
            <ResponsiveContainer width="99.9%" height={300}>
                <LineChart data={data} margin={{ top: 5, right: 20, bottom: 5, left: 0 }}>
                    <Line type="monotone" dataKey="uv" stroke="#8884d8" />
                    <XAxis dataKey="name" />
                    <YAxis dataKey="uv" />
                    <Tooltip />
                </LineChart>
            </ResponsiveContainer>
        </div>
    );
}

export default AssetHistoryItem;