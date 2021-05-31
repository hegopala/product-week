import { FormControl, Input, InputLabel, NativeSelect } from '@material-ui/core';
import React from "react";
import FormSlideProps from '../../../model/props/FormSlideProp';
import SecurityQuestionDetail from '../../../model/pojo/SecurityQuestionDetail';

const SecurityQuestion: React.FC<FormSlideProps> = (props) => {
    const securityQuestionDetail = props.value ? props.value as SecurityQuestionDetail : new SecurityQuestionDetail();

    const [isQuestionFieldDirty, setQuestionFieldDirty] = React.useState(false);
    const [isAnswerFieldDirty, setAnswerFieldDirty] = React.useState(false);

    const setFormDirtyness = (property: string) => (property.match("question") && setQuestionFieldDirty(true)) || (property.match("answer") && setAnswerFieldDirty(true));

    const onInputChange = (event: (React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement | HTMLSelectElement>)) => {
        setFormDirtyness(event.target.id);
        securityQuestionDetail.set(event.target.id, event.target.value);
        props.onDataChange?.(securityQuestionDetail.clone());
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
            <FormControl fullWidth={true} required={true} error={isQuestionFieldDirty && !securityQuestionDetail.isQuestionValid()}>
                <InputLabel id="security-question-label" htmlFor="security-question">Security question</InputLabel>
                <NativeSelect
                    value={securityQuestionDetail.getQuestion()}
                    onChange={event => onInputChange(event)}
                    id="security-question"
                    input={<Input />}>
                    <option aria-label="None" value="" />
                    {options.map(option => (<option key={option.value} value={option.value}>{option.text}</option>))}
                </NativeSelect>
            </FormControl>
            <FormControl fullWidth={true} required={true} error={isAnswerFieldDirty && !securityQuestionDetail.isAnswerValid()}>
                <InputLabel htmlFor="security-answer">Answer</InputLabel>
                <Input value={securityQuestionDetail.getAnswer()} onChange={event => onInputChange(event)} id="security-answer" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} style={{ visibility: "hidden" }}>
                <InputLabel htmlFor="security-hidden">Hidden</InputLabel>
                <Input id="security-hidden" type="text" disabled autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default SecurityQuestion;