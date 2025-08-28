package com.magnumbank.api1.repository;

import com.magnumbank.api1.dto.VeiculoDTO;
import com.magnumbank.api1.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

    @Query("SELECT DISTINCT v.marca FROM Veiculo v")
    List<String> findDistinctMarcas();

    @Query("SELECT new com.magnumbank.api1.dto.VeiculoDTO(v.codigo, v.modelo, v.observacoes) FROM Veiculo v where LOWER(v.marca) =LOWER(:marca)")
    List<VeiculoDTO> findByMarcaIgnoreCase(@Param("marca") String marca);
}
