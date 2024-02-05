package com.example.ghidiemdanhbai;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ghidiemdanhbai.Model.Match;
import com.example.ghidiemdanhbai.Utils.StringUtils;
import com.example.ghidiemdanhbai.ViewModel.MatchViewModel;

import java.util.ArrayList;
import java.util.List;

public class MatchInfoAdapter extends ArrayAdapter<String> {
    private MatchViewModel matchViewModel;
    private Context context;
    private List<String> names;
    private List<String> results;

    public List<String> getNames() {
        return names;
    }

    public List<String> getResults() {
        return results;
    }

    public MatchInfoAdapter(Context context, MatchViewModel matchViewModel) {
        super(context, 0, StringUtils.convertStringToArrayList(matchViewModel.getGame().getGamePlayersNames()));
        names = StringUtils.convertStringToArrayList(matchViewModel.getGame().getGamePlayersNames());
        this.context = context;
        this.matchViewModel = matchViewModel;
        results = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            results.add("0");
        }
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
        etPlayerResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                results.set(position, etPlayerResult.getText().toString());
            }
        });

        return convertView;
    }
}
