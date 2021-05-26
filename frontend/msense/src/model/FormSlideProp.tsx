interface FormSlideProps {
    value?: { [key: string]: string },
    onDataChange?: (detail: { [key: string]: string }) => void
    onDataValidationStateChange?:(valid:boolean) => void
}

export default FormSlideProps;