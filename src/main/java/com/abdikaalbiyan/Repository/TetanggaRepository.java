package com.abdikaalbiyan.Repository;
import com.abdikaalbiyan.Object.*;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */
@RegisterRowMapper(Tetangga.Mapper.class)
public interface TetanggaRepository {

  /**
   * List pets using start/max limit.
   *

   */
  @SqlQuery("select id, tetangga1, tetangga2, tetangga3, tetangga4, tetangga5, tetangga6, tetangga7, tetangga8 from tetangga ")
  List<Tetangga> list();

  /**
   * List pets using start/max limits.
   *
   * @param start Start offset.
   * @param max Max number of rows.
   * @return Available pets.
   */
  @SqlQuery("select id, tetangga1, tetangga2, tetangga3, tetangga4, tetangga5, tetangga6, tetangga7, tetangga8 from tetangga limit :max offset :start")
  List<Tetangga> list(int start, int max);

  /**
   * Find a pet by ID.
   *
   * @param id Pet ID.
   * @return Pet or null.
   */
  @SqlQuery("select id, tetangga1, tetangga2, tetangga3, tetangga4, tetangga5, tetangga6, tetangga7, tetangga8 from tetangga where id=:id")
  Tetangga findById(int id);

}
