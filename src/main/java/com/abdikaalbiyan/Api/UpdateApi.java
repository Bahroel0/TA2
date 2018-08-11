package com.abdikaalbiyan.Api;

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

import com.abdikaalbiyan.Repository.*;
import com.abdikaalbiyan.Object.*;

public class UpdateApi extends Jooby{
  {
    path("/api/update-z", () -> {

      get(req -> {
        ZKejadianRepository db = require(ZKejadianRepository.class);

        int idPolySby = req.param("idPolySby").intValue(0);
        double z2018 = req.param("z2018").doubleValue(0);
        double bobotz2018 = req.param("bobotz2018").doubleValue(0);
        ZKejadian zKejadianObj = new ZKejadian(0, idPolySby, z2018, bobotz2018);

        // return db.updateZKejadian(zKejadianObj);
        return db.updateZKejadian(zKejadianObj);
      });
    });

    path("/api/update-zbobot", () -> {

      get(req -> {
        TetanggaRepository tRepo = require(TetanggaRepository.class);
        ZKejadianRepository zKejadianRepo = require(ZKejadianRepository.class);
        List<Tetangga> tList = tRepo.list();
        double[] bobotz2018 = new double[31];
        boolean status = false;
          System.out.println("Ztetangga");

        for(int i=0; i<tList.size(); i++) {
          double sumZ2018 = 0.0;
          double n = 0.0;

          if(tList.get(i).getTetangga1() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga1()).getZet2018();
            n += 1;
          }

          if(tList.get(i).getTetangga2() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga2()).getZet2018();
            n += 1;
          }

          if(tList.get(i).getTetangga3() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga3()).getZet2018();
            n += 1;
          }

          if(tList.get(i).getTetangga4() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga4()).getZet2018();
            n += 1;
          }

          if(tList.get(i).getTetangga5() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga5()).getZet2018();
            n += 1;
          }

          if(tList.get(i).getTetangga6() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga6()).getZet2018();
            n += 1;
          }

          if(tList.get(i).getTetangga7() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga7()).getZet2018();
            n += 1;
          }

          if(tList.get(i).getTetangga8() != 0) {
            sumZ2018 += zKejadianRepo.getByPolySby(tList.get(i).getTetangga8()).getZet2018();
            n += 1;
          }

          if(zKejadianRepo.updateBobotZKejadian((sumZ2018 / n), tList.get(i).getId())) {
            status = true;
          } else {
            status = false;
          }

          bobotz2018[i] = (double)(sumZ2018 / n);

          System.out.println(bobotz2018[i]);
          //System.out.println(new URL("http://localhost:8080/api/update-z?idPolySby=" + (i+1) + "&bobotz2018=" + bobotz2018[i]).getContent());

        }
        return status;
      });
    });
  }
}
