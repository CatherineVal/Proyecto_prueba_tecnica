package com.pruebaTecnica.mva.controllers;


import com.pruebaTecnica.mva.classes.*;
import com.pruebaTecnica.mva.request.AgregarCliente;
import com.pruebaTecnica.mva.request.AgregarEmpresa;
import com.pruebaTecnica.mva.services.ClienteService;
import com.pruebaTecnica.mva.services.CuentaService;
import com.pruebaTecnica.mva.services.EmpresaService;
import com.pruebaTecnica.mva.services.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/clientes"})
@CrossOrigin(origins = "http://localhost:3000") // Reemplaza esta URL con la URL de tu frontend de ReactJS
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @Autowired
    CuentaService cuentaService;
    @Autowired
    TipoCuentaService tipoCuentaService;
    @Autowired
    EmpresaService empresaService;

    public ClienteController(){

    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<Cliente> getClientes(){

        return this.clienteService.geClientes();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Cliente> getCliente(@PathVariable(name = "id") Long id){

        return this.clienteService.geCliente(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public ResponseEntity<String> saveAgregarCliente(@RequestBody() AgregarCliente request){

        String numerocuenta = request.getNumerocuenta();
        if (numerocuenta.length() != 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El numero de cuenta debe tener exactamente 8 caracteres");
        }

        Optional<TipoCuenta> tipoCuenta = this.tipoCuentaService.getTipoCuenta(request.getCuenta().getTipocuenta().getIdtipocuenta());

        if(tipoCuenta.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error al momento de guardar la cuenta");
        }
        Cuenta cuenta = this.cuentaService.saveCuenta(request.getCuenta());
        cuenta.setTipocuenta(tipoCuenta.get());

        if(cuenta == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error al momento de guardar la cuenta");
        }

        if (!cuenta.getActiva()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La cuenta no está activa");
        }

        Cliente cliente = new Cliente();
        cliente.setNumerocuenta(request.getNumerocuenta());
        cliente.setNombres(request.getNombres());
        cliente.setApellidos(request.getApellidos());
        cliente.setCorreo(request.getCorreo());
        cliente.setCuenta(cuenta);
        cliente.setDni(request.getDni());

        cliente = this.clienteService.saveCliente(cliente);
        if(cliente == null){
            this.cuentaService.deleteCuenta(cuenta);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error al momento de guardar la empresa");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Clinte actualizado exitosamente");
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        Optional<Cliente> clienteExistente = clienteService.geCliente(id);

        if (clienteExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }

        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Empleado eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar al empleado");
        }
    }
}
