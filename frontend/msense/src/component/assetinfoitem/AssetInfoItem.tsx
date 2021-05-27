import AssetInfoItemProps from '../../model/AssetInfoItemProp';
import './assetinfoitem.css';

const AssetInfoItem: React.FC<AssetInfoItemProps> = (props) => {
    return (
        <div className="assetinfoitem-container">
            <p className="assetinfoitem-item-title">{props.text}</p>
            {
                props.variant === "health" ?
                    (<span
                        className={`assetinfoitem-item-health
                            ${props.data?.toLowerCase() === "good" ?
                                "assethealth-good-text-color" :
                                props.data?.toLowerCase() === "moderate" ?
                                    "assethealth-moderate-text-color" :
                                    "assethealth-bad-text-color"}`}>
                        {props.data}
                    </span>) :
                    (<span className="assetinfoitem-item-data">{props.data}</span>)
            }
        </div>
    );
}

export default AssetInfoItem;