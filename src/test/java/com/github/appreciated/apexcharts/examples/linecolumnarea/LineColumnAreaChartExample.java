package com.github.appreciated.apexcharts.examples.heatmap.linecolumnarea;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.config.builder.*;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.chart.builder.ZoomBuilder;
import com.github.appreciated.apexcharts.config.legend.HorizontalAlign;
import com.github.appreciated.apexcharts.config.series.SeriesType;
import com.github.appreciated.apexcharts.config.stroke.Curve;
import com.github.appreciated.apexcharts.config.subtitle.Align;
import com.github.appreciated.apexcharts.config.xaxis.XAxisType;
import com.github.appreciated.apexcharts.helper.Series;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LineColumnAreaChartExample extends ApexCharts {

    public LineColumnAreaChartExample() {
        withChart(
                ChartBuilder.get()
                        .withType(Type.line)
                        .withZoom(ZoomBuilder.get()
                                .withEnabled(false)
                                .build())
                        .build())
                .withColors("#008FFB", "#FEB019", "#775DD0")
                .withDataLabels(DataLabelsBuilder.get()
                        .withEnabled(false)
                        .build())
                .withStroke(StrokeBuilder.get().withCurve(Curve.straight).build())
                .withSeries(
                        new Series("Sales", SeriesType.column, 11.0, 14.0, 7.0, 2.0, 7.0, 15.0, 26.0, 19.0, 36.0),
                        new Series("INDEX XYZ", SeriesType.line, 30.0, 24.0, 28.0, 20.0, 32.0, 48.0, 88.0, 72.0, 68.0),
                        new Series("Volumne", SeriesType.area, 41.0, 65.0, 72.0, 74.0, 81.0, 96.0, 132.0, 151.0, 187.0))
                .withFill(FillBuilder.get()
                        .withType("solid")
                        .withOpacity(1.0, 1.0, 0.35)
                        .build())
                .withTitle(TitleSubtitleBuilder.get()
                        .withText("Fundamental Analysis of Stocks")
                        .withAlign(Align.left).build())
                .withSubtitle(TitleSubtitleBuilder.get()
                        .withText("Price Movements")
                        .withAlign(Align.left).build())
                .withLabels(IntStream.range(1, 10).boxed().map(day -> LocalDate.of(2000, 1, day).toString()).toArray(String[]::new))
                .withXaxis(XAxisBuilder.get()
                        .withType(XAxisType.datetime).build())
                .withYaxis(YAxisBuilder.get()
                        .withOpposite(false).build())
                .withLegend(LegendBuilder.get().withHorizontalAlign(HorizontalAlign.left).build());
    }
}