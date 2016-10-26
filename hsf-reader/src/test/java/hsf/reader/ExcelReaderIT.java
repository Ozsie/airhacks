package hsf.reader;

import static hsf.reader.ExcelReader.asDouble;
import static hsf.reader.ExcelReader.asLong;
import static hsf.reader.ExcelReader.asString;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ExcelReaderIT {

    @Test
    public void load() {
        Stream<RowPojo> pojoStream = ExcelReader.load(pojoMapper(), this.getClass(), "rowpojo");
        assertNotNull(pojoStream);
        List<RowPojo> pojos = pojoStream.collect(Collectors.toList());
        assertThat(pojos.size(), is(2));

        RowPojo actual = pojos.get(0);
        assertThat(actual.getFirst(), is("first"));
        assertThat(actual.getSecond(), is(2.2d));
        assertThat(actual.getThird(), is(3l));

        actual = pojos.get(1);
        assertThat(actual.getFirst(), is("second"));
        assertThat(actual.getSecond(), is(3.3d));
        assertThat(actual.getThird(), is(4l));
    }

    @Test(expected = IllegalStateException.class)
    public void notExistingFile() {
        ExcelReader.load(pojoMapper(), this.getClass(), "-does not exist-");
    }

    Function<Row, RowPojo> pojoMapper() {
        return (row) -> {
            Iterator<Cell> cells = row.cellIterator();
            return new RowPojo(
                    asString(cells.next()),
                    asDouble(cells.next()),
                    asLong(cells.next()));
        };
    }

}
