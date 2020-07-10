package com.bala.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity,Serializable>{

}
