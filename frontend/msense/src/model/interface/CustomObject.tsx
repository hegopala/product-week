interface CustomObject {
    clone?: () => this,
    toString?: () => string,
    getId?: () => string
}

export default CustomObject;