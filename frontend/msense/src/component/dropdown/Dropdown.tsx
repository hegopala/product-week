import React from 'react';
import DropdownProps from '../../model/DropdownProp';

import './dropdown.css';
import DownArrowImage from './../../assets/svg/down-arrow.svg';
import CustomString from '../../model/CustomString';

const Dropdown: React.FC<DropdownProps> = (props) => {

    const [isOptionsVisible, setOptionsVisible] = React.useState<boolean>(false);
    const [selectedOption, setSelectedOption] = React.useState<CustomString | undefined>(props.name);

    const toggleOptions = () => {
        setOptionsVisible(!isOptionsVisible);
    }

    const optionsClickHandler = (option?: CustomString) => {
        setSelectedOption(option);
        toggleOptions();
    }

    return (
        <div className="dropdown-container">
            <div onClick={toggleOptions} className="dropdown-button">
                <span>{selectedOption?.toString()}</span>
                <img src={DownArrowImage} width="10px" alt="Dropdown arrow" />
            </div>
            <div className={isOptionsVisible ? "dropdown-options dropdown-show" : "dropdown-options dropdown-hide"}>
                {props.options?.map(
                    (option) => (
                        <div className="dropdown-options-item" key={option.toString()}>
                            <p onClick={() => optionsClickHandler(option)}>{option.toString()}</p>
                            <div className="dropdown-options-divider"></div>
                        </div>
                    )
                )
                }
            </div>
        </div>
    );
}

export default Dropdown;