import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  getClientes,
  deleteClientes,
  saveClientes,
} from "../redux/clientes/actions";
import { getCuentas } from "../redux/cuentas/actions";
import Sidebar from "../components/Navegacion";
import {
  Alert,
  Button,
  ButtonGroup,
  Container,
  Row,
  Col,
  Form,
  Modal,
  Spinner,
} from "react-bootstrap";
import Table from "react-bootstrap/Table";
import "bootstrap/dist/css/bootstrap.min.css";
import * as Yup from "yup";
import { Formik } from "formik";

const schema = Yup.object().shape({
  nombres: Yup.string().required("**Campo requerido"),
  apellidos: Yup.string().required("**Campo requerido"),
  correo: Yup.string()
    .email("**Se require un correo electrónico valido")
    .required("**Campo requerido"),
  dni: Yup.string().required("**Campo requerido"),
  moneda: Yup.string(),
  // idcuenta: Yup.string().required("**Campo requerido"),
  numerocuenta : Yup.string().required("**Campo requerido"),
  saldo : Yup.number().required("**Campo requerido"),
});

const Aurora = () => {
  const [show, setShow] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [edit, setEdit] = useState(false);
  const [editItem, setEditItem] = useState({});
  const [_index, setIndex] = useState(0);

  const { cliente, loaderCliente, failCliente, saveCliente } = useSelector(
    (store) => store.clienteReducer
  );

  const { cuenta, loaderCuenta, failCuenta } = useSelector(
    (store) => store.cuentasReducer
  );

  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getCuentas({}));
    dispatch(getClientes({}));

    // console.log("cliente ", cliente);
  }, []);

  const onSubmit = (req) => {
    console.log("este boton se preciono ");
    let _req = req;
    _req.cuenta = parseInt(_req.cuenta);
    console.log("request de html", _req);

    const jsonRequest = {
      numerocuenta: _req.numerocuenta,
      nombres: _req.nombres,
      apellidos: _req.apellidos,
      correo: _req.correo,
      cuenta: {
        idcuenta: _req.idcuenta,
        numerocuenta: _req.numerocuenta,
        moneda: _req.moneda,
        saldo: _req.saldo || 100,
        activa: true,
        tipocuenta: {
          idtipocuenta: 1,
          nombre: "Ahorros",
          descripcion: "cuenta de ahorros",
          codigo: "AH1",
        },
      },
      dni: _req.dni,
    };

    console.log(jsonRequest)
    // if (!edit) {
    dispatch(saveClientes(jsonRequest, setShowModal));
    // } else {
    //   dispatch(editClientes(editItem.idcliente, _req, _index, setShowModal));
    // }
  };

  return (
    <>
      <Sidebar isVisible={show} onToggle={() => setShow(!show)} />
      <div>
        <Container fluid>
          <div className="custom-wrapper">
            <div className="pl-md-4 pr-md-3 pl-2 pr-1 d-flex flex-wrap justify-content-between align-items-center">
              <h6 className="text-muted font-weight-bold text-uppercase">
                Empresas
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
                      <Button
                        variant="light"
                        size="sm"
                        className="rounded-circle"
                        onClick={() => {
                          setShowModal(true);
                          setEdit(false);
                        }}
                      >
                        <i className="material-icons">add</i>
                      </Button>
                    </ButtonGroup>
                  </Col>
                </Row>
              </Form>
            </div>
            <hr />
            {!!failCliente && (
              <Alert variant="danger" className="mt-4 mb-1 mx-3">
                {failCliente}
              </Alert>
            )}
            {loaderCliente ? (
              <div className="d-flex justify-content-center">
                <Spinner
                  animation="border"
                  role="status"
                  className="d-flex justify-content-center"
                />
              </div>
            ) : (
              <>
                {cliente && cliente.length > 0 ? (
                  <Table striped hover>
                    <thead>
                      <tr>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>DNI</th>
                        <th># Cuenta</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      {cliente.map((cuent, index) => (
                        <tr key={index}>
                          <td>{cuent.nombres}</td>
                          <td>{cuent.apellidos}</td>
                          <td>{cuent.dni}</td>
                          <td>{cuent.numerocuenta}</td>
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
                              <Button
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
                                      deleteClientes(cuent.idcliente, index)
                                    );
                                    window.alert("Se borro este archivo");
                                  }
                                }}
                              >
                                <i className="material-icons">Borrar</i>
                              </Button>
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
            // idcuenta: edit && editItem.cuenta ? editItem.cuenta.idcuenta : "",
            numerocuenta: "",
            moneda: "",
            saldo: 100,
            // numerocuenta: "",
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
                  {edit ? "Editar clientes" : "Agregar empresas"}
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
                {/* <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    Codigo
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="numerocuenta"
                        name="numerocuenta"
                        isInvalid={touched.numerocuenta && errors.numerocuenta}
                        isValid={touched.numerocuenta && !errors.numerocuenta}
                        onBlur={handleBlur("numerocuenta")}
                        onChange={handleChange}
                        value={values.correo}
                        className="rounded-pill"
                        type="number"
                        placeholder="Codigo"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.numerocuenta && errors.numerocuenta && (
                    <Col>
                      <small className="text-danger">{errors.numerocuenta}</small>
                    </Col>
                  )}
                </Form.Group> */}
                <Modal.Title className="text-muted">
                  Datos de cuenta
                </Modal.Title>
                <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    Numero de cuenta
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="numerocuenta"
                        name="numerocuenta"
                        isInvalid={touched.numerocuenta && errors.numerocuenta}
                        isValid={touched.numerocuenta && !errors.numerocuenta}
                        onBlur={handleBlur("numerocuenta")}
                        onChange={handleChange}
                        value={values.numerocuenta}
                        className="rounded-pill"
                        type="number"
                        placeholder="1234567891234567"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.numerocuenta && errors.numerocuenta && (
                    <Col>
                      <small className="text-danger">
                        {errors.numerocuenta}
                      </small>
                    </Col>
                  )}
                </Form.Group>

                <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    Moneda
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="moneda"
                        name="moneda"
                        isInvalid={touched.moneda && errors.moneda}
                        isValid={touched.moneda && !errors.moneda}
                        onBlur={handleBlur("moneda")}
                        onChange={handleChange}
                        value={values.moneda}
                        className="rounded-pill"
                        type="text"
                        placeholder="LPS o USD"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.moneda && errors.moneda && (
                    <Col>
                      <small className="text-danger">
                        {errors.numerocuenta}
                      </small>
                    </Col>
                  )}
                </Form.Group>

                <Form.Group as={Col} className="mb-3">
                  <Form.Label column sm="12" md="12">
                    Saldo
                  </Form.Label>
                  <Row className="d-flex flex-wrap justify-content-start align-items-center">
                    <Col sm={12}>
                      <Form.Control
                        id="saldo"
                        name="saldo"
                        isInvalid={touched.saldo && errors.saldo}
                        isValid={touched.saldo && !errors.saldo}
                        onBlur={handleBlur("saldo")}
                        onChange={handleChange}
                        value={100}
                        className="rounded-pill"
                        type="text"
                      ></Form.Control>
                    </Col>
                  </Row>
                  {touched.saldo && errors.saldo && (
                    <Col>
                      <small className="text-danger">{errors.saldo}</small>
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

export default Aurora;
