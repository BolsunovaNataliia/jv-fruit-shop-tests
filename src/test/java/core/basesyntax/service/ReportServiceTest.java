package core.basesyntax.service;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportServiceTest {
    private static final String HEAD_REPORT = "fruit,quantity";
    private static final String REGEX_COMMA = ",";
    private static final String ROW_OF_INPUT_DATA = "apple,110";
    private static final int ROW_OF_INPUT_DATA_INDEX = 1;
    private static final int HEAD_REPORT_INDEX = 0;
    private static final Map<String, Integer> data = Map.of(
            "apple", 110,
            "banana", 90
    );
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        reportService = new ReportService();
    }

    @Test
    void inputNull_notOk() {
        Assertions.assertThrows(RuntimeException.class,
                () -> reportService.generateReport(null));
    }

    @Test
    void validReport_Ok() {
        List<String> report = reportService.generateReport(data);
        Assertions.assertEquals(ROW_OF_INPUT_DATA, report.get(ROW_OF_INPUT_DATA_INDEX));
    }

    @Test
    void checkHeadReport_Ok() {
        List<String> report = reportService.generateReport(data);
        Assertions.assertEquals(HEAD_REPORT, report.get(HEAD_REPORT_INDEX));
    }

    @Test
    void checkComma_Ok() {
        List<String> report = reportService.generateReport(data);
        Assertions.assertTrue(report.get(0).contains(REGEX_COMMA));
    }
}
