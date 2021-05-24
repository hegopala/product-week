import { randomIntFromInterval } from "../../util/NumUtils";
import AssetListItem from "../assetlistitem/AssetListItem";
import './assetlist.css';

const AssetList: React.FC = () => {
    const assets = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20];

    return (
        <div className="assetlist">
            {
                assets.map((asset) => (<AssetListItem data={asset} health={randomIntFromInterval(-1, 1)} />))
            }
        </div>
    );
}

export default AssetList;