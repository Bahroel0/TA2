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

public class ZApi extends Jooby{
  {
    path("/api/zKejadian", () -> {
      get(req -> {
        ZKejadianRepository db = require(ZKejadianRepository.class);

        return db.listAll();
      });

      put(req -> {
        ZKejadianRepository db = require(ZKejadianRepository.class);
        ZKejadian zKejadian = req.body(ZKejadian.class);

        return db.update(zKejadian);
      });
    });
  }
}
