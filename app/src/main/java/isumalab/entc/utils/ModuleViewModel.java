package isumalab.entc.utils;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import isumalab.entc.entity.GpaEntity;
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
    private LiveData<Double> mOverallGpa;
    private LiveData<Double> mGpaSem1;
    private LiveData<Double> mGpaSem2;
    private LiveData<Double> mGpaSem3;
    private LiveData<Double> mGpaSem4;
    private LiveData<Double> mGpaSem5;
    private LiveData<Double> mGpaSem6;
    private LiveData<Double> mGpaSem7;
    private LiveData<Double> mGpaSem8;

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
        mOverallGpa = mRepository.getOverallGpaEntity();
        mGpaSem1 = mRepository.getGpaSem1();
        mGpaSem2 = mRepository.getGpaSem2();
        mGpaSem3 = mRepository.getGpaSem3();
        mGpaSem4 = mRepository.getGpaSem4();
        mGpaSem5 = mRepository.getGpaSem5();
        mGpaSem6 = mRepository.getGpaSem6();
        mGpaSem7 = mRepository.getGpaSem7();
        mGpaSem8 = mRepository.getGpaSem8();
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
    public LiveData<Double> getOverallGpa() { return mOverallGpa; }
    public LiveData<Double> getGpaSem1(){return mGpaSem1;}
    public LiveData<Double> getGpaSem2(){return mGpaSem2;}
    public LiveData<Double> getGpaSem3(){return mGpaSem3;}
    public LiveData<Double> getGpaSem4(){return mGpaSem4;}
    public LiveData<Double> getGpaSem5(){return mGpaSem5;}
    public LiveData<Double> getGpaSem6(){return mGpaSem6;}
    public LiveData<Double> getGpaSem7(){return mGpaSem7;}
    public LiveData<Double> getGpaSem8(){return mGpaSem8;}



    public void insert(ModuleEntity moduleEntity) { mRepository.insert(moduleEntity); }
    public void update(ModuleEntity moduleEntity) { mRepository.update(moduleEntity); }
    public void delete(ModuleEntity moduleEntity) { mRepository.delete(moduleEntity); }

    public void insert(GpaEntity gpaEntity) { mRepository.insert(gpaEntity); }
    public void update(GpaEntity gpaEntity) { mRepository.update(gpaEntity); }
    public void delete(GpaEntity gpaEntity) { mRepository.delete(gpaEntity); }
}