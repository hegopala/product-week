import { FormControl, Input, InputLabel } from '@material-ui/core';
import React from 'react';
import PasswordDetail from '../../../model/PasswordDetail';
import FormSlideProps from '../../../model/props/FormSlideProp';

const Password: React.FC<FormSlideProps> = (props) => {
    const passwordDetails = props.value ? props.value as PasswordDetail : new PasswordDetail();

    const [isMainPasswordFieldDirty, setMainPasswordFieldDirty] = React.useState(false);
    const [isConfirmPasswordFieldDirty, setReenterPasswordFieldDirty] = React.useState(false);

    const setFormDirtyness = (property: string) => (property.match("main") && setMainPasswordFieldDirty(true)) || (property.match("confirm") && setReenterPasswordFieldDirty(true));

    const onInputChange = (event: (React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>)) => {
        setFormDirtyness(event.target.id);
        passwordDetails.set(event.target.id, event.target.value);
        props.onDataChange?.(passwordDetails.clone());
    }

    return (
        <div className="register-slide">
            <h3>User Password</h3>
            <FormControl fullWidth={true} required={true} error={isMainPasswordFieldDirty && !passwordDetails.isMainValid()} >
                <InputLabel htmlFor="password-main">Password</InputLabel>
                <Input value={passwordDetails.getMain()} onChange={event => onInputChange(event)} id="password-main" type="password" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true} error={isConfirmPasswordFieldDirty && (passwordDetails.getConfirm().length === 0)} >
                <InputLabel htmlFor="password-confirm">Confirm password</InputLabel>
                <Input value={passwordDetails.getConfirm()} onChange={event => onInputChange(event)} id="password-confirm" type="password" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} style={{ visibility: "hidden" }}>
                <InputLabel htmlFor="security-hidden">Hidden</InputLabel>
                <Input id="security-hidden" type="text" disabled autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default Password;