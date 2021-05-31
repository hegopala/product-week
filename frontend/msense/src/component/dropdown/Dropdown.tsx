import React from 'react';
import CustomObject from '../../model/interface/CustomObject';
import DropdownProps from '../../model/props/DropdownProp';
import DownArrowImage from './../../assets/svg/down-arrow.svg';
import './dropdown.css';


const Dropdown: React.FC<DropdownProps> = (props) => {

    const defaultOption: CustomObject = { toString: () => `${props.name}`, getId: () => "-1" };
    const [isOptionsVisible, setOptionsVisible] = React.useState<boolean>(false);
    const [selectedOption, setSelectedOption] = React.useState<CustomObject | undefined>(defaultOption);

    const options = props.options ? [defaultOption, ...props.options] : [defaultOption];

    const toggleOptions = () => {
        setOptionsVisible(!isOptionsVisible);
    }

    const optionsClickHandler = (option?: CustomObject) => {
        if (!option) return
        props.onOptionSelcted?.(option);
        setSelectedOption(option);
        toggleOptions();
    }

    return (
        <div className="dropdown-container">
            <div onClick={toggleOptions} className="dropdown-button">
                <span>{selectedOption?.toString?.()}</span>
                <img src={DownArrowImage} width="10px" alt="Dropdown arrow" />
            </div>
            <div className={isOptionsVisible ? "dropdown-options dropdown-show" : "dropdown-options dropdown-hide"}>
                {options.map(
                    (option) => (
                        <div className="dropdown-options-item" key={option.toString?.()}>
                            <p onClick={() => optionsClickHandler(option)}>{option.toString?.()}</p>
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