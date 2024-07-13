package com.Springcurso.Skyetv.principal;

import com.Springcurso.Skyetv.model.DatosSeries;
import com.Springcurso.Skyetv.model.DatosTemporadas;
import com.Springcurso.Skyetv.service.ConsumoAPI;
import com.Springcurso.Skyetv.service.ConvierteDatos;

import java.util.*;

public class PrincipalOriginal {
    private Scanner teclado = new Scanner((System.in));
    private ConsumoAPI consumoApi  = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f1e17984";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosSeries> datosSerie = new ArrayList<>();

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }


//    public void muestraElMenu() {
//        System.out.println("Por favor escribe el nombre de la serie ");
//        //Busca los datos generales de la serie
//        var nombreSerie = teclado.nextLine();
//        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
//        var datos = conversor.obtenerDatos(json, DatosSeries.class);
//        System.out.println(datos);
//        //Busca datos de todas las temporadas
//        List<DatosTemporadas> temporadas = new ArrayList<>();
//        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
//            json= consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season="+i+API_KEY );
//            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
//            temporadas.add(datosTemporadas);
        }


    //temporadas.forEach(System.out::println);

        //Mostrar solo el titulo de los episodios para las temporadas
//        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
//            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//
//        }
        //hicimos lo mismo que en la linea 36
        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista del tipo DatosEpisodio



//        List<DatosEpisodio> datosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream())
//                .collect(Collectors.toList());
//
//        // Top 5 episodios
//        System.out.println("Top 5 episodios");
//        datosEpisodios.stream()
//                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primer filtro (N/A)" + e))
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .peek(e -> System.out.println("Segundo ordenacion (M>m)" + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Tercer Filtro Mayuscula (m<M)" + e))
//                .limit(5)
//                .forEach(System.out::println);
//
//        //Convirtiendo los datos a una lista del tipo Episodio
//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()
//                        .map(d -> new Episodio(t.numero(),d)))
//                .collect(Collectors.toList());
//
//        //episodios.forEach(System.out::println);
//
//
//
//        //Busqueda de episodios a partir de x año
////        System.out.println("Por favor indica el año a partir del cual deseas ver los episodios");
////        var fecha = teclado.nextInt();
////        teclado.nextLine();
//
//        //LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////        episodios.stream()
////                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda) )
////                .forEach(e -> System.out.println(
////                            "Temporada" + e.getTemporada() +
////                                    "Episodio" + e.getTitulo() +
////                                    "Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
////                ));
//
//
//        //Busca episodio por pedazo del titulo
////        System.out.println("Ingrese el titulo del episodio que deseas ver");
////        var pedazoTitulo = teclado.nextLine();
////        Optional<Episodio> episodioBuscado = episodios.stream()
////                .filter(e -> e.getTitulo().contains(pedazoTitulo.toUpperCase()))
////                .findFirst();
////        if (episodioBuscado.isPresent()){
////            System.out.println(("Episodio encontrado"));
////            System.out.println("Los datos son: " + episodioBuscado.get());
////        }else {
////            System.out.println("Episodio no encontrado");
////        }
//
//        Map<Integer , Double> evaluacionesPorTemporada = episodios.stream()
//                .filter(e -> e.getEvaluacion() > 0.0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada,
//                        Collectors.averagingDouble(Episodio::getEvaluacion)));
//        System.out.println(evaluacionesPorTemporada);
//
//
//        //Analizamos informacion con la clase DoubleSummaryStatics
//        DoubleSummaryStatistics est = episodios.stream()
//                .filter(e -> e.getEvaluacion() > 0.0)
//                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
//        System.out.println("Media " + est.getAverage());
//        System.out.println("Mejor Episodio: " + est.getMax());
//        System.out.println("Peor episodio: " + est.getMin());
//        System.out.println("Cantidad " + est.getCount());
//
//    }

    private DatosSeries getDatosSeries() {
        System.out.println("Escribe el nombre de la serie");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        System.out.println(json);
        DatosSeries datos = conversor.obtenerDatos(json, DatosSeries.class);
        return datos;
    }
    private void buscarEpisodioPorSerie() {
        DatosSeries datosSerie = getDatosSeries();
        List<DatosTemporadas> temporadas = new ArrayList<>();

        for (int i = 1; i <= datosSerie.totalDeTemporadas(); i++) {
            var json = consumoApi.obtenerDatos(URL_BASE + datosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporada);
        }
        temporadas.forEach(System.out::println);
    }
    private void buscarSerieWeb() {
        DatosSeries datos = getDatosSeries();
        System.out.println(datos);
    }
    private void mostrarSeriesBuscadas() {
        datosSerie.forEach(System.out::println);
    }
}

