import { numToOrdinalForm } from "../../util/NumUtils";
import CustomObject from "../interface/CustomObject";

class Floor implements CustomObject {
    constructor(private readonly num: number) { }
    clone = () => new Floor(this.num) as this;
    toString = () => `${numToOrdinalForm(this.num)} Floor`;
    getId = () => `${this.num}`;
}

export default Floor;