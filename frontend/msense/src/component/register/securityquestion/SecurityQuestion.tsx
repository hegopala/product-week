import { FormControl, Input, InputLabel, NativeSelect } from '@material-ui/core';
import React from "react";
import FormSlideProps from '../../../model/FormSlideProp';

const SecurityQuestion: React.FC<FormSlideProps> = (props) => {
    const securityQuestionDetail: { [key: string]: string } = {};

    const onInputChange = (event: (React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement | HTMLSelectElement>)) => {
        securityQuestionDetail[event.target.id] = event.target.value;
        props.onDataValidationStateChange?.(validateSecurityQuestionDetail(securityQuestionDetail));
        props.onDataChange?.(securityQuestionDetail);
    }

    const validateSecurityQuestionDetail = (detail:{ [key: string]: string }) => {
        return true;
    }

    const options = [{
        text: "My birth place ?",
        value: "birth-place"
    }, {
        text: "My first school name ?",
        value: "first-school-name"
    }];

    return (
        <div className="register-slide">
            <h3>Security Question</h3>
            <FormControl fullWidth={true} required={true}>
                <InputLabel id="security-question-label" htmlFor="security-question">Security question</InputLabel>
                <NativeSelect
                    value={props.value ? props.value["security-question"] : ""}
                    onChange={event => onInputChange(event)}
                    id="security-question"
                    input={<Input />}>
                    <option aria-label="None" value="" />
                    {options.map(option => (<option key={option.value} value={option.value}>{option.text}</option>))}
                </NativeSelect>
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="security-answer">Answer</InputLabel>
                <Input value={props.value ? props.value["security-answer"] : ""} onChange={event => onInputChange(event)} id="security-answer" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} style={{ visibility: "hidden" }}>
                <InputLabel htmlFor="security-hidden">Hidden</InputLabel>
                <Input id="security-hidden" type="text" disabled autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default SecurityQuestion;