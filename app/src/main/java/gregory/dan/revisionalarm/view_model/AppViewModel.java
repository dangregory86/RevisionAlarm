package gregory.dan.revisionalarm.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import gregory.dan.revisionalarm.Room.Answer;
import gregory.dan.revisionalarm.Room.Question;
import gregory.dan.revisionalarm.Room.Subject;
import gregory.dan.revisionalarm.Room.repository.AppRepository;

/**
 * Created by Daniel Gregory on 21/09/2018.
 */
public class AppViewModel extends AndroidViewModel {
    private AppRepository mAppRepository;
    private LiveData<List<Subject>> mSubjects;


    public AppViewModel(@NonNull Application application) {
        super(application);
        mAppRepository = new AppRepository(application);
        mSubjects = mAppRepository.getmSubjects();
    }

    public LiveData<List<Subject>> getmSubjects() {
        return mSubjects;
    }

    public LiveData<List<Question>> getAllQuestions(long subjectId){
        return mAppRepository.getAllQuestions(subjectId);
    }

    public List<Question> getRandomQuestions(long subjectId){
        return mAppRepository.getRandomQuestions(subjectId);
    }

    public Answer getCorrectAnswer(long questonId){
        return mAppRepository.getCorrectAnswer(questonId);
    }

    public List<Answer> getRandomAnswers(long subjectId){
        return mAppRepository.getRandomAnswers(subjectId);
    }

    public void insertToDatabase(Object object){
        mAppRepository.insertToDatabase(object);
    }

    public void deleteFromDatabase(Object object){
        mAppRepository.deleteFromDb(object);
    }

    public void updateDatabase(Object object){
        mAppRepository.updateDbObject(object);
    }

    public void deleteAllSubjects(){
        mAppRepository.deleteAllSubjects();
    }
}
