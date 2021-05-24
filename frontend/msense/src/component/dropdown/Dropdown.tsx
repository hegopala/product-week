import React from 'react';
import DropdownProps from '../../model/DropdownProp';

import './dropdown.css';
import DownArrowImage from './../../assets/svg/down-arrow.svg';

const Dropdown: React.FC<DropdownProps> = (props) => {

    const [isOptionsVisible, setOptionsVisible] = React.useState<boolean>(false);
    const [selectedOption, setSelectedOption] = React.useState<string | undefined>(props.name);

    const toggleOptions = () => {
        setOptionsVisible(!isOptionsVisible);
    }

    const optionsClickHandler = (option?:string) => {
        setSelectedOption(option);
        toggleOptions();
    }

    return (
        <div className="dropdown-container">
            <div onClick={toggleOptions} className="dropdown-button">
                <span>{selectedOption}</span>
                <img src={DownArrowImage} width="10px" className="dropdown-arrow" alt="Dropdown arrow" />
            </div>
            <div className={isOptionsVisible ? "dropdown-options show" : "dropdown-options hide"}>
                {props.options?.map((option) => (<p onClick={() => optionsClickHandler(option)}>{option}</p>))}
            </div>
        </div>
    );
}

export default Dropdown;