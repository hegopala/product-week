import { FormControl, Input, InputLabel } from '@material-ui/core';
import React from 'react';
import FactoryDetail from '../../../model/FactoryDetail';
import FormSlideProps from '../../../model/props/FormSlideProp';

const Factory: React.FC<FormSlideProps> = (props) => {
    const factoryDetails = props.value ? props.value as FactoryDetail : new FactoryDetail();

    const [isNameFieldDirty, setNameFieldDirty] = React.useState(false);
    const [isLocationFieldDirty, setLocationFieldDirty] = React.useState(false);
    const [isTypeFieldDirty, setTypeFieldDirty] = React.useState(false);

    const setFormDirtyness = (property: string) => (property.match("name") && setNameFieldDirty(true)) || (property.match("location") && setLocationFieldDirty(true)) || ((property.match("type")) && setTypeFieldDirty(true));

    const onInputChange = (event: (React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>)) => {
        setFormDirtyness(event.target.id);
        factoryDetails.set(event.target.id, event.target.value);
        props.onDataChange?.(factoryDetails.clone());
    }

    return (
        <div className="register-slide">
            <h3>Factory Details</h3>
            <FormControl fullWidth={true} required={true} error={isNameFieldDirty && !factoryDetails.isNameValid()} >
                <InputLabel htmlFor="factory-name">Name</InputLabel>
                <Input value={factoryDetails.getName()} onChange={event => onInputChange(event)} id="factory-name" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true} error={isLocationFieldDirty && !factoryDetails.isLocationValid()}>
                <InputLabel htmlFor="factory-location">Location</InputLabel>
                <Input value={factoryDetails.getLocation()} onChange={event => onInputChange(event)} id="factory-location" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true} error={isTypeFieldDirty && !factoryDetails.isTypeValid()}>
                <InputLabel htmlFor="factory-type">Industry type</InputLabel>
                <Input value={factoryDetails.getType()} onChange={event => onInputChange(event)} id="factory-type" type="text" autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default Factory;