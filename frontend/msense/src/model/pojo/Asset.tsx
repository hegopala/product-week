import CustomObject from "../interface/CustomObject";
import * as NumUtils from "../../util/NumUtils";

class Asset implements CustomObject {
    private readonly health;

    constructor(private readonly id?: string, private readonly name?: string) {
        this.health = NumUtils.randomIntFromInterval(-1, 1);
    }

    toString = () => `${this.name}`;
    getHealth = () => this.health;
    getId = () => `${this.id}`;
}

export default Asset;