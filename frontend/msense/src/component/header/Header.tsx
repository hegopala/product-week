import './header.css';
import NotificationImage from './../../assets/svg/notification.svg'; 
import ProfileImage from './../../assets/svg/profile.svg';

const Header: React.FC = () => {

    let userName = "John Doe";

    return (
        <div className="header">
            <img src={NotificationImage} className="header-item header-img" alt="Notifications"/>
            <img src={ProfileImage}  className="header-item header-img" alt="User profile"/>
            <span className="header-item header-text">{userName}</span>
        </div>
    );
}

export default Header;