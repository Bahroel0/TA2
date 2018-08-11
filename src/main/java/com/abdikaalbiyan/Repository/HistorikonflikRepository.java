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
@RegisterRowMapper(Historikonflik.Mapper.class)
public interface HistorikonflikRepository {
  /**
   * List pets using start/max limits.
   *
   * @param start Start offset.
   * @param max Max number of rows.
   * @return Available pets.
   */
  @SqlQuery("select id, daerah, administrasi, politikuang, kodeetik, tahun2018 from datakejadian ORDER BY id limit :max offset :start")
  List<Historikonflik> list(int start, int max);

  /**
   * List pets using start/max limits.
   *
   * @param start Start offset.
   * @param max Max number of rows.
   * @return Available pets.
   */
  @SqlQuery("select id, daerah, administrasi, politikuang, kodeetik, tahun2018 from datakejadian ORDER BY id")
  List<Historikonflik> list();

  /**
   * Find a pet by ID.
   *
   * @param id Pet ID.
   * @return Pet or null.
   */
  @SqlQuery("select id, daerah, administrasi, politikuang, kodeetik, tahun2018 from datakejadian where id=:id")
  Historikonflik findById(int id);

  /**
   * Insert a pet and returns the generated PK.
   *
   * @param pet Pet to insert.
   * @return Primary key.
   */
  @SqlUpdate("insert into datakejadian(daerah, administrasi, politikuang, kodeetik, tahun2018) values :daerah, :administrasi, :politikuang, :kodeetik, :tahun2018)")
  @GetGeneratedKeys
  int insert(@BindBean Historikonflik historikonflik);

  /**
   * Update a pet and returns true if the pets was updated.
   *
   * @param pet Pet to update.
   * @return True if the pet was updated.
   */
  @SqlUpdate("update datakejadian set administrasi=:administrasi, politikuang=:politikuang, kodeetik=:kodeetik, tahun2018=:tahun2018 where id=:id")
  boolean update(@BindBean Historikonflik historikonflik);

  /**
   * Delete a pet by ID.
   *
   * @param id Pet ID.
   * @return True if the pet was deleted.
   */
  @SqlUpdate("delete datakejadian where id=:id")
  boolean delete(int id);
}
