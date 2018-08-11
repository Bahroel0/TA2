package com.abdikaalbiyan.Object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Historikonflik {

  public static class Mapper implements RowMapper<Historikonflik> {
    @Override public Historikonflik map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new Historikonflik(rs.getInt("id"), rs.getString("daerah"), rs.getInt("administrasi"), rs.getInt("politikuang"), rs.getInt("kodeetik"), rs.getInt("tahun2018"));
    }
  }

  private int id;

  private String daerah;

  private int administrasi;

  private int politikuang;

  private int kodeetik;

  private int tahun2018;



  public Historikonflik(int id, String daerah,int administrasi, int politikuang, int kodeetik, int tahun2018) {
    this.id = id;
    this.daerah = daerah;
    this.administrasi = administrasi;
    this.politikuang = politikuang;
    this.kodeetik = kodeetik;
    this.tahun2018 = tahun2018;
  }

  public int getId() {
    return id;
  }


  public String getDaerah() {
    return daerah;
  }

  public int getAdministrasi() {
    return administrasi;
  }

  public int getPolitikuang() {
    return politikuang;
  }

  public int getKodeetik() {
    return kodeetik;
  }

  public int getTahun2018() {
    return tahun2018;
  }
}
