import EmployeeDetail from "../pojo/EmployeeDetail";


interface EmployeeProps {
    value?: EmployeeDetail
    onDataChange?: (detail: EmployeeDetail) => void
}

export default EmployeeProps;