package br.com.jbseguranca.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jbseguranca.api.domain.AcidenteTrabalho;

public interface AcidenteTrabalhoRepository extends JpaRepository<AcidenteTrabalho, UUID> {
}