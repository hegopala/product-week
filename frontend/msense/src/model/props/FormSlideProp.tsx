import EmployeeDetail from "../pojo/EmployeeDetail";
import FactoryDetail from "../pojo/FactoryDetail";
import PasswordDetail from "../pojo/PasswordDetail";
import SecurityQuestionDetail from "../pojo/SecurityQuestionDetail";


interface FormSlideProps {
    value?: FactoryDetail | EmployeeDetail | SecurityQuestionDetail | PasswordDetail,
    onDataChange?: (detail: (FactoryDetail | EmployeeDetail | SecurityQuestionDetail | PasswordDetail)) => void
}

export default FormSlideProps;