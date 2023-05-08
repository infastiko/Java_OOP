package Task_7.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final DateTimeFormatter OPERATION_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final String LOG_FILE_NAME = "log_file.txt";
    private static final PrintWriter LOG_WRITER;

    static {
        try {
            LOG_WRITER = new PrintWriter(new FileWriter(LOG_FILE_NAME, true));
        } catch (IOException e) {
            throw new RuntimeException("Cannot open log file: " + LOG_FILE_NAME, e);
        }
    }

    public static void logWrite(String note, Object messageText) {
        String operationTime = LocalTime.now().format(OPERATION_TIME_FORMATTER);
        LOG_WRITER.println(operationTime + " " + note + "\n" + messageText);
        LOG_WRITER.flush();
    }
}
