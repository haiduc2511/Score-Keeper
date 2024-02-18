package com.example.ghidiemdanhbai.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ghidiemdanhbai.Model.Match;
import com.example.ghidiemdanhbai.R;
import com.example.ghidiemdanhbai.Utils.StringUtils;
import com.example.ghidiemdanhbai.ViewModel.MatchViewModel;

import java.util.ArrayList;
import java.util.List;

public class MatchInfoAdapter extends ArrayAdapter<String> {
    private MatchViewModel matchViewModel;
    private Context context;
    private List<String> names;
    private List<String> results;
    private String[] numbers;
    private List<EditText> editTextList;
    private boolean indexAdded = false;

    public List<String> getNames() {
        return names;
    }

    public List<String> getResultsAndAddIndex() {
        if (!indexAdded) {
            results.add(0, Integer.toString(matchViewModel.getMatches().size() + 1));
        } else {
            results.set(0, Integer.toString(matchViewModel.getMatches().size() + 1));
        }
        return results;
    }


    public MatchInfoAdapter(Context context, MatchViewModel matchViewModel) {
        super(context, 0, StringUtils.convertStringToArrayList(matchViewModel.getGame().getGamePlayersNames()));
        names = StringUtils.convertStringToArrayList(matchViewModel.getGame().getGamePlayersNames());
        this.context = context;
        this.matchViewModel = matchViewModel;
        numbers = context.getResources().getStringArray(R.array.numbers);
        results = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            results.add("0");
        }
        editTextList = new ArrayList<>();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = names.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_match_info, parent, false);
        }

        TextView tvPlayerName = convertView.findViewById(R.id.tv_match_ìnfo_player_name);
        tvPlayerName.setText(name);

        EditText etPlayerResult = convertView.findViewById(R.id.et_match_info_player_result);
        etPlayerResult.setText("0");
        editTextList.add(etPlayerResult);

        NumberPicker numberPicker = convertView.findViewById(R.id.np_match_info_player_result_2);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(40);
        numberPicker.setValue(20);
        numberPicker.setDisplayedValues(numbers);
        numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            etPlayerResult.setText(numbers[newVal]);
            results.set(position, etPlayerResult.getText().toString());
        });

        return convertView;
    }
}
