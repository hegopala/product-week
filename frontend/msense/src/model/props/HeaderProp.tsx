import AuthStateProps from "./AuthStateProp";

interface HeaderProps extends AuthStateProps {
    notificationClickAction?: () => void,
    profileClickAction?: () => void,
    userName?: string
}

export default HeaderProps;