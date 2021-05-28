import './header.css';
import NotificationImage from './../../assets/svg/notification.svg'; 
import ProfileImage from './../../assets/svg/profile.svg';
import HeaderProps from '../../model/props/HeaderProp';

const Header: React.FC<HeaderProps> = (props) => {
    return (
        <div className="header">
            <img onClick={props.notificationClickAction} src={NotificationImage} className="header-item header-img" alt="Notifications"/>
            <img onClick={props.profileClickAction} src={ProfileImage}  className="header-item header-img" alt="User profile"/>
            <span className="header-item header-text">{props.userName}</span>
        </div>
    );
}

Header.defaultProps = {
    userName: "John Doe"
}

export default Header;