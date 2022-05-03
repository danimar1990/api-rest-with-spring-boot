package br.edu.unoesc.rent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.rent.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}