import { Button } from '@material-ui/core';
import { SendOutlined } from '@material-ui/icons';
import React from 'react';

import CustomObject from '../../model/interface/CustomObject';
import Department from '../../model/pojo/Department';
import FilterDetail from '../../model/pojo/FilterDetail';
import Floor from '../../model/pojo/Floor';
import FilterProps from '../../model/props/FilterProps';
import Dropdown from '../dropdown/Dropdown';
import './filter.css';

const Filter: React.FC<FilterProps> = (props) => {
    const filter = new FilterDetail();

    const onDepartmentSelect = (option: CustomObject) => filter.setDepartment(option as Department);
    const onFloorSelect = (option: CustomObject) => filter.setFloor(option as Floor);

    const onAssetTypeSelect = (assetType: CustomObject) => {
        console.log(assetType);
    }

    const onParameterSelect = (parameter: CustomObject) => {
        console.log(parameter);
    }

    const goFilter = () => props.onFilterChange?.(filter);


    const floors: Floor[] = [];
    for (let i = 1; i <= 15; i++) {
        floors.push(new Floor(i));
    }

    const departments = [
        new Department("Analytics"),
        new Department("Finance"),
        new Department("Human Resource"),
        new Department("Marketplace"),
        new Department("Sales")
    ];


    return (
        <div className="filter-wrapper">
            <div className="filters-wrapper">
                <div className="filter-item">
                    <p className="filter-heading">Department</p>
                    <Dropdown onOptionSelcted={onDepartmentSelect} name="Department Name" options={departments} />
                </div>
                <div className="filter-item">
                    <p className="filter-heading">Floor Level</p>
                    <Dropdown onOptionSelcted={onFloorSelect} name="Floor Level" options={floors} />
                </div>
                <div className="filter-item">
                    <p className="filter-heading">Asset Type</p>
                    <Dropdown onOptionSelcted={onAssetTypeSelect} name="Asset Type" />
                </div>
                <div className="filter-item">
                    <p className="filter-heading">Parameter(s)</p>
                    <Dropdown onOptionSelcted={onParameterSelect} name="Parameters" />
                </div>
            </div>
            <div className="filter-action-buttons">
                <Button onClick={goFilter} endIcon={<SendOutlined />} variant="contained" color="primary">Go</Button>
            </div>
        </div>
    );
}

export default Filter;