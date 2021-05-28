import EmployeeDetail from "../EmployeeDetail";
import FactoryDetail from "../FactoryDetail";

interface EmployeeProps {
    value?: EmployeeDetail
    onDataChange?: (detail: EmployeeDetail) => void
}

export default EmployeeProps;