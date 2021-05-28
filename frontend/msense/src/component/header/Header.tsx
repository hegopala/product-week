import { PowerSettingsNew } from '@material-ui/icons';
import HeaderProps from '../../model/props/HeaderProp';
import NotificationImage from './../../assets/svg/notification.svg';
import ProfileImage from './../../assets/svg/profile.svg';
import './header.css';

const Header: React.FC<HeaderProps> = (props) => {
    return (
        <div className="header">
            <img onClick={props.notificationClickAction} src={NotificationImage} className="header-item header-img" alt="Notifications" />
            <img onClick={props.profileClickAction} src={ProfileImage} className="header-item header-img" alt="User profile" />
            <span className="header-item header-text">{props.userName}</span>
            <span  className="clickable" onClick={() => props.onAuthenticationStateChange?.(false)}>
                <PowerSettingsNew />
            </span>
        </div>
    );
}

Header.defaultProps = {
    userName: "John Doe"
}

export default Header;