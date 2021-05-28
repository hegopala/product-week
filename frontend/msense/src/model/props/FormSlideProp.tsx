import EmployeeDetail from "../EmployeeDetail";
import FactoryDetail from "../FactoryDetail";
import PasswordDetail from "../PasswordDetail";
import SecurityQuestionDetail from "../SecurityQuestionDetail";

interface FormSlideProps {
    value?: FactoryDetail | EmployeeDetail | SecurityQuestionDetail | PasswordDetail,
    onDataChange?: (detail: (FactoryDetail | EmployeeDetail | SecurityQuestionDetail | PasswordDetail)) => void
}

export default FormSlideProps;