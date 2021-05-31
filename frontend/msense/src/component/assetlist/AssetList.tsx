import Asset from "../../model/pojo/Asset";
import AssetListItem from "../assetlistitem/AssetListItem";
import './assetlist.css';

const AssetList: React.FC<{assets: Asset[]}> = (props) => {
    const assets = props.assets;

    return (
        <div className="assetlist-container">
            <h3 className="assetlist-heading">Asset List</h3>
            <div className="assetlist">
                {
                    assets.map((asset) => (<AssetListItem key={asset.getId()} data={asset}/>))
                }
            </div>
        </div>
    );
}

export default AssetList;