import NotificationProps from "../../model/NotificationProp";
import { randomIntFromInterval } from "../../util/NumUtils";
import Dropdown from "../dropdown/Dropdown";
import NotificationItem from "../notificationitem/NotificationItem";
import './notificationpane.css';

const NotificationPane: React.FC<NotificationProps> = (props) => {
    const notifications = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];

    return (
        <div className={props.visible ? "notification-pane notification-pane-translate-show" : "notification-pane notification-pane-translate-hide"}>
            <h2 style={{ fontFamily: "'Roboto', 'sans-serif'" }}>Notifications</h2>
            <div className="notification-pane-priority-filter-container">
                <Dropdown name="Select priority" options={["Bad", "Moderate", "Good"]} />
            </div>
            <div className="notification-list-container">
                {notifications
                    .map(
                        (notification => (
                            <NotificationItem
                                key={notification}
                                text={`${notification}`}
                                date={Date.now()}
                                priority={randomIntFromInterval(-1, 1)}
                            />)
                        )
                    )
                }
            </div>
        </div>
    );
}

export default NotificationPane;