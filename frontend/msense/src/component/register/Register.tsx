import { Button, FormControl, Input, InputLabel, Link as LinkUI } from '@material-ui/core';
import React from 'react';
import Employee from './employee/Employee';
import Factory from './factory/Factory';
import './register.css';
import SecurityQuestion from './securityquestion/SecurityQuestion';

const Register: React.FC = () => {

    let factoryDetail: { [key: string]: string } = {};
    let employeeDetail: { [key: string]: string } = {};
    let securityQuestionDetail: { [key: string]: string } = {};

    let isFactoryDetailValid = false;
    let isEmployeeDetailValid = false;
    let isSecurityQuestionDetailValid = false;

    const onFactoryDetailChange = (detail: { [key: string]: string }) => factoryDetail = detail;
    const onEmployeeDetailChange = (detail: { [key: string]: string }) => employeeDetail = detail;
    const onSecurityQuestionDetailChange = (detail: { [key: string]: string }) => securityQuestionDetail = detail;

    const onFactoryDatailValidationStateChange = (valid: boolean) => isFactoryDetailValid = valid;
    const onEmployeeyDatailValidationStateChange = (valid: boolean) => isEmployeeDetailValid = valid;
    const onSecurityQuestionDatailValidationStateChange = (valid: boolean) => isSecurityQuestionDetailValid = valid;

    const slides = [
        <Factory value={factoryDetail} onDataChange={onFactoryDetailChange} onDataValidationStateChange={onFactoryDatailValidationStateChange} />,
        <Employee value={employeeDetail} onDataChange={onEmployeeDetailChange} onDataValidationStateChange={onEmployeeyDatailValidationStateChange} />,
        <SecurityQuestion value={securityQuestionDetail} onDataChange={onSecurityQuestionDetailChange} onDataValidationStateChange={onSecurityQuestionDatailValidationStateChange} />,
        getPasswordSlide()
    ];

    const [visibleSlide, setVisibleSlide] = React.useState(0);

    const validateCurrentSlide = () => {
        switch (visibleSlide) {
            case 0: return isFactoryDetailValid;
            case 1: return isEmployeeDetailValid;
            case 2: return isSecurityQuestionDetailValid;
            default: return true;
        }
    }

    const onFormSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        console.log(factoryDetail, employeeDetail, securityQuestionDetail);
        if(!(isEmployeeDetailValid && isFactoryDetailValid && isSecurityQuestionDetailValid)) {
            event.preventDefault();
        }
    }

    const onBackButtonClick = () => visibleSlide > 0 && setVisibleSlide(visibleSlide - 1);
    const onNextButtonClick = () => visibleSlide < slides.length - 1 && validateCurrentSlide() && setVisibleSlide(visibleSlide + 1);
    const isFirstSlide = () => visibleSlide === 0;
    const isLastSlide = () => visibleSlide === slides.length - 1;

    return (
        <div className="register">
            <div className="register-form-wrapper">
                <h1 className="product-heading">MSense</h1>
                <form action="/dashboard" className="register-form" onSubmit={event => onFormSubmit(event)}>
                    {slides[visibleSlide]}
                    <div className="register-controls">
                        {
                            isFirstSlide() ?
                                (<div><LinkUI href="/login" variant="body2">Login</LinkUI>&nbsp;Instead</div>) :
                                (<Button onClick={() => onBackButtonClick()} variant="outlined" color="secondary" type="button">Back</Button>)
                        }
                        {
                            isLastSlide() ?
                                (<Button onClick={() => onNextButtonClick()} variant="contained" color="primary" type="submit">Submit</Button>) :
                                (<Button onClick={() => onNextButtonClick()} variant="contained" color="primary" type="button">Next</Button>)
                        }
                    </div>
                </form>
            </div>
        </div >
    );
}

const getPasswordSlide = () => {
    return (
        <div className="register-slide">
            <h3>User Password</h3>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="password-main">Password</InputLabel>
                <Input id="password-main" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="password-reenter">Re-enter password</InputLabel>
                <Input id="password-reenter" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} style={{ visibility: "hidden" }}>
                <InputLabel htmlFor="security-hidden">Hidden</InputLabel>
                <Input id="security-hidden" type="text" disabled autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default Register;