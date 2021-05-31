import FactoryDetail from "../pojo/FactoryDetail";

interface FactoryProps {
    value?: FactoryDetail
    onDataChange?: (detail: FactoryDetail) => void
    onDataValidationStateChange?: (valid: boolean) => void
}

export default FactoryProps;