import AssetInfoBlockProps from '../../model/AssetInfoBlockProp';
import './assetinfoblock.css'
import MachineImage from './../../assets/svg/machine.svg';

const AssetInfoBlock: React.FC<AssetInfoBlockProps> = (props) => {
    return (
        <div className="assetinfoblock-container">
            <img src={MachineImage} width="50px" alt="Asset" />
            <div>
                <p className="assetinfoblock-data">{props.data}</p>
                <p className="assetinfoblock-title">{props.title}</p>
            </div>
        </div>
    );
}

export default AssetInfoBlock;