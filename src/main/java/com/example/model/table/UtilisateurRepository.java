package com.example.model.table;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Utilisateur findByLoginLike(String login);

    Utilisateur findUtilisateursByLoginLike(String login);

    Utilisateur findUtilisateursByLoginAndPassword (String login, String password);

    List<Utilisateur> findByPassword(String password);

    Utilisateur findById(long id_Utilisateur);

    <S extends Utilisateur> S save(S entity);

    <S extends Utilisateur> Iterable<S> saveAll(Iterable<S> entities);

    Optional<Utilisateur> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<Utilisateur> findAll();

    Iterable<Utilisateur> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(Utilisateur entity);

    void deleteAll(Iterable<? extends Utilisateur> entities);

    void deleteAll();

}
