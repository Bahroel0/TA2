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
@RegisterRowMapper(Kecamatan.Mapper.class)
public interface KecamatanRepository {

  /**
   * List pets using start/max limit.
   *

   */
  @SqlQuery("select id, daerah, ST_AsText((ST_Dump(geom)).geom) AS geom, kejadian, dummy, bobot_kejadian from polysby order by id")
  List<Kecamatan> list();

  /**
   * List pets using start/max limits.
   *
   * @param start Start offset.
   * @param max Max number of rows.
   * @return Available pets.
   */
  @SqlQuery("select id, daerah, ST_AsText((ST_Dump(geom)).geom) AS geom, kejadian, dummy, bobot_kejadian from polysby order by id limit :max offset :start")
  List<Kecamatan> list(int start, int max);

  /**
   * Find a pet by ID.
   *
   * @param id Pet ID.
   * @return Pet or null.
   */
  @SqlQuery("select id, daerah, ST_AsText((ST_Dump(geom)).geom) AS geom, kejadian, dummy, bobot_kejadian from polysby where id=:id  order by id")
  Kecamatan findById(int id);

  /**
   * Insert a pet and returns the generated PK.
   *
   * @param pet Pet to insert.
   * @return Primary key.
   */
  @SqlUpdate("insert into polysby(geom, daerah, kejadian, dummy, bobot_kejadian) values(ST_GeomFromText(:geom,4326), :daerah, :kejadian, :dummy, :bobot_kejadian)")
  @GetGeneratedKeys
  int insert(@BindBean Kecamatan kecamatan);

  /**
   * Update a pet and returns true if the pets was updated.
   *
   * @param pet Pet to update.
   * @return True if the pet was updated.
   */
  @SqlUpdate("update polysby set daerah=:daerah where id=:id")
  boolean update(@BindBean Kecamatan kecamatan);

  /**
   * Delete a pet by ID.
   *
   * @param id Pet ID.
   * @return True if the pet was deleted.
   */
  @SqlUpdate("delete polysby where id=:id")
  boolean delete(int id);
}
