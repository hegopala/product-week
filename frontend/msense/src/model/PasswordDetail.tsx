import Cloneable from "./interface/Cloneable";
import Validatable from "./interface/Validatable";

class PasswordDetail implements Cloneable, Validatable {
    main: string;
    confirm: string;

    constructor(main?: string, confirm?: string) {
        this.main = main || "";
        this.confirm = confirm || "";
    }

    getMain = () => this.main;
    getConfirm = () => this.confirm;

    setMain = (main: string) => this.main = main;
    setConfirm = (confirm: string) => this.confirm = confirm;


    isMainValid = () => this.main.length > 0;
    isConfirmValid = () => this.confirm === this.main;

    set = (property: string, value: string) => (property.match("main") && this.setMain(value)) || (property.match("confirm") && this.setConfirm(value));
    clone = () => (new PasswordDetail(this.main, this.confirm) as this);
    isValid = () => this.isMainValid() && this.isConfirmValid();
}

export default PasswordDetail;