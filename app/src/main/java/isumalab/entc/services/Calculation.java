package isumalab.entc.services;

import java.util.List;

import isumalab.entc.entity.GpaEntity;
import isumalab.entc.entity.ModuleEntity;
import isumalab.entc.utils.ModuleRepository;
import isumalab.entc.utils.ModuleViewModel;

public class Calculation {

    public void OverAllGpa(){
        List<ModuleEntity> modules;
        ModuleRepository moduleRepository =new ModuleRepository();
        modules = moduleRepository.getAllModuleEntity();
        double temp = 0;
        double tot_credit = 0;

        if (modules!=null){
            for (ModuleEntity module:modules){
                temp+=module.getScore() * module.getCredit();
                tot_credit += module.getCredit();
            }
            GpaEntity gpaEntity = new GpaEntity();
            gpaEntity.setId(9);
            gpaEntity.setInfo("Overall gpa");
            gpaEntity.setGpa(temp/tot_credit);
            moduleRepository.insert(gpaEntity);
        }else{
            GpaEntity gpaEntity = new GpaEntity();
            gpaEntity.setId(9);
            gpaEntity.setInfo("Overall gpa");
            gpaEntity.setGpa(0);
            moduleRepository.insert(gpaEntity);
        }
    }

}
