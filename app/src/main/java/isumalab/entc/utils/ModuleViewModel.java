package isumalab.entc.utils;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import isumalab.entc.entity.ModuleEntity;

public class ModuleViewModel extends AndroidViewModel {

    private ModuleRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<ModuleEntity>> mSemOneModules;
    private LiveData<List<ModuleEntity>> mSemTwoModules;
    private LiveData<List<ModuleEntity>> mSemThreeModules;
    private LiveData<List<ModuleEntity>> mSemFourModules;
    private LiveData<List<ModuleEntity>> mSemFiveModules;
    private LiveData<List<ModuleEntity>> mSemSixModules;
    private LiveData<List<ModuleEntity>> mSemSevenModules;
    private LiveData<List<ModuleEntity>> mSemEightModules;

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
    }

    public LiveData<List<ModuleEntity>> getSemOneModules() { return mSemOneModules; }
    public LiveData<List<ModuleEntity>> getSemTwoModules() { return mSemTwoModules; }
    public LiveData<List<ModuleEntity>> getSemThreeModules() { return mSemThreeModules; }
    public LiveData<List<ModuleEntity>> getSemFourModules() { return mSemFourModules; }
    public LiveData<List<ModuleEntity>> getSemFiveModules() { return mSemFiveModules; }
    public LiveData<List<ModuleEntity>> getSemSixModules() { return mSemSixModules; }
    public LiveData<List<ModuleEntity>> getSemSevenModules() { return mSemSevenModules; }
    public LiveData<List<ModuleEntity>> getSemEightModules() { return mSemEightModules; }

    public void insert(ModuleEntity moduleEntity) { mRepository.insert(moduleEntity); }
}