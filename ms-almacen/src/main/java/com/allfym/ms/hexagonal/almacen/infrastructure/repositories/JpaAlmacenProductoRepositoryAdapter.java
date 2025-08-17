package com.allfym.ms.hexagonal.almacen.infrastructure.repositories;

import com.allfym.ms.hexagonal.almacen.domain.models.AlmacenProducto;
import com.allfym.ms.hexagonal.almacen.domain.ports.out.AlmacenProductoRepositoryPort;
import com.allfym.ms.hexagonal.almacen.infrastructure.entities.AlmacenProductoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class JpaAlmacenProductoRepositoryAdapter implements AlmacenProductoRepositoryPort {

    private final JpaAlmacenProductoRepository jpaAlmacenProductoRepository;

    public JpaAlmacenProductoRepositoryAdapter(JpaAlmacenProductoRepository jpaAlmacenProductoRepository) {
        this.jpaAlmacenProductoRepository = jpaAlmacenProductoRepository;
    }

    @Override
    public AlmacenProducto save(AlmacenProducto almacenProducto) {
        AlmacenProductoEntity almacenProductoEntity = AlmacenProductoEntity.fromDomainModel(almacenProducto);
        AlmacenProductoEntity savedEntity = jpaAlmacenProductoRepository.save(almacenProductoEntity);
        return savedEntity.toDomainModel();
    }

   @Override
   public Optional<AlmacenProducto> findByIdProducto(Long idProducto) {
       return jpaAlmacenProductoRepository.findByIdProducto(idProducto) // ← CORREGIDO
               .map(AlmacenProductoEntity::toDomainModel);
   }

   @Override
   public boolean deleteByIdProducto(Long idProducto) {
       Optional<AlmacenProductoEntity> entity = jpaAlmacenProductoRepository.findByIdProducto(idProducto); // ← CORREGIDO
       if (entity.isPresent()) {
           jpaAlmacenProductoRepository.deleteById(idProducto); // ← Usar idAlmacen para delete
           return true;
       }
       return false;
   }

    @Override
    public List<AlmacenProducto> findAll() {
        return jpaAlmacenProductoRepository.findAll().stream().map(AlmacenProductoEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlmacenProducto> findById(Long id) {
        return jpaAlmacenProductoRepository.findById(id).map(AlmacenProductoEntity::toDomainModel);
    }

    @Override
    public Optional<AlmacenProducto> update(AlmacenProducto almacenProducto) {
        if (jpaAlmacenProductoRepository.existsById(almacenProducto.getIdAlmacen())) {
            AlmacenProductoEntity almacenProductoEntity = AlmacenProductoEntity.fromDomainModel(almacenProducto);
            AlmacenProductoEntity updatedEntity = jpaAlmacenProductoRepository.save(almacenProductoEntity);
            return Optional.of(updatedEntity.toDomainModel());
        }
        return Optional.empty();
    }

}
