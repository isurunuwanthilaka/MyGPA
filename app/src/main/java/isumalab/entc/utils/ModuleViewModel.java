package isumalab.entc.utils;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import isumalab.entc.entity.ModuleEntity;

public class ModuleViewModel extends AndroidViewModel {

    private ModuleRepository mRepository;

    private LiveData<List<ModuleEntity>> mSemOneModules;
    private LiveData<List<ModuleEntity>> mSemTwoModules;
    private LiveData<List<ModuleEntity>> mSemThreeModules;
    private LiveData<List<ModuleEntity>> mSemFourModules;
    private LiveData<List<ModuleEntity>> mSemFiveModules;
    private LiveData<List<ModuleEntity>> mSemSixModules;
    private LiveData<List<ModuleEntity>> mSemSevenModules;
    private LiveData<List<ModuleEntity>> mSemEightModules;
    private LiveData<List<ModuleEntity>> mAllModules;

    public ModuleViewModel (Application application) {
        super(application);
        mRepository = new ModuleRepository(application);
        mSemOneModules = mRepository.getSemOneModules();
        mSemTwoModules = mRepository.getSemTwoModules();
        mSemThreeModules = mRepository.getSemThreeModules();
        mSemFourModules = mRepository.getSemFourModules();
        mSemFiveModules = mRepository.getSemFiveModules();
        mSemSixModules = mRepository.getSemSixModules();
        mSemSevenModules = mRepository.getSemSevenModules();
        mSemEightModules = mRepository.getSemEightModules();
        mAllModules = mRepository.getAllModules();
    }

    public LiveData<List<ModuleEntity>> getSemOneModules() { return mSemOneModules; }
    public LiveData<List<ModuleEntity>> getSemTwoModules() { return mSemTwoModules; }
    public LiveData<List<ModuleEntity>> getSemThreeModules() { return mSemThreeModules; }
    public LiveData<List<ModuleEntity>> getSemFourModules() { return mSemFourModules; }
    public LiveData<List<ModuleEntity>> getSemFiveModules() { return mSemFiveModules; }
    public LiveData<List<ModuleEntity>> getSemSixModules() { return mSemSixModules; }
    public LiveData<List<ModuleEntity>> getSemSevenModules() { return mSemSevenModules; }
    public LiveData<List<ModuleEntity>> getSemEightModules() { return mSemEightModules; }
    public LiveData<List<ModuleEntity>> getAllModules() { return mAllModules; }



    public void insert(ModuleEntity moduleEntity) { mRepository.insert(moduleEntity); }
    public void update(ModuleEntity moduleEntity) { mRepository.update(moduleEntity); }
    public void delete(ModuleEntity moduleEntity) { mRepository.delete(moduleEntity); }
}