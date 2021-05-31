import AssetListItemProps from "../../model/props/AssetListItemProp";
import './assetlistitem.css'
import MachineImage from './../../assets/svg/machine.svg';
import { Link } from "react-router-dom";

const AssetListItem: React.FC<AssetListItemProps> = (props) => {
    const asset = props.data;
    
    return (
        <Link to={`/asset/${asset?.getId()}`} className="no-text-decoration">
            <div className={getClassNameList(asset?.getHealth())}>
                <img src={MachineImage} width="50px" alt="Asset" />
                <span>{asset?.toString()}</span>
            </div>
        </Link>
    );
}

const getClassNameList = (health?: number) => {
    if (health === undefined || health < 0) {
        // health is bad 
        return "assetlistitem-container assethealth-bad-background";
    } else if (health === 0) {
        // health is moderate
        return "assetlistitem-container assethealth-moderate-background";
    }
    // health is good
    return "assetlistitem-container assethealth-good-background";
}

export default AssetListItem;