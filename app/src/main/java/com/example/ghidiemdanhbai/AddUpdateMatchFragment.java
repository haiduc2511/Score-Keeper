package com.example.ghidiemdanhbai;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ghidiemdanhbai.Model.Match;
import com.example.ghidiemdanhbai.Utils.StringUtils;
import com.example.ghidiemdanhbai.ViewModel.GameViewModel;
import com.example.ghidiemdanhbai.ViewModel.MatchViewModel;

public class AddUpdateMatchFragment extends Fragment {
    private MatchViewModel matchViewModel;
    private GameViewModel gameViewModel;
    private MatchInfoAdapter adapter;
    private GridView lvMatchInfos;
    private Button btConfirm;
    private Context context;

    public AddUpdateMatchFragment(Context context, MatchViewModel matchViewModel, GameViewModel gameViewModel) {
        this.context = context;
        this.matchViewModel = matchViewModel;
        this.gameViewModel = gameViewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_update_match, container, false);

        View underLayMatch = view.findViewById(R.id.under_lay_match_infos);
        underLayMatch.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });
        View overLayMatch = view.findViewById(R.id.over_lay_match_infos);
        overLayMatch.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "u r baming Student fragment", Toast.LENGTH_SHORT).show();
        });

        lvMatchInfos = view.findViewById(R.id.lv_match_infos);
        MatchInfoAdapter adapter = new MatchInfoAdapter(context, matchViewModel);
        lvMatchInfos.setAdapter(adapter);

        btConfirm = view.findViewById(R.id.bt_confirm);
        btConfirm.setOnClickListener(v -> {
            matchViewModel.addNewMatch(
                    new Match(matchViewModel.getGame().getGameId(),
                            matchViewModel.getGame().getGamePlayersNames(),
                            StringUtils.convertArrayListToString(adapter.getResults())));
        });

        return view;
    }
}