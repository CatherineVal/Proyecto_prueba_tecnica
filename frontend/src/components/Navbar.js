import React, { useState } from "react";
import "../css/main.css";
import { Button, Container, Form, Navbar } from "react-bootstrap";
import { BsPerson } from "react-icons/bs";

const Navbar2 = ({ onSearch, value }) => {
  const [_index, setIndex] = useState(0);

  const [_index2, setIndex2] = useState("");

  const handleSearch = (e) => {
    setIndex2(e.target.value);
    onSearch(e.target.value);
    
  }
  

  return (
    <>
      <Navbar className="custom-navbar" style={{ backgroundColor: "#212529" }}>
        <Container fluid className="justify-content-end">
          <div className="d-flex">
            <input
              type="text"
              placeholder="Search"
              className="me-2 bg-dark text-white"
              style={{ borderColor: "red" }}
              onChange={handleSearch}
              value={_index2}
            />
            <button
              type="button"
              className="btn btn-outline-light" // Botón estilizado para el ícono
              style={{ border: "none", backgroundColor: "transparent" }} // Sin borde y fondo
            >
              <BsPerson size={25} color="red" />{" "}
            </button>
          </div>
        </Container>
      </Navbar>
    </>
  );
};

export default Navbar2;
