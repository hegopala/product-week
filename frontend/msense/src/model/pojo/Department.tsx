import CustomObject from "../interface/CustomObject";

class Department implements CustomObject {
    constructor(private readonly department: string, private readonly id: string = "0") { }
    clone = () => new Department(this.department, this.id) as this;
    getId = () => this.id;
    toString = () => this.department;
}

export default Department;