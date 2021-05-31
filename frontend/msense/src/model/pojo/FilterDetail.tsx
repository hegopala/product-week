import Department from "./Department";
import Floor from "./Floor";

class FilterDetail {

    constructor(private department?: Department, private floor?: Floor) { }

    getDepartment = () => this.department;
    getFloor = () => this.floor;
    // getAssetType = () => this.assetType;
    // getParameter = () => this.parameter;

    setDepartment = (department?: Department) => this.department = department;
    setFloor = (floor?: Floor) => this.floor = floor;
    // setAssetType = (assetType: string) => this.assetType = assetType;
    // setParameter = (parameter: string) => this.parameter = parameter;
}

export default FilterDetail;