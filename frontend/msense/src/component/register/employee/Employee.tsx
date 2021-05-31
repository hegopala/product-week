import { FormControl, Input, InputLabel } from '@material-ui/core';
import React from "react";
import EmployeeDetail from '../../../model/pojo/EmployeeDetail';
import FormSlideProps from "../../../model/props/FormSlideProp";

const Employee: React.FC<FormSlideProps> = (props) => {
    const employeeDetails = props.value ? props.value as EmployeeDetail : new EmployeeDetail();

    const [isIdFieldDirty, setIdFieldDirty] = React.useState(false);
    const [isEmailFieldDirty, setEmailFieldDirty] = React.useState(false);
    const [isContactFieldDirty, setContactFieldDirty] = React.useState(false);

    const setFormDirtyness = (property: string) => (property.match("id") && setIdFieldDirty(true)) || (property.match("email") && setEmailFieldDirty(true)) || ((property.match("contact")) && setContactFieldDirty(true));

    const onInputChange = (event: (React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>)) => {
        setFormDirtyness(event.target.id);
        employeeDetails.set(event.target.id, event.target.value);
        props.onDataChange?.(employeeDetails.clone());
    }

    return (
        <div className="register-slide">
            <h3>Employee Details</h3>
            <FormControl fullWidth={true} required={true} error={isIdFieldDirty && !employeeDetails.isIdValid()}>
                <InputLabel htmlFor="employee-id">ID</InputLabel>
                <Input value={employeeDetails.getId()} onChange={event => onInputChange(event)} id="employee-id" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true} error={isEmailFieldDirty && !employeeDetails.isEmailValid()}>
                <InputLabel htmlFor="employee-email">Email</InputLabel>
                <Input value={employeeDetails.getEmail()} onChange={event => onInputChange(event)} id="employee-email" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true} error={isContactFieldDirty && !employeeDetails.isContactValid()}>
                <InputLabel htmlFor="employee-contact">Contact number</InputLabel>
                <Input value={employeeDetails.getContact()} onChange={event => onInputChange(event)} id="employee-contact" type="text" autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default Employee;