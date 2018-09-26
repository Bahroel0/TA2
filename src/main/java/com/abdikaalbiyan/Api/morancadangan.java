// package com.abdikaalbiyan.Api;
// import com.abdikaalbiyan.Repository.*;
// import com.abdikaalbiyan.Object.*;
//
// import org.jooby.Jooby;
// import org.jdbi.v3.core.Jdbi;
// import org.jdbi.v3.sqlobject.SqlObjectPlugin;
// import org.jooby.Err;
// import org.jooby.Jooby;
// import org.jooby.Results;
// import org.jooby.Status;
// import org.jooby.jdbc.Jdbc;
// import org.jooby.jdbi.Jdbi3;
// import org.jooby.handlers.CorsHandler;
// import org.jooby.hbs.Hbs;
// import org.jooby.jdbi.TransactionalRequest;
// import org.jooby.json.Jackson;
// import org.jooby.apitool.ApiTool;
// import java.util.Date;
// import java.util.List;
// import java.util.Iterator;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.sql.Timestamp;
// import java.util.ArrayList;
// import java.io.InputStream;
// import java.net.URL;
// import org.apache.commons.math3.distribution.NormalDistribution;
//
// import org.jooby.FlashScope;
// import org.jooby.Session;
// import org.mindrot.jbcrypt.BCrypt;
//
// public class MoranIndexApi extends Jooby{
//   {
//
//         path("/api/moran2018", () -> {
//
//           get(req -> {
//
//             // KecamatanRepository db = require(KecamatanRepository.class);
//             HistorikonflikRepository db = require(HistorikonflikRepository.class);
//             TetanggaRepository tetanggaR = require(TetanggaRepository.class);
//             ZKejadianRepository zKejadianRepo = require(ZKejadianRepository.class);
//             //List<Kecamatan> listKecamatan = db.list();
//             List<Historikonflik> listHistorikonflik = db.list();
//             List<Tetangga> listTetangga = tetanggaR.list();
//             //double[] kejadian = new double[listKecamatan.size()];
//             double[] tahun2018 = new double[listHistorikonflik.size()];
//             // String[] daerah = new String[listKecamatan.size()];
//             int[][] tetangga = new int[listTetangga.size()][8];
//             int[][] indexing = new int[tetangga.length][tetangga.length];
//             int[] numOfNeighboursIndexing = new int[tetangga.length];
//             double sumkejadian = 0;
//             double average = 0;
//             double sumofweight = 0;
//             double sumofweightstandard = 0;
//             double sumximinxbarkuadrat = 0;
//             double sumwijtimes = 0;
//             double sumwijtimesstandard = 0;
//             // InputValues inputValue = new InputValues(tahun2018);
//             double[][] bobotIndexing = new double[tetangga.length][tetangga.length];
//             double[] numOfNeighboursBobotIndexing = new double[tetangga.length];
//             double[] ximinxbar = new double[tahun2018.length] ;
//             double[] ximinxbarkuadrat = new double[tahun2018.length] ;
//             double[][] wijtimes = new double[tahun2018.length][tahun2018.length];
//             double[][] wijtimesstandard = new double[tahun2018.length][tahun2018.length];
//             double[][] transpose = new double[ximinxbar.length][ximinxbar.length];
//             double[][] WijWji = new double[ximinxbar.length][ximinxbar.length];
//             double moran = 0;
//             double moranstandard = 0;
//             double STDEVP = 0;
//             double[] Zvalue = new double[tahun2018.length];
//             double n = 31;
//             double tempwij_all = 0;
//             double tempwji_all = 0;
//             double S0 = 0;
//             double S1 = 0;
//             double S2 = 0;
//             double sum1=(double)0,sum2=(double)0,sum3=(double)0;
//
//
//             for(int i=0; i<listTetangga.size(); i++) {
//               tetangga[i][0] = listTetangga.get(i).getTetangga1();
//               tetangga[i][1] = listTetangga.get(i).getTetangga2();
//               tetangga[i][2] = listTetangga.get(i).getTetangga3();
//               tetangga[i][3] = listTetangga.get(i).getTetangga4();
//               tetangga[i][4] = listTetangga.get(i).getTetangga5();
//               tetangga[i][5] = listTetangga.get(i).getTetangga6();
//               tetangga[i][6] = listTetangga.get(i).getTetangga7();
//               tetangga[i][7] = listTetangga.get(i).getTetangga8();
//             }
//
//             for(int i=0; i<tetangga.length; i++) {
//               for(int j=0; j<tetangga[i].length; j++) {
//                 if(tetangga[i][j] != 0) {
//                   indexing[i][tetangga[i][j] - 1] = 1;
//                   numOfNeighboursIndexing[i]++;
//                 }
//               }
//             }
//
//             for(int i=0; i<indexing.length; i++) {
//               for(int j=0; j<indexing[i].length; j++) {
//                 //System.out.print(indexing[i][j] + " ");
//               }
//                                                                                                   //Print ndexing
//             //  System.out.println("= " + numOfNeighboursIndexing[i]);
//             }
//
//             for(int i=0; i<indexing.length; i++) {
//               for(int j=0; j<indexing[i].length; j++) {
//                 bobotIndexing[i][j] = (double) indexing[i][j] / numOfNeighboursIndexing[i];
//                 numOfNeighboursBobotIndexing[i] += bobotIndexing[i][j];
//
//                 // System.out.print(bobotIndexing[i][j] + " ");
//               }
//
//               numOfNeighboursBobotIndexing[i] = Math.round(numOfNeighboursBobotIndexing[i]);
//               // System.out.println("= " + numOfNeighboursBobotIndexing[i]);
//             }
//
//             for(int i=0; i<indexing.length; i++) {
//                 sumofweight += numOfNeighboursIndexing[i];
//             }
//
//             // System.out.println(sumofweight);
//
//             for(int i=0; i<indexing.length; i++) {
//                 sumofweightstandard += numOfNeighboursBobotIndexing[i];
//             }
//
//               // System.out.println(sumofweightstandard);
//
//             for(int i=0; i<listHistorikonflik.size(); i++) {
//               tahun2018[i] = listHistorikonflik.get(i).getTahun2018();
//               // System.out.println("kejadian = " + kejadian[i]);
//               sumkejadian += tahun2018[i];
//             }
//
//               average = sumkejadian / 31;
//
//             for(int i=0; i<listHistorikonflik.size(); i++) {
//               ximinxbar[i] = (double)(tahun2018[i] - average);
//               // System.out.println("ximinxbar = " + ximinxbar[i]);
//             }
//
//             for(int i=0; i<listHistorikonflik.size(); i++) {
//               ximinxbarkuadrat[i] = (double)(Math.pow(ximinxbar[i], 2));
//                //System.out.println("ximinxbar2 = " + ximinxbarkuadrat[i]);
//             }
//
//             for(int i=0; i<ximinxbarkuadrat.length; i++) {
//                 sumximinxbarkuadrat += ximinxbarkuadrat[i];
//             }
//
//             // System.out.println(sumximinxbarkuadrat);
//
//
//             for(int i = 0 ; i < ximinxbar.length ; i++){
//                 for (int j = 0  ; j < ximinxbar.length ; j++){
//                     transpose[i][j] = (double)(ximinxbar[i] * ximinxbar[j]);
//                     // System.out.print(transpose[i][j] + " ");
//                 }
//             }
//             // System.out.print("\n \n ");
//
//             for(int i = 0 ; i < ximinxbar.length ; i++){
//                 for (int j = 0  ; j < ximinxbar.length ; j++){
//                   if(i==j)
//                   numOfNeighboursIndexing[i]=0;
//                     WijWji[i][j] = (double)(numOfNeighboursIndexing[i] + numOfNeighboursIndexing[j]) * (numOfNeighboursIndexing[i] + numOfNeighboursIndexing[j]);
//                     tempwij_all += numOfNeighboursIndexing[i];
//                     tempwji_all += numOfNeighboursIndexing[j];
//
//                     S1 += WijWji[i][j];
//                      //System.out.print(WijWji[i][j] + " ");
//                 }S2 += (tempwij_all+tempwji_all)*(tempwij_all+tempwji_all);
//             }
//
//             for(int i = 0 ; i < indexing.length ; i++){
//                 for (int j = 0  ; j < indexing.length ; j++){
//                     wijtimes[i][j] = (double)(transpose[i][j] * indexing[i][j]);
//                     // System.out.print(wijtimes[i][j] + " ");
//                 }
//             }
//
//             for(int i = 0 ; i < wijtimes.length ; i++){
//                 for(int j = 0 ; j < wijtimes.length ; j++){
//                   sumwijtimes = (double)(sumwijtimes + wijtimes[i][j]);
//               }
//             }
//
//             // System.out.println("\n\n" + sumwijtimes);
//
//
//             // for (int i = 0; i < wijtimes.length; i ++) {
//             //   for (int j = 0; j < wijtimes[i].length; j++) {
//             //     System.out.print(wijtimes[i][j] + " ");
//             //   }
//             //   System.out.println("");
//             // }
//
//             for(int i = 0 ; i < indexing.length ; i++){
//                 for (int j = 0  ; j < indexing.length ; j++){
//                     wijtimesstandard[i][j] = (double)(transpose[i][j] * bobotIndexing[i][j]);
//                     // System.out.print(wijtimes[i][j] + " ");
//                 }
//             }
//
//             for(int i = 0 ; i < wijtimesstandard.length ; i++){
//                 for(int j = 0 ; j < wijtimesstandard.length ; j++){
//                   sumwijtimesstandard += (double)wijtimesstandard[i][j];
//               }
//             }
//
//             // System.out.println("\n\n" + sumwijtimesstandard);
//
//             // for (int i = 0; i < wijtimes.length; i ++) {
//             //   for (int j = 0; j < wijtimes[i].length; j++) {
//             //     System.out.print(wijtimesstandard[i][j] + " ");
//             //   }
//             //   System.out.println("");
//             // }
//
// 
//             STDEVP = Math.sqrt(sumximinxbarkuadrat / listHistorikonflik.size());
//             //System.out.println(STDEVP);
//
//           //  System.out.println(" Kejadian           Zkejadian           Zketetanggaan");
//
//             for(int i=0 ; i<tahun2018.length ; i++){
//               Zvalue[i] = (double)((tahun2018[i] - average) / STDEVP);
//               //System.out.println( "  " + tahun2018[i] + "          " + Zvalue[i]);
//               //System.out.println(new URL("http://localhost:8080/api/update-z?idPolySby=" + (i+1) + "&z2018=" + Zvalue[i]).getContent());
//             }
//
//             moran = listHistorikonflik.size() / sumofweight * sumwijtimes / sumximinxbarkuadrat;
//             //System.out.println("\nMoran's Index\n" + listHistorikonflik.size() + " / " + sumofweight + " * " + sumwijtimes + " / " + sumximinxbarkuadrat + " = " + moran + "\n\n");
//
//             moranstandard = listHistorikonflik.size() / sumofweightstandard * sumwijtimesstandard / sumximinxbarkuadrat;
//             //System.out.println("Moran's Index Standarisasi\n" + listHistorikonflik.size() + " / " + sumofweightstandard + " * " + sumwijtimesstandard + " / " + sumximinxbarkuadrat + " = " + moranstandard + "\n\n");
//
//             // System.out.println("sumkejadian = " + sumkejadian);
//             // System.out.println("average = " + average + "\n");
//
//             double moranEI = -1. / (n - 1);
//
//             sum1 = sumwijtimes;
//             sum2 = sumofweight;
//             sum3 = sumximinxbarkuadrat;
//
//             S0 = sum2;
//             S1 /= 2;
//             // S2 = (tempwij_all+tempwji_all)*(tempwij_all+tempwji_all);
//
//             double v_num = n * n * S1 - n * S2 + 3 * S0 * S0;
//             double v_den = (n - 1) * (n + 1) * sum2 * sum2;
//
//             double VI_norm = v_num / v_den - (1.0 / (n - 1)) * (1.0 / (n - 1));
//
//             double seI_norm = Math.pow(VI_norm,0.5);
//
//             double z_norm = (moran - moranEI) / seI_norm ;
//
//             NormalDistribution n_distr = new NormalDistribution(0,1);
//             double p_norm = 2.0 * (1 - n_distr.cumulativeProbability(Math.abs(z_norm)));
//
//             System.out.println("S1 = " + S1);
//             System.out.println("S2 = " + S2);
//             System.out.println("v_num = " + v_num);
//             System.out.println("v_den = " + v_den);
//             System.out.println("Var(I) = " + VI_norm);
//             System.out.println("seI_norm = " + seI_norm);
//             System.out.println("z_norm = " + z_norm);
//
//
//
//
//             //return new double[]{moran,p_norm};
//             return listHistorikonflik;
//           });
//
//         });
//   }
// }
