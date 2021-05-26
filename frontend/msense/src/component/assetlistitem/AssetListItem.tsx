import AssetListItemProps from "../../model/AssetListItemProp";
import './assetlistitem.css'
import MachineImage from './../../assets/svg/machine.svg';
import { Link } from "react-router-dom";

const AssetListItem: React.FC<AssetListItemProps> = (props) => {
    return (
        <Link to={`/dashboard/asset/${props.data}`}>
            <div className={getClassNameList(props.health)}>
                <img src={MachineImage} width="50px" alt="Asset" />
            </div>
        </Link>
    );
}

const getClassNameList = (health?: number) => {
    if (health === undefined || health < 0) {
        // health is bad 
        return "assetlistitem-container assetlistitem-bad";
    } else if (health === 0) {
        // health is moderate
        return "assetlistitem-container assetlistitem-moderate";
    }
    // health is good
    return "assetlistitem-container assetlistitem-good";
}

export default AssetListItem;