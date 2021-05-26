import React from "react";
import InputFieldProps from "../../model/InputFieldProps";

const InputField: React.FC<InputFieldProps> = (props) => {
    const onInputChange = (event: React.FormEvent<HTMLInputElement>) => {
        const val = (event.target as HTMLInputElement).value;
        if (props.onInputChange) {
            props.onInputChange(val);
        }
    }
    return (
        <div>
            <input value={props.value} onInput={event => onInputChange(event)} type={props.type} placeholder={props.placeholder} />
        </div>
    );
}
export default InputField;