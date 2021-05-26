import React from 'react';
import Floor from '../../model/Floor';
import Dropdown from '../dropdown/Dropdown';
import './filter.css';

const Filter: React.FC = () => {

    const floors:Floor[] = [];
    for(let i = 1; i <= 15; i++) {
        floors.push(new Floor(i));
    }

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