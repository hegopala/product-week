import { Button, Link as LinkUI } from '@material-ui/core';
import React from 'react';
import { Link } from 'react-router-dom';
import EmployeeDetail from '../../model/pojo/EmployeeDetail';
import FactoryDetail from '../../model/pojo/FactoryDetail';
import PasswordDetail from '../../model/pojo/PasswordDetail';
import AuthStateProps from '../../model/props/AuthStateProp';
import SecurityQuestionDetail from '../../model/pojo/SecurityQuestionDetail';
import Employee from './employee/Employee';
import Factory from './factory/Factory';
import Password from './password/Password';
import './register.css';
import SecurityQuestion from './securityquestion/SecurityQuestion';
import Loader from '../loader/Loader';


const Register: React.FC<AuthStateProps> = (props) => {

    const [factoryDetail, setFactoryDetail] = React.useState<FactoryDetail>();
    const [employeeDetail, setEmployeeDetail] = React.useState<EmployeeDetail>();
    const [securityQuestionDetail, setSecurityQuestionDetail] = React.useState<SecurityQuestionDetail>();
    const [passwordDetail, setPasswordDetail] = React.useState<PasswordDetail>();

    const [visibleSlide, setVisibleSlide] = React.useState(0);
    const [isLoading, setLoading] = React.useState(false);

    const onDetailDataChange = (detail: (FactoryDetail | EmployeeDetail | SecurityQuestionDetail | PasswordDetail)) => ((detail instanceof FactoryDetail) && setFactoryDetail(detail)) || ((detail instanceof EmployeeDetail) && setEmployeeDetail(detail)) || ((detail instanceof SecurityQuestionDetail) && setSecurityQuestionDetail(detail)) || ((detail instanceof PasswordDetail) && setPasswordDetail(detail));

    const slides = [
        <Factory value={factoryDetail} onDataChange={onDetailDataChange} />,
        <Employee value={employeeDetail} onDataChange={onDetailDataChange} />,
        <SecurityQuestion value={securityQuestionDetail} onDataChange={onDetailDataChange} />,
        <Password value={passwordDetail} onDataChange={onDetailDataChange} />
    ];

    const validateCurrentSlide = (): boolean => {
        switch (visibleSlide) {
            case 0: return factoryDetail ? factoryDetail.isValid() : false;
            case 1: return employeeDetail ? employeeDetail.isValid() : false;
            case 2: return securityQuestionDetail ? securityQuestionDetail.isValid() : false;
            case 3: return passwordDetail ? passwordDetail.isValid() : false;
            default: return true;
        }
    }

    const onFormSubmit = (event?: (React.MouseEvent<HTMLAnchorElement, MouseEvent>)) => {
        event?.preventDefault();
        if (!(factoryDetail?.isValid() && employeeDetail?.isIdValid && securityQuestionDetail?.isValid() && passwordDetail?.isValid())) {
            // Information not valid
            return;
        }
        
        setLoading(true);
        setTimeout(() => {
            setLoading(false);
            props.onAuthenticationStateChange?.(true);
        }, 2000);
    }

    const onBackButtonClick = () => visibleSlide > 0 && setVisibleSlide(visibleSlide - 1);
    const onNextButtonClick = () => visibleSlide < slides.length - 1 && validateCurrentSlide() && setVisibleSlide(visibleSlide + 1);

    const isFirstSlide = () => visibleSlide === 0;
    const isLastSlide = () => visibleSlide === slides.length - 1;

    return (
        <div className="register">
            {isLoading ? (<Loader />) : ""}
            <div className="register-form-wrapper">
                <h1 className="product-heading">MSense</h1>
                <div className="register-form">
                    {slides[visibleSlide]}
                    <div className="register-controls">
                        {
                            isFirstSlide() ?
                                (<div><LinkUI href="/login" variant="body2">Login</LinkUI>&nbsp;Instead</div>) :
                                (<Button onClick={() => onBackButtonClick()} variant="outlined" color="secondary" type="button">Back</Button>)
                        }
                        {
                            isLastSlide() ?
                                (<Link to="/dashboard" onClick={onFormSubmit}><Button variant="contained" color="primary" type="button">Submit</Button></Link>) :
                                (<Button onClick={() => onNextButtonClick()} variant="contained" color="primary" type="button">Next</Button>)
                        }
                    </div>
                </div>
            </div>
        </div >
    );
}

export default Register;