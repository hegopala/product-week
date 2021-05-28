import Cloneable from "./interface/Cloneable";
import Validatable from "./interface/Validatable";

class FactoryDetail implements Cloneable, Validatable {
    name: string;
    location: string;
    type: string;

    constructor(name?: string, location?: string, type?: string) {
        this.name = name || "";
        this.location = location || "";
        this.type = type || "";
    }

    getName = () => this.name;
    getLocation = () => this.location;
    getType = () => this.type;

    setName = (name: string) => this.name = name;
    setLocation = (location: string) => this.location = location;
    setType = (type: string) => this.type = type;

    isNameValid = () => this.name.length > 0;
    isLocationValid = () => this.location.length > 0;
    isTypeValid = () => this.type.length > 0;

    set = (property: string, value: string) => (property.match("name") && this.setName(value)) || (property.match("location") && this.setLocation(value)) || ((property.match("type")) && this.setType(value));
    clone = () => (new FactoryDetail(this.name, this.location, this.type) as this);
    isValid = () => this.isNameValid() && this.isLocationValid && this.isTypeValid();


}

export default FactoryDetail;