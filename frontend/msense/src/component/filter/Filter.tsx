import React from 'react';
import Dropdown from '../dropdown/Dropdown';
import './filter.css'

const Filter: React.FC = () => {

    const floors = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

    return (
        <div className="filter-wrapper">
            <div className="filter-item">
               <p className="filter-heading">Department</p>
               <Dropdown name="Department Name" />
            </div>
            <div className="filter-item">
                <p className="filter-heading">Floor Level</p>
                <Dropdown name="Floor Level" options={floors} />
            </div>
            <div className="filter-item">
                <p className="filter-heading">Asset Type</p>
                <Dropdown name="Asset Type" />
            </div>
            <div className="filter-item">
                <p className="filter-heading">Parameter(s)</p>
                <Dropdown name="Parameters" />
            </div>
        </div>
    );
}

export default Filter;