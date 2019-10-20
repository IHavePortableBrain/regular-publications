package by.bsuir.krestinin.dao.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class DAOFileUtils {
    private static final String UTF_8 = StandardCharsets.UTF_8.name();

    public static String readFile(String pathToFile) throws IOException {
        final File file = FileUtils.getFile(pathToFile);

        return file.exists() ? FileUtils.readFileToString(file, UTF_8) : null;
    }

    public static void writeStringToFile(String text, String pathToFile) throws IOException {
        final File newFile = new File(pathToFile);

        FileUtils.touch(newFile);

        FileUtils.writeStringToFile(newFile, text, UTF_8);
    }


}
