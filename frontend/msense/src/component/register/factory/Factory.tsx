import { FormControl, Input, InputLabel } from '@material-ui/core';
import React from "react";
import FormSlideProps from '../../../model/FormSlideProp';

const Factory: React.FC<FormSlideProps> = (props) => {
    const factoryDetails: { [key: string]: string } = {};

    const onInputChange = (event: (React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>)) => {
        factoryDetails[event.target.id] = event.target.value;
        props.onDataValidationStateChange?.(isFactoryDetailValid(factoryDetails));
        props.onDataChange?.(factoryDetails);
    }

    const isFactoryDetailValid = (factoryDetail: { [key: string]: string; }) => {
        if (!factoryDetail["factory-name"] || (factoryDetail["factory-name"].length === 0)) {
            return false;
        }

        if (!factoryDetail["factory-location"] || (factoryDetail["factory-location"].length === 0)) {
            return false;
        }

        if (!factoryDetail["factory-type"] || (factoryDetail["factory-type"].length === 0)) {
            return false;
        }

        return true;
    }

    return (
        <div className="register-slide">
            <h3>Factory Details</h3>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="factory-name">Name</InputLabel>
                <Input value={props.value ? props.value["factory-name"] : ""} onChange={event => onInputChange(event)} id="factory-name" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="factory-location">Location</InputLabel>
                <Input value={props.value ? props.value["factory-location"] : ""} onChange={event => onInputChange(event)} id="factory-location" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="factory-type">Industry type</InputLabel>
                <Input value={props.value ? props.value["factory-type"] : ""} onChange={event => onInputChange(event)} id="factory-type" type="text" autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default Factory;