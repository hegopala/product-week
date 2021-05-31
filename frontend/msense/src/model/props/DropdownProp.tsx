import CustomObject from "../interface/CustomObject";


interface DropdownProps {
    name?: string,
    options?: Array<CustomObject>
    value?: CustomObject,
    onOptionSelcted?: (option: CustomObject) => void
}

export default DropdownProps;