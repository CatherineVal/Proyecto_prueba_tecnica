import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import Sidebar from "../components/Navegacion";
import { Container, Card, Navbar } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { getPrueba, getPruebaID } from "../redux/prueba/actions";
import Navbar2 from "../components/Navbar";

const Prueba = () => {
  const [show, setShow] = useState(true);
  const dispatch = useDispatch();
  const [_index, setIndex] = useState("");

  const { loaderPrueba, prueba, failPrueba, savePrueba } = useSelector(
    (store) => store.pruebaReducer
  );

  const onChangeSearch = (e) => {
    setIndex(e.target.value);

    console.log(e);
  };

  useEffect(() => {
    dispatch(getPrueba({}));
    // dispatch(getPruebaID(1));
    console.log("Inicial", prueba);
  }, []);

  useEffect(() => {
    if (_index == 0 || _index == "") {
      dispatch(getPrueba({}));
    } else {
      dispatch(getPruebaID(_index));
      console.log("Busqueda", prueba);
    }
  }, [_index]);

  return (
    <>
      <div
        style={{
          display: "flex",
          backgroundColor: "#212529",
          minHeight: "100vh",
        }}
      >
        <Sidebar isVisible={show} onToggle={() => setShow(!show)} />

        <div style={{ flexGrow: 1 }}>
          <Navbar2 value={_index} onSearch={setIndex} />
          <Container fluid>
            <div className="custom-wrapper">
              {prueba && prueba.length > 0 ? (
                <div className="d-flex flex-wrap justify-content-between align-items-center">
                  {prueba.slice(0, 10).map((cuent, index) => (
                    <Card
                      className="m-2"
                      style={{ width: "18rem" }}
                      key={index}
                    >
                      {cuent.image ? (
                        <Card.Img
                          variant="top"
                          src={cuent.image}
                          alt="Movie"
                          style={{ height: "12rem", objectFit: "cover" }} // Ajuste para que la imagen no se salga
                        />
                      ) : (
                        <div className="text-center my-5">
                          <p>Imagen no disponible</p>
                        </div>
                      )}
                      <Card.Body className="d-flex justify-content-between align-items-center">
                        <Card.Text className="mb-0">{cuent.movie}</Card.Text>
                        <Card.Text className="text-muted mb-0">
                          {cuent.rating}
                        </Card.Text>
                      </Card.Body>
                    </Card>
                  ))}
                </div>
              ) : null}
            </div>
          </Container>
        </div>
      </div>
    </>
  );
};

export default Prueba;
