package com.magnumbank.api2.repository;

import com.magnumbank.api2.dto.VeiculoDTO;
import com.magnumbank.api2.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    List<Veiculo> findByMarca(String marca);

    List<Veiculo> findByMarcaIgnoreCase(String marca);

    @Query("SELECT DISTINCT v.marca FROM Veiculo v")
    List<String> findDistinctMarcas();

    @Query("SELECT v.codigo, v.modelo FROM Veiculo v where v.marca =:marca")
    List<VeiculoDTO> findDistinctMarcas(@Param("marca") String marca);
}
