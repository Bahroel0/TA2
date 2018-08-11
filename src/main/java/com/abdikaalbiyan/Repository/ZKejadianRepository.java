package com.abdikaalbiyan.Repository;
import com.abdikaalbiyan.Object.*;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.SqlBatch;

import java.util.Iterator;
import java.util.List;

/**
 * Database access for zKejadian dari database zKejadian.
 */
@RegisterRowMapper(ZKejadian.Mapper.class)
public interface ZKejadianRepository {
  /**
   * Daftar semua zKejadian.
   *
   * @return Daftar zKejadian.
   */
  @SqlQuery("SELECT * FROM zvalues order by id_polysby")
  List<ZKejadian> listAll();

  /**
   * ZKejadian berdasarkan ID.
   *
   * @return ZKejadian.
   */
  @SqlQuery("SELECT * FROM zvalues WHERE id_polysby=:idPolySby")
  ZKejadian getByPolySby(int idPolySby);

  /**
   * Perbarui nilai zKejadian dan return status transaksinya.
   *
   * @return True jika data berhasil di-update.
   */
  @SqlUpdate("UPDATE zvalues SET zet2018=:zet2018, bobotz2018=:bobotz2018, zDataSet=:zDataSet, bobotZDataset=:bobotZDataSet WHERE idPolySby=:idPolySby")
  boolean update(@BindBean ZKejadian zKejadian);
  //
  @SqlUpdate("UPDATE zvalues SET z2018=:zet2018 WHERE id_polysby=:idPolySby")
  boolean updateZKejadian(@BindBean ZKejadian zKejadian);
  //
  @SqlUpdate("UPDATE zvalues SET bobotz2018=:bobotz2018 WHERE id_polysby=:id")
  boolean updateBobotZKejadian(double bobotz2018, int id);
}
