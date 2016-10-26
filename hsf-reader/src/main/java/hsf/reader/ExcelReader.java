package hsf.reader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {

    /**
     * Loads a .xls file with the specified name from the
     * src/test/resources/[lower-test-class-name]/[file].xls and converts a Row
     * into a POJO using the mapper function.
     *
     * @param <T> the type of the converted row
     * @param mapper a function which maps a Row into a Pojo
     * @param testClass test class as naming convention for the test
     * @param file a name of the file without the .xls extension
     * @return a Stream<T> of mapped POJOs.
     */
    public static <T> Stream<T> load(Function<Row, T> mapper, Class testClass, String file) {
        String fileName = computeFileName(testClass, file);
        try (InputStream inp = new BufferedInputStream(new FileInputStream(fileName));) {
            try (HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp), false)) {
                HSSFSheet sheet = wb.getSheetAt(0);
                Stream<Row> stream = StreamSupport.stream(sheet.spliterator(), false);
                return stream.map(mapper);

            }
        } catch (IOException ex) {
            throw new IllegalStateException("Problems processing file: " + fileName, ex);
        }
    }

    /**
     * Computes the location of the excel file
     *
     * @param clazz
     * @param file
     * @return
     */
    static String computeFileName(Class clazz, String file) {
        return "src/test/resources/" + clazz.getSimpleName().toLowerCase() + "/" + file + ".xls";
    }

    /**
     * Assumes the Cell content is numeric and converts that into a Java double
     *
     * @param cell
     * @return Content converted into double or 0 if blank
     */
    public static double asDouble(Cell cell) {
        int type = cell.getCellType();
        switch (type) {
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            case Cell.CELL_TYPE_BLANK:
                return 0;
            default:
                throw new IllegalArgumentException("Unknown cell type: " + cell.getCellType());
        }
    }

    /**
     * Assumes the Cell content is text and converts it into a java.lang.String
     *
     * @param cell
     * @return Content converted into String or "" if blank
     */
    public static String asString(Cell cell) {
        int type = cell.getCellType();
        switch (type) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_BLANK:
                return "";
            default:
                throw new IllegalArgumentException("Unknown cell type: " + cell.getCellType());
        }
    }

    /**
     * Assumes the Cell content is numeric and converts it into a java.lang.Long
     *
     * @param cell
     * @return Content converted into Long or 0 if blank
     */
    public static long asLong(Cell cell) {
        int type = cell.getCellType();
        switch (type) {
            case Cell.CELL_TYPE_NUMERIC:
                return Math.round(cell.getNumericCellValue());
            case Cell.CELL_TYPE_BLANK:
                return 0;
            default:
                throw new IllegalArgumentException("Unknown cell type: " + cell.getCellType());
        }
    }

}
