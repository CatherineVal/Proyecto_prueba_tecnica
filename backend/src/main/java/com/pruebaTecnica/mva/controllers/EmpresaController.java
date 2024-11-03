package com.pruebaTecnica.mva.controllers;


import com.pruebaTecnica.mva.classes.*;
import com.pruebaTecnica.mva.request.AgregarEmpresa;
import com.pruebaTecnica.mva.services.CuentaService;
import com.pruebaTecnica.mva.services.EmpresaService;
import com.pruebaTecnica.mva.services.TipoCuentaService;
import com.pruebaTecnica.mva.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/empresas"})
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    CuentaService cuentaService;
    @Autowired
    TipoCuentaService tipoCuentaService;

    public EmpresaController(){

    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<Empresa> getEmpresas(){

        return this.empresaService.getEmpresas();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Empresa> getEmpresa(@PathVariable(name= "id") Long id){
        return  this.empresaService.getEmpresa(id);
    }

//    @PostMapping()
//    public ResponseEntity<String> saveEmpresa(@RequestBody()Empresa empresa){
//        Optional<Empresa> empresaBusqueda = null;
//        Empresa empresaRes =null;
//
//        empresaBusqueda = this.empresaService.findByName(empresa.getNombre());
//
//        if(empresaBusqueda.isPresent()){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La empresa ya esta registrada");
//        }
//
//        empresaRes = this.empresaService.savEmpresa(empresa);
//
//        if(empresaRes == null){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error");
//        }
//
//        return ResponseEntity.status(HttpStatus.CREATED).body("Consulta exitosa");
//
//    }


    @CrossOrigin(origins = "*")
    @PostMapping()
    public ResponseEntity<String> saveAgregarEmpresa(@RequestBody() AgregarEmpresa request){

        Optional<TipoCuenta> tipoCuenta = this.tipoCuentaService.getTipoCuenta(request.getCuenta().getTipocuenta().getIdtipocuenta());

        if(tipoCuenta.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error al momento de guardar la cuenta");
        }

        Cuenta cuenta = this.cuentaService.saveCuenta(request.getCuenta());
        cuenta.setTipocuenta(tipoCuenta.get());

        if(cuenta == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error al momento de guardar la cuenta");
        }

        Usuario usuario = this.usuarioService.saveUsuario(request.getUsuario());

        if(usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error al momento de guardar el usuario");
        }

        Empresa empresa = new Empresa();
        empresa.setNombre(request.getNombre());
        empresa.setDescripcion(request.getDescripcion());
        empresa.setCuenta(cuenta);
        empresa.setUsuario(usuario);

        empresa = this.empresaService.savEmpresa(empresa);

        if(empresa == null){
            this.cuentaService.deleteCuenta(cuenta);
            this.usuarioService.deleteUsuario(usuario);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error al momento de guardar la empresa");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Empresa actualizada exitosamente");

    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        try {
            Optional<Empresa> empresaExistente = empresaService.getEmpresa(id);

            if (empresaExistente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada");
            }

            empresa.setIdempresa(id);
            Empresa empresaActualizada = empresaService.updateEmpresa(empresa);

            if (empresaActualizada == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la empresa");
            }

            return ResponseEntity.status(HttpStatus.OK).body("Empresa actualizada exitosamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresaExistente = empresaService.getEmpresa(id);

        if (empresaExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada");
        }

        try {
            empresaService.deleteEmpresa(id);
            return ResponseEntity.status(HttpStatus.OK).body("Empresa eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la empresa");
        }
    }

}
