import AssetListItemProps from "../../model/AssetListItemProp";
import './assetlistitem.css'
import MachineImage from './../../assets/svg/machine.svg';

const AssetListItem: React.FC<AssetListItemProps> = (props) => {

    return (
        <div className={getClassNameList(props.health)}>
            <img src={MachineImage} width="50px" alt="Asset" />
        </div>
    );
}

const getClassNameList = (health?: number) => {
    if (!health || health < 0) {
        // health is bad 
        return "assetlistitem-container bad";
    } else if (health == 0) {
        // health is moderate
        return "assetlistitem-container moderate";
    }
    // health is good
    return "assetlistitem-container good";
}

export default AssetListItem;