import React from 'react';
import { Link } from 'react-router-dom';
import { Link as LinkUI } from '@material-ui/core';
import './notfound.css'

const NotFound: React.FC = () => {
    return (
        <div className="not-found-wrapper">
            <div>
                <h1>MSense</h1>
                <p>Not Found</p>
                <p>
                    Click&nbsp;<Link to="/"><LinkUI component="button" variant="body2">Here</LinkUI></Link>&nbsp;to go to Homepage.
                </p>
            </div>
        </div>
    );
}

export default NotFound;