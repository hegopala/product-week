
import Asset from '../../model/pojo/Asset';
import AssetInfoBlock from '../assetinfoblock/AssetInfoBlock';
import './assetstateinfo.css';

const AssetStateInfo: React.FC<{ assets: Asset[] }> = (props) => {
    const assets = props.assets;

    const totalAssets = assets.length;
    let goodHealthAssetCount = 0;
    assets.forEach((asset) => asset.getHealth() >= 0 && goodHealthAssetCount++)
    const badHealthAssetCount = totalAssets - goodHealthAssetCount;

    return (
        <div className="assetstateinfo">
            <div className="assetstateinfo-item">
                <AssetInfoBlock data={`${totalAssets}`} title="No. of total assets" />
            </div>
            <div className="assetstateinfo-item">
                <AssetInfoBlock data={`${goodHealthAssetCount}`} title="Assets are working fine." />
            </div>
            <div className="assetstateinfo-item">
                <AssetInfoBlock data={`${badHealthAssetCount}`} title="Assets required immediate attention." />
            </div>
        </div>
    );
}

export default AssetStateInfo;