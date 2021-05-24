import React from 'react';
import { Link } from 'react-router-dom';
import ButtonProps from '../../model/ButtonProp';



const Button: React.FC<ButtonProps> = (props) => {

  return (
    <div >
      <Link to={props.path}>
        <button className="btn" >{props.butName}</button>
      </Link>
    </div>
  );
}

export default Button;