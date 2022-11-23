package ch.makery.address.controller;

import ch.makery.address.Main;
import ch.makery.address.model.BookingVO;
import ch.makery.address.model.ExcepcionBooking;
import ch.makery.address.model.Model;
import ch.makery.address.model.repository.BookingRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class OccupationStatisticsController {
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private CategoryAxis xAxis;
    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    private Model model;

    private BookingRepository bookingRep;
    private Main main;

    @FXML
    private void initialize() {
        String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        monthNames.addAll(Arrays.asList(months));

        xAxis.setCategories(monthNames);
    }

    public void setData(List<BookingVO> bookings) {
        int[] monthCounter = new int[12];
        for (BookingVO b : bookings) {
            int month = b.getFechEntrada().toLocalDate().getMonthValue() - 1;
            monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }

        barChart.getData().add(series);
    }


    public Model getModel(){
        return this.model;
    }

    public void setModel(Model model){
        this.model = model;
    }

    ArrayList<BookingVO> lista;


    public void cargar() throws ExcepcionBooking {
        this.lista = this.model.loadFullBookingList();
    }

    public ArrayList<BookingVO> getLista(){
        return this.lista;
    }

    @FXML
    private void handleGoBack(){
        main.showClientOverview();
    }

    public void setMain(Main main){
        this.main = main;
    }
}
