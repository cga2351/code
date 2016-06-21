package com.example;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {
    public static void main(String[] args) {



        Schema schema = new Schema(1, "aaa.bbb.ccc");

        addNote(schema);

        try {
            new DaoGenerator().generateAll(schema, "greendaogenerator/ddd/eee");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addNote(Schema schema) {

        Entity note = schema.addEntity("tabel_1_note");



        note.addIdProperty();
        note.addStringProperty("prop_1_text").notNull();

        note.addStringProperty("prop_2_comment");
        note.addDateProperty("prop_3_date");
    }


}
