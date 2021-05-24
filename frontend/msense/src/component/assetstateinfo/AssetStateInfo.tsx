
import AssetInfoBlock from '../assetinfoblock/AssetInfoBlock';
import './assetstateinfo.css';

const AssetStateInfo: React.FC = () => {
    return (
        <div className="assetstateinfo">
            <div className="assetstateinfo-item">
                <AssetInfoBlock data="20" title="No. of Total Assets" />
            </div>
            <div className="assetstateinfo-item">
                <AssetInfoBlock data="14" title="Assets are working fine." />
            </div>
            <div className="assetstateinfo-item">
                <AssetInfoBlock data="6" title="Assets required immediate attention." />
            </div>
        </div>
    );
}

export default AssetStateInfo;