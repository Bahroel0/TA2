package com.abdikaalbiyan.Object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tetangga {

  public static class Mapper implements RowMapper<Tetangga> {
    @Override public Tetangga map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new Tetangga(rs.getInt("id"), rs.getInt("tetangga1"), rs.getInt("tetangga2"), rs.getInt("tetangga3"), rs.getInt("tetangga4"), rs.getInt("tetangga5"), rs.getInt("tetangga6"), rs.getInt("tetangga7"), rs.getInt("tetangga8"));
    }
  }

  private int id;

  private int tetangga1;

  private int tetangga2;

  private int tetangga3;

  private int tetangga4;

  private int tetangga5;

  private int tetangga6;

  private int tetangga7;

  private int tetangga8;



  public Tetangga(int id, int tetangga1, int tetangga2, int tetangga3, int tetangga4, int tetangga5, int tetangga6, int tetangga7, int tetangga8) {
    this.id = id;
    this.tetangga1 = tetangga1;
    this.tetangga2 = tetangga2;
    this.tetangga3 = tetangga3;
    this.tetangga4 = tetangga4;
    this.tetangga5 = tetangga5;
    this.tetangga6 = tetangga6;
    this.tetangga7 = tetangga7;
    this.tetangga8 = tetangga8;
  }

  public int getId() {
    return id;
  }

  public int getTetangga1() {
    return tetangga1;
  }

  public int getTetangga2() {
    return tetangga2;
  }

  public int getTetangga3() {
    return tetangga3;
  }

  public int getTetangga4() {
    return tetangga4;
  }

  public int getTetangga5() {
    return tetangga5;
  }

  public int getTetangga6() {
    return tetangga6;
  }

  public int getTetangga7() {
    return tetangga7;
  }

  public int getTetangga8() {
    return tetangga8;
  }

}
