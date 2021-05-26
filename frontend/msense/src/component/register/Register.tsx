import { Button, FormControl, Input, InputLabel, NativeSelect, Link as LinkUI } from '@material-ui/core';
import React from 'react';
import './register.css';

const Register: React.FC = () => {

    const slides = [getFactorySlide(), getEmployeeSlide(), getSecurityQuestionSlide(), getPasswordSlide()];
    const [visibleSlide, setVisibleSlide] = React.useState(0);

    const onBackButtonClick = () => {
        if (visibleSlide > 0) {
            setVisibleSlide(visibleSlide - 1);
        }
    }

    const onNextButtonClick = () => {
        if (visibleSlide < slides.length - 1) {
            setVisibleSlide(visibleSlide + 1);
        }
    }

    const isFirstSlide = () => visibleSlide === 0;
    const isLastSlide = () => visibleSlide === slides.length - 1;

    return (
        <div className="register">
            <div className="register-form-wrapper">
                <h1 className="product-heading">MSense</h1>
                <form action="/dashboard" className="register-form">
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

const getSecurityQuestionSlide = () => {

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
                    id="security-question"
                    input={<Input />}>
                    <option aria-label="None" value="" />
                    {options.map(option => (<option key={option.value} value={option.value}>{option.text}</option>))}
                </NativeSelect>
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="security-answer">Answer</InputLabel>
                <Input id="security-answer" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} style={{ visibility: "hidden" }}>
                <InputLabel htmlFor="security-hidden">Hidden</InputLabel>
                <Input id="security-hidden" type="text" disabled autoComplete="off" />
            </FormControl>
        </div>
    );
}

const getEmployeeSlide = () => {
    return (
        <div className="register-slide">
            <h3>Employee Details</h3>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="employee-id">ID</InputLabel>
                <Input id="employee-id" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="employee-email">Email</InputLabel>
                <Input id="employee-email" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="employee-contact">Contact number</InputLabel>
                <Input id="employee-contact" type="text" autoComplete="off" />
            </FormControl>
        </div>
    );
}

const getFactorySlide = () => {
    return (
        <div className="register-slide">
            <h3>Factory Details</h3>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="factory-name">Name</InputLabel>
                <Input id="factory-name" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="factory-location">Location</InputLabel>
                <Input id="factory-location" type="text" autoComplete="off" />
            </FormControl>
            <FormControl fullWidth={true} required={true}>
                <InputLabel htmlFor="factory-type">Industry type</InputLabel>
                <Input id="factory-type" type="text" autoComplete="off" />
            </FormControl>
        </div>
    );
}

export default Register;