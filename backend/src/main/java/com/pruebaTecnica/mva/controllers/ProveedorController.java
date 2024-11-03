package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.*;
import com.pruebaTecnica.mva.request.AgregarProveedores;
import com.pruebaTecnica.mva.services.CuentaService;
import com.pruebaTecnica.mva.services.EmpresaService;
import com.pruebaTecnica.mva.services.ProveedorService;
import com.pruebaTecnica.mva.services.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/proveedores"})
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;
    @Autowired
    CuentaService cuentaService;
    @Autowired
    TipoCuentaService tipoCuentaService;
    @Autowired
    EmpresaService empresaService;

    public ProveedorController(){

    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<ResponseProveedores> getProveedores(){
        ArrayList<Proveedor> proveedores = this.proveedorService.getProveedors();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseProveedores(proveedores));


    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Proveedor> getProveedor(@PathVariable(name = "id")Long id){
        return this.proveedorService.getProveedor(id);
    }

//    @PostMapping()
//    public ResponseEntity<String> saveProveedor(@RequestBody() Proveedor proveedor){
//        Optional<Proveedor> proveedorBusqueda = null;
//        Proveedor proveedorRes =null;
//
//        proveedorBusqueda = this.proveedorService.findByName(proveedor.getNombre());
//
//        if(proveedorBusqueda.isPresent()){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El proveedor ya esta registrado");
//        }
//
//        proveedorRes = this.proveedorService.saveProveedor(proveedor);
//
//        if(proveedorRes == null){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error");
//        }
//
//        return ResponseEntity.status(HttpStatus.CREATED).body("Consulta exitosa");
//
//    }

    @CrossOrigin(origins = "*")
    @GetMapping("/json")
    public ResponseEntity<Response> getJson() {
        // Crea un objeto JSON para devolver
        Response jsonResponse = new Response("prueba"); /* Tu lógica para crear el JSON */;

        // Devuelve el JSON con ResponseEntity
//        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public ResponseEntity<Response> saveAgregarProveedores(@RequestBody() AgregarProveedores request){
        System.out.println(request.toString());
        try {
            String numerocuenta = request.getNumerocuenta();
            if (numerocuenta.length() != 16) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El numero de cuenta debe tener exactamente 16 caracteres"));
            }

            Optional<TipoCuenta> tipoCuenta = this.tipoCuentaService.getTipoCuenta(request.getIdtipocuenta());


            if(tipoCuenta.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Ha ocurrido un error al momento de guardar la cuenta"));
            }

            Cuenta cuenta = new Cuenta();
            cuenta.setNumerocuenta(request.getNumerocuenta());
            cuenta.setMoneda(request.getMoneda());
            cuenta.setSaldo(request.getSaldo());
            cuenta.setActiva(true);
            cuenta.setTipocuenta(tipoCuenta.get());

            Cuenta newCuenta = this.cuentaService.saveCuenta(cuenta);

            System.out.println(newCuenta.toString());

            if(newCuenta == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Ha ocurrido un error al momento de guardar la cuenta"));
            }

            Optional<Empresa> empresa = this.empresaService.getEmpresa(request.getIdempresa());
            if(empresa.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("La empresa no existe o no esta registrada. "));
            }

            System.out.println(empresa.toString());

            Proveedor proveedor = new Proveedor();
            proveedor.setNombre(request.getNombre());
            proveedor.setDepartamento(request.getDepartamento());
            proveedor.setRubro(request.getRubro());
            proveedor.setEmpresa(empresa.get());
            proveedor.setCuenta(newCuenta);


            Proveedor newproveedor = this.proveedorService.saveProveedor(proveedor);

            System.out.println(newproveedor);

            if(newproveedor == null){
                this.cuentaService.deleteCuenta(cuenta);
                //  this.empresaService.deleteEmpresa(empresa.get().getIdempresa());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Ha ocurrido un error al momento de guardar la empresa"));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new Response("Proveedor actualizada exitosamente"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
        }

    }


    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmpresa(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        Optional<Proveedor> proveedorExistente = proveedorService.getProveedor(id);

        if (proveedorExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }


        proveedor.setIdproveedor(id);
        Proveedor proveedorActualizado = proveedorService.updateProveedor(proveedor);

        if (proveedorActualizado == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el proveedor");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Proveedir actualizado exitosamente");
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
        Optional<Proveedor> proveedorExistente = proveedorService.getProveedor(id);

        if (proveedorExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }

        try {
            proveedorService.deleteProveedor(id);
            return ResponseEntity.status(HttpStatus.OK).body("Proveedor eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar al proveedor");
        }
    }

}
