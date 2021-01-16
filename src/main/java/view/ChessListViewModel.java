package view;

import chess.Chess;

import java.util.ArrayList;
import java.util.List;

public class ChessListViewModel {
    public List<ChessViewModel> chessList;

    public ChessListViewModel(List<ChessViewModel> chessList) {
        this.chessList = chessList;
    }

    public static ChessListViewModel toViewModel(List<Chess> chessList) {
        List<ChessViewModel> chessViewModels = new ArrayList<>();
        chessList.forEach(c -> chessViewModels.add(ChessViewModel.toViewModel(c)));
        return new ChessListViewModel(chessViewModels);
    }
}
