package by.bsuir.krestinin;

import by.bsuir.krestinin.dao.util.DAOFileUtils;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DAOFileUtils.writeStringToFile("text", "applicationa.properties");
        System.out.println(DAOFileUtils.readFile("applicationa.properties"));
    }
}
