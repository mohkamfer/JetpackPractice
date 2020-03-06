package com.mohkamfer.architecturespractice.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mohkamfer.architecturespractice.R;
import com.mohkamfer.architecturespractice.data.entity.Word;
import com.mohkamfer.architecturespractice.data.model.WordViewModel;

import java.util.List;


public class WordListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_word_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WordViewModel model = new ViewModelProvider(this).get(WordViewModel.class);

        RecyclerView wordList = view.findViewById(R.id.word_list);
        wordList.setLayoutManager(new LinearLayoutManager(getActivity()));
        final WordAdapter adapter = new WordAdapter(getActivity(), model.getWordList().getValue());
        wordList.setAdapter(adapter);

        model.getWordList().observe(getViewLifecycleOwner(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                adapter.swapData(words);
            }
        });
    }

    class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

        private Context context;
        private List<Word> data;

        WordAdapter(Context context, List<Word> data) {
            this.context = context;
            this.data = data;
        }

        void swapData(List<Word> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.word_row, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
            holder.word.setText(data.get(position).content);
        }

        @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private TextView word;

            ViewHolder(@NonNull View itemView) {
                super(itemView);

                word = itemView.findViewById(R.id.word_row_content);
            }
        }
    }
}
