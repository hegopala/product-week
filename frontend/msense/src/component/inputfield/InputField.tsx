import InputFieldProps from "../../model/InputFieldProps";

const InputField: React.FC<InputFieldProps> = (props) => {
    return (
        <div>
            <input type={props.type} placeholder={props.placeholder}/>
        </div>
    );
}
export default InputField;