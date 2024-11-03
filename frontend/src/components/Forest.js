import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import Sidebar from "../components/Navegacion";
import Navbar from "../components/Navbar";
import {
  Alert,
  Button,
  ButtonGroup,
  Card,
  Container,
  Row,
  Col,
  Form,
  Modal,
  Spinner,
  Tooltip,
  OverlayTrigger,
  Dropdown,
} from "react-bootstrap";
import Table from "react-bootstrap/Table";
import "bootstrap/dist/css/bootstrap.min.css";
import { getEmpleados,deleteEmpleados, saveEmpleados } from "../redux/empleados/actions";
import * as Yup from "yup";
import { Formik } from "formik";


const schema = Yup.object().shape({
  nombres: Yup.string().required("**Campo requerido"),
  apellidos: Yup.string().required("**Campo requerido"),
  correo: Yup.string()
    .email("**Se require un correo electrónico valido")
    .required("**Campo requerido"),
  dni: Yup.string().required("**Campo requerido"),
});


const Forest = () => {
  const [show, setShow] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [edit, setEdit] = useState(false);
  const [editItem, setEditItem] = useState({});
  const [_index, setIndex] = useState(0);


  const { empleado, loader, fail, save } = useSelector(
    (store) => store.empleadoReducer
  );
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getEmpleados({}));

    console.log("empleado ", empleado);
  }, []);


  const onSubmit = (req) => {
    let _req = req;
    _req.cuenta = parseInt(_req.cuenta);
    // if (!edit) {
    dispatch(saveEmpleados(_req, setShowModal));
    // } else {
    //   dispatch(editClientes(editItem.idcliente, _req, _index, setShowModal));
    // }
  };

  return (
    // <div>
    //   {loader ?? <p>Cargando ...</p>}

    //   {!loader && (
    //     <>
    //       <Navbar bg="dark" variant="dark" expand="lg" />
    //       <Sidebar isVisible={show} onToggle={() => setShow(!show)} />
    //       <div className="custom-wrapper">
    //         <Container fluid>
    //           <div className="my-1 pl-md-4 pr-md-3 pl-2 pr-1 d-flex flex-wrap justify-content-between align-items-center">
    //             <h5 className="text-black-50 m-0 text-uppercase">Empleados</h5>

    //             <Table className="table">
    //               <thead className="table-dark">
    //                 <tr>
    //                   <th>Nombre</th>
    //                   <th>Apellido</th>
    //                   <th>Identidad</th>
    //                   <th>Empresa</th>
    //                 </tr>
    //               </thead>
    //               <tbody>
    //                 {empleado && empleado.length > 0 ? (
    //                   empleado.map((cuent, index) => (
    //                     <tr key={index}>
    //                       <td>{cuent.nombres}</td>
    //                       <td>{cuent.apellidos}</td>
    //                       <td>
    //                         {cuent.cuenta && cuent.cuenta[0]
    //                           ? cuent.cuenta[0].numerocuenta
    //                           : "No disponible"}
    //                       </td>
    //                       <td>
    //                         {cuent.empresa && cuent.empresa[0]
    //                           ? cuent.empresa[0].nombre
    //                           : "No disponible"}
    //                       </td>
    //                     </tr>
    //                   ))
    //                 ) : (
    //                   <tr>
    //                     <td colSpan="4">No hay empleados disponibles</td>
    //                   </tr>
    //                 )}
    //               </tbody>
    //             </Table>
    //           </div>
    //           <button type="button" className="btn btn-outline-dark">
    //             Agregar
    //           </button>
    //           <button type="button" className="btn btn-outline-dark">
    //             Editar
    //           </button>
    //           <button type="button" className="btn btn-outline-danger">
    //             Borrar
    //           </button>
    //         </Container>
    //       </div>
    //     </>
    //   )}
    // </div>

    <>
      <Sidebar isVisible={show} onToggle={() => setShow(!show)} />
      <div>
        <Container fluid>
          <div className="custom-wrapper">
            <div className="pl-md-4 pr-md-3 pl-2 pr-1 d-flex flex-wrap justify-content-between align-items-center">
              <h6 className="text-muted font-weight-bold text-uppercase">
                Empleados
              </h6>
              <Form
              // onSubmit={onSearch}
              >
                <Row className="justify-content-sm-end align-items-center flex-nowrap">
                  <Col xs="auto">
                    <Form.Control
                      name="filter"
                      id="filter"
                      placeholder="Buscar"
                      className="rounded-pill form-control-sm"
                      type="search"
                    ></Form.Control>
                  </Col>
                  <Col xs="auto">
                    <ButtonGroup>
                      {/* <Button
                        variant="light"
                        size="sm"
                        className="rounded-circle"
                        onClick={() => {
                          setShowModal(true);
                          setEdit(false);
                        }}
                      >
                        <i className="material-icons">add</i>
                      </Button> */}
                    </ButtonGroup>
                  </Col>
                </Row>
              </Form>
            </div>
            <hr />
            {!!fail && (
              <Alert variant="danger" className="mt-4 mb-1 mx-3">
                {fail}
              </Alert>
            )}
            {loader ? (
              <div className="d-flex justify-content-center">
                <Spinner
                  animation="border"
                  role="status"
                  className="d-flex justify-content-center"
                />
              </div>
            ) : (
              <>
                {empleado && empleado.length > 0 ? (
                  <Table striped hover>
                    <thead>
                      <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Correo</th>
                        <th>Codigo</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      {empleado.map((cuent, index) => (
                        <tr key={index}>
                          <td>{cuent.nombres}</td>
                          <td>{cuent.apellidos}</td>
                          <td>{cuent.correo}</td>
                          <td>{cuent.codigo}</td>
                          <td>
                            <div className="btn-group" role="group">
                              {/* <Button
                                size="sm"
                                variant="link"
                                type="button"
                                onClick={() => {
                                  setIndex(index);
                                  setEdit(true);
                                  setEditItem(cuent);
                                  setShowModal(true);
                                }}
                              >
                                <i className="material-icons">edit</i>
                              </Button> */}
                              {/* <Button
                                size="sm"
                                className="text-danger"
                                variant="link"
                                type="button"
                                onClick={() => {
                                  if (
                                    window.confirm(
                                      "¿Seguro que desea eliminar este registros?"
                                    )
                                  ) {
                                    dispatch(
                                      deleteEmpleados(cuent.idcliente, index)
                                    );
                                    window.alert("Se borro este archivo");
                                  }
                                }}
                              >
                                <i className="material-icons">close</i>
                              </Button> */}
                            </div>
                          </td>
                        </tr>
                      ))}
                    </tbody>
                  </Table>
                ) : (
                  <Alert variant="info" className="my-4">
                    Aún no hay registros, comience creando algunos.
                  </Alert>
                )}
              </>
            )}
          </div>
        </Container>
      </div>
      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Formik
          validationSchema={schema}
          onSubmit={onSubmit}
          initialValues={{
            nombres: edit ? editItem.nombres : "",
            apellidos: edit ? editItem.apellidos : "",
            correo: edit ? editItem.correo : "",
            dni: edit ? editItem.dni : "",
            idcuenta: edit && editItem.cuenta ? editItem.cuenta.idcuenta : "",
          }}
        >
          {({
            handleSubmit,
            handleChange,
            setFieldValue,
            handleBlur,
            values,
            touched,
            isValid,
            errors,
          }) => (
            <Form onSubmit={handleSubmit}>
              <Modal.Header closeButton>
                <Modal.Title className="text-muted">
                  {edit ? "Editar clientes" : "Agregar clientes"}
                </Modal.Title>
              </Modal.Header>
              <Modal.Body>
                {/* {!!formError && (
                <Alert variant="danger" className="mt-4 mb-1 mx-3">
                  {formError}
                </Alert>
              )} */}
                <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    DNI
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="dni"
                        name="dni"
                        isInvalid={touched.dni && errors.dni}
                        isValid={touched.dni && !errors.dni}
                        onBlur={handleBlur("dni")}
                        onChange={handleChange}
                        value={values.dni}
                        className="rounded-pill"
                        type="text"
                        placeholder="DNI"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.dni && errors.dni && (
                    <Col>
                      <small className="text-danger">{errors.dni}</small>
                    </Col>
                  )}
                </Form.Group>
                <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    Nombre
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="nombres"
                        name="nombres"
                        isInvalid={touched.nombres && errors.nombres}
                        isValid={touched.nombres && !errors.nombres}
                        onBlur={handleBlur("nombres")}
                        onChange={handleChange}
                        value={values.nombres}
                        className="rounded-pill"
                        type="text"
                        placeholder="Nombres"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.nombres && errors.nombres && (
                    <Col>
                      <small className="text-danger">{errors.nombres}</small>
                    </Col>
                  )}
                </Form.Group>
                <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    Apellidos
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="apellidos"
                        name="apellidos"
                        isInvalid={touched.apellidos && errors.apellidos}
                        isValid={touched.apellidos && !errors.apellidos}
                        onBlur={handleBlur("apellidos")}
                        onChange={handleChange}
                        value={values.apellidos}
                        className="rounded-pill"
                        type="text"
                        placeholder="Apellidos"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.apellidos && errors.apellidos && (
                    <Col>
                      <small className="text-danger">{errors.apellidos}</small>
                    </Col>
                  )}
                </Form.Group>
                <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    Correo electrónico
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="correo"
                        name="correo"
                        isInvalid={touched.correo && errors.correo}
                        isValid={touched.correo && !errors.correo}
                        onBlur={handleBlur("correo")}
                        onChange={handleChange}
                        value={values.correo}
                        className="rounded-pill"
                        type="correo"
                        placeholder="Correo electrónico"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.correo && errors.correo && (
                    <Col>
                      <small className="text-danger">{errors.correo}</small>
                    </Col>
                  )}
                </Form.Group>
              </Modal.Body>
              <Modal.Footer>
                <Button
                  className="rounded-pill"
                  variant="secondary"
                  onClick={() => setShowModal(false)}
                >
                  Cerrar
                </Button>
                <Button className="rounded-pill btn-guardar" type="submit">
                  {/* {saveLoading && (
                  <Spinner
                    className="mr-2"
                    as="span"
                    animation="border"
                    size="sm"
                    role="status"
                    aria-hidden="true"
                  />
                )} */}
                  Guardar
                </Button>
              </Modal.Footer>
            </Form>
          )}
        </Formik>
      </Modal>
    </>
  );
};

export default Forest;
