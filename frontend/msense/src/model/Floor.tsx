import { numToOrdinalForm } from "../util/NumUtils";
import CustomString from "./interface/CustomString";

class Floor implements CustomString{
    toString = () => `${numToOrdinalForm(this.num)} Floor`;
    constructor(private readonly num: number) { }
}

export default Floor;