import validator from "validator";
import Cloneable from "./interface/Cloneable";
import Validatable from "./interface/Validatable";

class EmployeeDetail implements Cloneable, Validatable {
    private id: string;
    private email: string;
    private contact: string;

    constructor(id?: string, email?: string, contact?: string) {
        this.id = id || "";
        this.email = email || "";
        this.contact = contact || "";
    }

    getId = () => this.id;
    getEmail = () => this.email;
    getContact = () => this.contact;

    setId = (id: string) => this.id = id;
    setEmail = (email: string) => this.email = email;
    setContact = (contact: string) => this.contact = contact;

    isIdValid = () => validator.isNumeric(this.id);
    isEmailValid = () => validator.isEmail(this.email);
    isContactValid = () => this.contact.length === 10 && validator.isNumeric(this.contact);

    set = (property: string, value: string) => (property.match("id") && this.setId(value)) || (property.match("email") && this.setEmail(value)) || ((property.match("contact")) && this.setContact(value));
    clone = () => (new EmployeeDetail(this.id, this.email, this.contact) as this);
    isValid = () => this.isIdValid() && this.isEmailValid && this.isContactValid();
}

export default EmployeeDetail;