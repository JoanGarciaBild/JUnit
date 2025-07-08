package com.api.rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.api.rest.model.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmpleadoRepositoryTests {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    private Empleado empleado;

    @BeforeEach
    void setup(){
        empleado = Empleado.builder().nombre("Christian").apellido("Ramirez").email("c1@gmail.com").build();
    }

    @DisplayName("Test para guardar un empleado")
    @Test
    void testGuardarEmpleado(){
        //BDD given - dado o condición previa o configuración
        Empleado empleado1 = Empleado.builder().nombre("Pepe").apellido("Lopez").email("pepe@gmail.com").build();
        //BDD when - acción o el comportamiento que vamos a probar
        Empleado empleadoGuardado = empleadoRepository.save(empleado1);
        //BDD then - verificar la salida
        assertThat(empleadoGuardado).isNotNull();
        assertThat(empleadoGuardado.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar a los empleados")
    @Test
    void testListarEmpleados(){
        //BDD given - dado o condición previa o configuración
        Empleado empleado1 = Empleado.builder().nombre("Julen").apellido("Oliva").email("j2@gmail.com").build();
        empleadoRepository.save(empleado1);
        empleadoRepository.save(empleado);
        //BDD when - acción o el comportamiento que vamos a probar
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        //BDD then - verificar la salida
        assertThat(listaEmpleados).isNotNull();
        assertThat(listaEmpleados.size()).isEqualTo(2);
    }

}
