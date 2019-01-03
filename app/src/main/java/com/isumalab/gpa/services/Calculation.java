package com.isumalab.gpa.services;

import android.app.Application;

import java.util.List;

import com.isumalab.gpa.dao.GpaStaticDao;
import com.isumalab.gpa.entity.GpaEntity;
import com.isumalab.gpa.entity.ModuleEntity;
import com.isumalab.gpa.utils.ModuleRoomDatabase;


public class Calculation {

    public void init(Application application){
        List<ModuleEntity> modules;
        ModuleRoomDatabase db = ModuleRoomDatabase.getDatabase(application);
        GpaStaticDao gpaStaticDao = db.gpaStaticDao();
        modules = gpaStaticDao.getAllModuleEntity();
        gpaStaticDao.insert(countGpa(9, modules));
        for (int sem_no=1;sem_no<=8;sem_no++){
            modules = gpaStaticDao.getSemModuleEntity(sem_no);
            gpaStaticDao.insert(countGpa(sem_no,modules));
        }
    }

    public GpaEntity countGpa(int semNo,List<ModuleEntity> modules){

        double temp = 0;
        double tot_credit = 0;
        double result = 0;

        if (!modules.isEmpty()){
            for (ModuleEntity module:modules){
                temp += module.getScore() * module.getCredit();
                tot_credit += module.getCredit();
            }
            result = round(temp / tot_credit,2);
        }

        GpaEntity gpaEntity = new GpaEntity();
        gpaEntity.setId(semNo);
        gpaEntity.setInfo("Gpa for sem " + String.valueOf(semNo));
        gpaEntity.setGpa(result);
        return gpaEntity;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
