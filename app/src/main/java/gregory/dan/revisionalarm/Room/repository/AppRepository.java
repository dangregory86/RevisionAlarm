package gregory.dan.revisionalarm.Room.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import gregory.dan.revisionalarm.Room.Answer;
import gregory.dan.revisionalarm.Room.AppDatabase;
import gregory.dan.revisionalarm.Room.Question;
import gregory.dan.revisionalarm.Room.Subject;
import gregory.dan.revisionalarm.Room.SubjectDao;

/**
 * Created by Daniel Gregory on 21/09/2018.
 */
public class AppRepository {

    private AppDatabase mDatabase;
    private LiveData<List<Subject>> mSubjects;

    public AppRepository(Application application) {
        mDatabase = AppDatabase.getInMemoryDatabase(application);
        mSubjects = mDatabase.subjectModel().loadAllSubjects();
    }

//    The following functions all pertain to the subjects

    public LiveData<List<Subject>> getmSubjects() {
        return mSubjects;
    }

//    The following functions pertain to the questions
    public LiveData<List<Question>> getAllQuestions(long subjectId){
        return mDatabase.questionModel().loadAllQs(subjectId);
    }

    public List<Question> getRandomQuestions(long subjectId){
        return mDatabase.questionModel().loadRandomQs(subjectId);
    }

//    The following functions pertain to the answers
    public Answer getCorrectAnswer(long questionId){
        return mDatabase.answerModel().loadCorrectAnswer(questionId);
    }

    public List<Answer> getRandomAnswers(long subjectId){
        return mDatabase.answerModel().loadRandomAnswers(subjectId);
    }

    public void insertToDatabase(Object object){
        new InsertAsyncTask(mDatabase).execute(object);
    }

    private static class InsertAsyncTask extends AsyncTask<Object, Void, Void>{
        AppDatabase appDatabase;
        InsertAsyncTask(AppDatabase appDatabase){
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Object... objects) {

           if(Subject.class.isInstance(objects[0])){
               appDatabase.subjectModel().insertSubject((Subject) objects[0]);
           }else if(Question.class.isInstance(objects[0])){
               appDatabase.questionModel().insertQ((Question) objects[0]);
           }else if(Answer.class.isInstance(objects[0])){
               appDatabase.answerModel().insertAnswer((Answer) objects[0]);
           }
            return null;
        }
    }

    public void deleteFromDb(Object object){
        new DeleteAsyncTask(mDatabase).execute(object);
    }

    private static class DeleteAsyncTask extends AsyncTask<Object, Void, Void>{
        AppDatabase appDatabase;
        DeleteAsyncTask(AppDatabase appDatabase){
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Object... objects) {
            if(Subject.class.isInstance(objects[0])){
                appDatabase.subjectModel().deleteSubject((Subject) objects[0]);
            }else if(Question.class.isInstance(objects[0])){
                appDatabase.questionModel().deleteQ((Question) objects[0]);
            }
            return null;
        }
    }


    public void updateDbObject(Object object){
        new UpdateAsyncTask(mDatabase).execute(object);
    }

    private static class UpdateAsyncTask extends AsyncTask<Object, Void, Void>{
        AppDatabase appDatabase;
        UpdateAsyncTask(AppDatabase appDatabase){
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Object... objects) {
            if(Subject.class.isInstance(objects[0])){
                appDatabase.subjectModel().updateSubject((Subject) objects[0]);
            }else if(Question.class.isInstance(objects[0])){
                appDatabase.questionModel().updateQ((Question) objects[0]);
            }else if(Answer.class.isInstance(objects[0])){
                appDatabase.answerModel().updateAnswer((Answer) objects[0]);
            }
            return null;
        }
    }

    public void deleteAllSubjects(){
        new DeleteAllAsyncTask(mDatabase.subjectModel()).execute();
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void>{
        SubjectDao dao;
        DeleteAllAsyncTask(SubjectDao subjectDao){
            dao = subjectDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllSubjects();
            return null;
        }
    }
}
