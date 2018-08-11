package com.abdikaalbiyan.Object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Kecamatan {

  public static class Mapper implements RowMapper<Kecamatan> {
    @Override public Kecamatan map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new Kecamatan(rs.getInt("id"), rs.getString("geom"), rs.getString("daerah"), rs.getDouble("kejadian"), rs.getDouble("dummy"), rs.getInt("bobot_kejadian"));
    }
  }

  private int id;

  private String geom;

  private String daerah;

  private double kejadian;

  private double dummy;

  private int bobot_kejadian;



  public Kecamatan(int id, String geom, String daerah, double kejadian, double dummy, int bobot_kejadian) {
    this.id = id;
    this.geom = geom;
    this.daerah = daerah;
    this.kejadian = kejadian;
    this.dummy = dummy;
    this.bobot_kejadian = bobot_kejadian;
  }

  public int getId() {
    return id;
  }

  public String getGeom() {
    return geom;
  }

  public String getDaerah() {
    return daerah;
  }

  public double getKejadian() {
    return kejadian;
  }

  public double getDummy() {
    return dummy;
  }

  public int getBobot_kejadian() {
    return bobot_kejadian;
  }

}
