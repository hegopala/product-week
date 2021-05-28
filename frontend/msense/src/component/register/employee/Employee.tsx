import { FormControl, Input, InputLabel } from '@material-ui/core';
import React from "react";
import validator from 'validator';
import FormSlideProps from "../../../model/FormSlideProp";

const Employee: React.FC<FormSlideProps> = (props) => {
    const employeeDetails: { [key: string]: string } = {};
    const onInputChange = (event: (React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>)) => {
        employeeDetails[event.target.id] = event.target.value;
        props.onDataValidationStateChange?.(isEmployeeDetailValid(employeeDetails));
        props.onDataChange?.(employeeDetails);
    }

    const isEmployeeDetailValid = (employeeDetail: { [key: string]: string; }) => {
        if (!employeeDetail["employee-id"] || !validator.isNumeric(employeeDetail["employee-id"])) {
            // Employee ID non existent or not numeric
            return false;
        }

        if (!employeeDetail["employee-email"] || !validator.isEmail(employeeDetail["employee-email"])) {
            // Employee email non existent or not proper email
            return false;
        }

        if (!employeeDetail["employee-contact"] || employeeDetail["employee-contact"].length !== 10 || !validator.isNumeric(employeeDetail["employee-contact"])) {
            // Employee contact non existent or not contains 10 nums or non numeric
            return false;
        }
        return true;
    }

    return (
        <div className="register-slide">
            <h3>Employee Details</h3>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="employee-id">ID</InputLabel>
                <Input value={props.value ? props.value["employee-id"] : ""} onChange={event => onInputChange(event)} id="employee-id" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="employee-email">Email</InputLabel>
                <Input value={props.value ? props.value["employee-email"] : ""} onChange={event => onInputChange(event)} id="employee-email" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="employee-contact">Contact number</InputLabel>
                <Input value={props.value ? props.value["employee-contact"] : ""} onChange={event => onInputChange(event)} id="employee-contact" type="text" autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default Employee;