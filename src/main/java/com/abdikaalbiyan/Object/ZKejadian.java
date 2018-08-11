package com.abdikaalbiyan.Object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZKejadian {

  public static class Mapper implements RowMapper<ZKejadian> {
    @Override public ZKejadian map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new ZKejadian(rs.getInt("id"), rs.getInt("id_polysby"), rs.getDouble("z2018"), rs.getDouble("bobotz2018"));
    }
  }

  private int id;
  private int idPolySby;
  private double zet2018;
  private double bobotz2018;

  public ZKejadian(int id, int id_polysby, double z2018, double bobotz2018) {
    this.id = id;
    this.idPolySby = id_polysby;
    this.zet2018 = z2018;
    this.bobotz2018 = bobotz2018;
  }

  public int getId() {
    return id;
  }

  public int getIdPolySby() {
    return idPolySby;
  }

  public double getZet2018() {
    return zet2018;
  }

  public double getBobotz2018() {
    return bobotz2018;
  }

  public void setZ2018(double z2018) {
    this.zet2018 = z2018;
  }
}
