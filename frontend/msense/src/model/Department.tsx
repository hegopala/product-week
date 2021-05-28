import CustomString from "./interface/CustomString";

class Department implements CustomString {
    toString = () => this.department;
    constructor(private readonly department: string) { }
}

export default Department;