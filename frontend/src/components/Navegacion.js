import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../css/main.css";
import img from "../images/perfil.jpg";
import {
  BsFillCameraReelsFill,
  BsPersonWorkspace,
  BsFillLayersFill,
} from "react-icons/bs";

const Sidebar = () => {
  const [expanded, setExpanded] = useState(false);

  const handleToggle = () => {
    setExpanded(!expanded);
  };

  return (
    <div className={expanded ? "sidebar expanded" : "sidebar"}>
      <div className="logo">
        <Link to="/">
          <img src={img} alt="" />
        </Link>
        <h4 className="white-text">Sara</h4>
        <p className="white-text">Premium Member</p>
      </div>
      {/* <div className="toggle-btn" onClick={handleToggle}>
        Toggle
      </div> */}
      <div className="menu">
        <ul>
          <li>
            <Link to="/Prueba">
              <BsFillCameraReelsFill style={{ marginRight: "5px" }} />
              New Movies
            </Link>
          </li>
          <li>
            <Link to="/">
              <BsFillLayersFill style={{ marginRight: "5px" }} />
              Empresas
            </Link>
          </li>
          <li>
            <Link to="/Forests">
              <BsPersonWorkspace style={{ marginRight: "5px" }} />
              Empleados
            </Link>
          </li>
        </ul>
      </div>
      {/* <Button variant="outline-light">Login</Button> */}
    </div>
  );
};

export default Sidebar;
