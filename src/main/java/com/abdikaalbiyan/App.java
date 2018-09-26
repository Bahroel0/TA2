package com.abdikaalbiyan;

import com.abdikaalbiyan.Object.*;
import com.abdikaalbiyan.Repository.*;
//import starter.jdbi.controller.*;
import com.abdikaalbiyan.Api.*;
//import starter.jdbi.tools.*;

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

/**
 * @author jooby generator
 */
public class App extends Jooby {

  {
    assets("/**");
    assets("web/**");
    assets("LandingPage/**");

    assets("landing", "LandingPage/landing.html");

    assets("jquery/**");
    assets("index", "web/index.html");
    assets("browse", "web/browse.html");
    assets("point_more", "web/point_more.html");
    assets("point_map", "web/point_map.html");
    assets("masuk", "web/login.html");
    assets("about", "web/about.html");
    assets("about2", "web/about2.html");
    assets("table", "web/table.html");
    assets("tablekonflik", "web/tablekonflik.html");
    assets("chart", "web/chart.html");
    assets("template", "web/template.html");

    assets("/web/js/jquery-1.10.2.min.map", "/web/js/jquery-1.10.2.min.map");
  }

  {
  // cookieSession();
  // use(new FlashScope());
  use(new Jackson());
  use(new Jdbc());
  use(new Hbs());

  // use("*", new CorsHandler());
  use(new Jdbi3()
      /** Install SqlObjectPlugin */
      .doWith(jdbi -> {
        jdbi.installPlugin(new SqlObjectPlugin());
      })
      /** Creates a transaction per request and attach KecamatanRepository */
      .transactionPerRequest(
          new TransactionalRequest()
              .attach(KecamatanRepository.class)
              .attach(HistorikonflikRepository.class)
              // .attach(KonflikRepository.class)
              // .attach(UserpasswordRepository.class)
              .attach(TetanggaRepository.class)
              .attach(ZKejadianRepository.class)
      )
  );

  use(new HistoriKonflikApi());
  use(new KecamatanApi());
  use(new MoranIndexApi());
  use(new TetanggaApi());
  use(new UpdateApi());
  use(new ZApi());

  // Controller


}

  {
    use(new ApiTool ()
      .swagger("/swagger")
      .raml("/raml")
    );
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }

}
