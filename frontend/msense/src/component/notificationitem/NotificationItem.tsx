import NotificationProps from '../../model/props/NotificationItemProp';
import './notificationitem.css';

const NotificationItem: React.FC<NotificationProps> = (props) => {
    const date = props.date ? new Date(props.date) : new Date();
    return (
        <div className="notification-item">
            <div className="notification-item-date">
                <div className="notification-item-date-day">
                    {date.getDate()}
                </div>
                <div className="notification-item-date-month">
                    {date.toLocaleString('default', { month: 'long' })}
                </div>
            </div>
            <div className="notification-item-divider"></div>
            <div className="notification-item-text">
                <p>Machine number {props.text} requires attention with {props.priority} priority.</p>
            </div>
        </div>
    );
}

export default NotificationItem;