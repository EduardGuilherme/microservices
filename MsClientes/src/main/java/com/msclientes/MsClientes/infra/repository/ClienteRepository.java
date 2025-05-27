package com.msclientes.MsClientes.infra.repository;

import com.msclientes.MsClientes.domain.Cliente;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {


    Optional<Cliente> findByCpf(String cpf);
}
