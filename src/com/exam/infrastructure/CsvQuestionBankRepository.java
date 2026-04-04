package com.exam.infrastructure;

import com.exam.domain.model.*;
import com.exam.domain.model.QuestionTypes.*;

import java.io.*;
import java.util.*;

public class CsvQuestionBankRepository {

    public List<Question> load(String path) throws Exception {

        List<Question> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {

            String[] p = line.split(";");

            switch (p[0]) {

                case "UNICA":
                    list.add(new UniqueChoice(
                            UUID.randomUUID().toString(),
                            p[1],
                            Arrays.asList(p[2].split(",")),
                            p[3]
                    ));
                    break;

                case "VF":
                    list.add(new TrueFalse(
                            UUID.randomUUID().toString(),
                            p[1],
                            p[2].equals("V")
                    ));
                    break;
            }
        }

        return list;
    }
}