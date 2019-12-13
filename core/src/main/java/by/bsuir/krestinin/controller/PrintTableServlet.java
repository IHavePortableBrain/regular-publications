package by.bsuir.krestinin.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.Format;
import java.util.*;
import java.util.stream.Collectors;

import by.bsuir.krestinin.dao.api.PublicationDAO;
import by.bsuir.krestinin.dao.impl.xml.*;
import by.bsuir.krestinin.entity.Publication;
import by.bsuir.krestinin.service.validator.PublicationValidator;
import javafx.util.Pair;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

@WebServlet(name = "PrintTableServlet", urlPatterns = "/table")
public class PrintTableServlet extends HttpServlet {
    private static final String tmpXMLPath = "tmp.xml";
    private static final int maxFileSize = 5000 * 1024;
    private static final int maxMemSize = 5000 * 1024;

    private static final Logger log = Logger.getLogger(PrintTableServlet.class);

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        log.info("Request URL " + request.getRequestURL());

        String contentType = request.getContentType();

        if ((contentType.contains("multipart/form-data"))) {
            DiskFileItemFactory factory = new DiskFileItemFactory();

            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File(System.getProperty("user.dir")));
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);

            Enumeration<String> parameterNames = request.getParameterNames();

            try {
                Iterator<FileItem> fieldsIterator = upload.parseRequest(request).iterator();
                FileItem fi = fieldsIterator.next();
                String xmlType = fieldsIterator.next().getString();

                File f = new File(tmpXMLPath);
                fi.write(f);

                PublicationXmlDAO dao;

                switch (xmlType) {
                    case "Author":
                        dao = new AuthorXmlDAO(f);
                        break;
                    case "Calendar":
                        dao = new CalendarXmlDAO(f);
                        break;
                    case "Catalog":
                        dao = new CatalogXmlDAO(f);
                        break;
                    case "Event":
                        dao = new EventXmlDAO(f);
                        break;
                    case "Journal":
                        dao = new JournalXmlDAO(f);
                        break;
                    case "Newspaper":
                        dao = new NewspaperXmlDAO(f);
                        break;
                    default:
                        throw new Exception();
                }

                Publication[] publications = dao.readAll();
                Map<String, Method> getMethodByFieldName = new HashMap<>();


                List<Class<? extends Publication>> classesToScan = new ArrayList<>();
                List<Field> fieldsWithGetter = new ArrayList<>();

                classesToScan.add(publications[0].getClass());
                classesToScan.add(Publication.class);

                for (Class<? extends Publication> aClass:
                        classesToScan) {
                    fieldsWithGetter.addAll(
                            Arrays.stream(aClass.getDeclaredFields()).filter(field -> {
                            try {
                                Method getter = aClass.getMethod("get" + StringUtils.capitalize(field.getName()));

                                if (!Modifier.isFinal(field.getModifiers()) &&
                                        Modifier.isPublic(getter.getModifiers())) {
                                    getMethodByFieldName.put(field.getName(), getter);
                                    return true;
                                }
                            } catch (NoSuchMethodException e) {
                                return false;
                            }
                            return false;
                        }).collect(Collectors.toList())
                    );
                }

                request.setAttribute("publications", publications);
                request.setAttribute("fieldsWithGetter", fieldsWithGetter);
                request.setAttribute("getMethodByFieldName", getMethodByFieldName);

                request.getRequestDispatcher("/index.jsp").forward(request, response);

            } catch (Exception e) {
                log.error("Exception: " + e.getMessage());
                request.setAttribute("error", e);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

        }


    }
}
