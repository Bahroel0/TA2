package com.abdikaalbiyan.Api;
import com.abdikaalbiyan.Repository.*;
import com.abdikaalbiyan.Object.*;

import org.jooby.Jooby;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.Status;
import org.jooby.jdbc.Jdbc;
import org.jooby.jdbi.Jdbi3;
import org.jooby.handlers.CorsHandler;
import org.jooby.hbs.Hbs;
import org.jooby.jdbi.TransactionalRequest;
import org.jooby.json.Jackson;
import org.jooby.apitool.ApiTool;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.io.InputStream;
import java.net.URL;

import org.jooby.FlashScope;
import org.jooby.Session;
import org.mindrot.jbcrypt.BCrypt;


public class KecamatanApi extends Jooby{
  {
    path("/api/kecamatanAll", () -> {

      get(req -> {
        KecamatanRepository db = require(KecamatanRepository.class);

        int start = req.param("start").intValue(0);
        int max = req.param("max").intValue(31);

        return db.list(start, max);
      });
    });


    path("/api/kecamatan", () -> {

      get(req -> {
        KecamatanRepository db = require(KecamatanRepository.class);

        int halaman = req.param("halaman").intValue(0);

        if(halaman < 1 ){
          halaman = 1;
        }
        int start = (halaman-1)*11;
        int max = 11;

        return db.list(start, max);
      });

      get("/:id", req -> {
        KecamatanRepository db = require(KecamatanRepository.class);

        int id = req.param("id").intValue();

        Kecamatan kecamatan = db.findById(id);
        if (kecamatan == null) {
          throw new Err(Status.NOT_FOUND);
        }
        return kecamatan;
      });

      post(req -> {
        KecamatanRepository db = require(KecamatanRepository.class);
        Kecamatan kecamatan = req.body(Kecamatan.class);

        int id;
        boolean toReturn = false;

        id = db.insert(kecamatan);
        if(id > 0) {
          toReturn = true;
        }
        // return new Kecamatan(id, kecamatan.getGeom(), kecamatan.getKelurahan(), kecamatan.getKecamatan());
        return toReturn;
      });

      put(req -> {
        KecamatanRepository db = require(KecamatanRepository.class);

        Kecamatan kecamatan = req.body(Kecamatan.class);

        if (!db.update(kecamatan)) {
          throw new Err(Status.NOT_FOUND);
        }

        return kecamatan;
      });

      delete("/:id", req -> {
        KecamatanRepository db = require(KecamatanRepository.class);

        int id = req.param("id").intValue();

        if (!db.delete(id)) {
          throw new Err(Status.NOT_FOUND);
        }
        return Results.noContent();
      });
    });
  }
}
