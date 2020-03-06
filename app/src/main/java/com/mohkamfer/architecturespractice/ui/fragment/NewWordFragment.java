package com.mohkamfer.architecturespractice.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mohkamfer.architecturespractice.R;
import com.mohkamfer.architecturespractice.data.entity.Word;
import com.mohkamfer.architecturespractice.data.model.WordViewModel;
import com.mohkamfer.architecturespractice.ui.activity.MainActivity;


public class NewWordFragment extends Fragment {

    private WordViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model = new ViewModelProvider(this).get(WordViewModel.class);

        view.findViewById(R.id.new_word_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClick(view);
            }
        });
    }

    private void handleOnClick(View view) {
        EditText wordInput = view.findViewById(R.id.word_input);
        String wordValue = wordInput.getText().toString();
        if (!wordValue.isEmpty()) {
            model.insert(new Word(wordValue));
            getActivity().onBackPressed();
        }
    }
}
