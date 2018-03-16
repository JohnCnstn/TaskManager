package com.johncnstn.view;

import com.johncnstn.data.entity.User;
import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class CsvView extends AbstractCsvView {

    @Override
    public void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"all-users.csv\"");

        List<User> users = (List<User>) model.get("users");
        String[] header = {"Username", "FirstName", "LastName", "Email"};
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(header);

        for(User user : users){
            csvWriter.write(user, header);
        }
        csvWriter.close();


    }
}
