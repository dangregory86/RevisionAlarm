package gregory.dan.revisionalarm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import gregory.dan.revisionalarm.Room.Subject;
import gregory.dan.revisionalarm.view_model.AppViewModel;

import static android.support.constraint.Constraints.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private List<Subject> mSubjects;
    private AppViewModel mViewModel;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        mViewModel.getmSubjects().observe(this, new Observer<List<Subject>>() {
            @Override
            public void onChanged(@Nullable List<Subject> subjects) {
                mSubjects = subjects;
                Log.d(TAG, "onChanged: " + subjects.toString());
            }
        });

        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
