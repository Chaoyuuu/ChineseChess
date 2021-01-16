package view;

import controller.Presenter;
import chess.Chess;
import chess.ChessColor;
import chess.General;
import game.ChessBoard;
import game.StandardChessBoard;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static view.ChessListViewModel.toViewModel;
import static view.Player.BLACK_PLAYER;
import static view.Player.RED_PLAYER;

public class GUI extends JFrame implements View {
    private List<ViewObserver> observerList = new ArrayList<>();
    private Canvas canvas = new Canvas();
    private final Map<String, Image> chessImages = new HashMap<>();
    private final Map<Player, Image> selectedBoxImages = new HashMap<>();
    private final Map<Media, File> audioFiles = new HashMap<>();
    private List<SelectedBox> selectedChessBoxes = new ArrayList<>();
    private SelectedBox motionSelectedBox;
    private ChessListViewModel chessListViewModel;
    private Point selectPoint, nextPoint;
    private Player player;

    public void launch(Presenter presenter, ChessListViewModel chessListViewModel) {
        this.player = RED_PLAYER;
        this.chessListViewModel = chessListViewModel;
        this.motionSelectedBox = new SelectedBox(new Point());
        setupChessImage();
        setupSelectedBoxImages();
        setupAudioMediaFile();
        setupCanvas();
        presenter.chess$.subscribe(this::drawChessOnCanvas);
        presenter.audio$.subscribe(this::playSounds);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                drawMotionSelectedBox(e.getPoint());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                drawSelectedBoxAndSelectChess(e.getPoint());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    observerList.forEach(ViewObserver::onUndoChess);
                }
            }
        });
    }

    private void setupCanvas() {
        setContentPane(canvas);
        setSize(600, 750);
        setLocation(200, 200);
        setVisible(true);
    }

    private void drawChessOnCanvas(ChessListViewModel chessList) {
        this.chessListViewModel = chessList;
        canvas.repaint();
        changePlayer();
    }

    public void drawMotionSelectedBox(Point point) {
        motionSelectedBox.setPoint(point);
        canvas.repaint();
    }

    private void changePlayer() {
        this.player = player == BLACK_PLAYER ? RED_PLAYER : BLACK_PLAYER;
    }

    private void drawSelectedBoxAndSelectChess(Point point) {
        if (selectedChessBoxes.size() == 0) {
            selectedChessBoxes.add(new SelectedBox(point));
            selectPoint = point;
        } else if (selectedChessBoxes.size() == 1) {
            selectedChessBoxes.add(new SelectedBox(point));
            nextPoint = point;
            observerList.forEach(o -> o.onMoveChess(selectPoint, nextPoint));
            selectedChessBoxes.clear();
        } else {
            System.out.println("SelectedBoxAndSelectChess");
        }
    }

    public void playSounds(Media audio) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getAudioMediaFile(audio)));
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private class Canvas extends JPanel {
        Image chessBoardImage = new ImageIcon("chessboard.png").getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(chessBoardImage, 0, 0, null);
            paintChess(g);
            paintMotionSelectedBox(g);
            paintSelectedBox(g);
        }

        private void paintMotionSelectedBox(Graphics g) {
            g.drawImage(getSelectedBoxImage(player), motionSelectedBox.getX(), motionSelectedBox.getY(), null);
        }

        private void paintSelectedBox(Graphics g) {
            selectedChessBoxes.forEach(s -> g.drawImage(getSelectedBoxImage(player), s.getX(), s.getY(), null));
        }

        private void paintChess(Graphics g) {
            List<ChessViewModel> chessList = chessListViewModel.chessList;
            chessList.forEach(c -> g.drawImage(getChessImage(c), c.x, c.y, null));
        }
    }

    @Override
    public void addObserver(ViewObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(ViewObserver observer) {
        observerList.remove(observer);
    }

    private void setupAudioMediaFile() {
        audioFiles.put(Media.CHECKMATE, new File("media/checkmate.wav"));
        audioFiles.put(Media.ERROR, new File("media/error.wav"));
        audioFiles.put(Media.GAME_OVER, new File("media/gameover.wav"));
        audioFiles.put(Media.PUT, new File("media/put.wav"));
    }

    private File getAudioMediaFile(Media media) {
        return audioFiles.get(media);
    }

    private void setupSelectedBoxImages() {
        selectedBoxImages.put(RED_PLAYER, new ImageIcon("selected_red.png").getImage());
        selectedBoxImages.put(BLACK_PLAYER, new ImageIcon("selected_black.png").getImage());
    }

    private Image getSelectedBoxImage(Player player) {
        return selectedBoxImages.get(player);
    }

    private void setupChessImage() {
        chessImages.put("black.chess.General", newChessImage("chess/black_general.png"));
        chessImages.put("black.chess.Cannon", newChessImage("chess/black_cannon.png"));
        chessImages.put("black.chess.Elephant", newChessImage("chess/black_elephant.png"));
        chessImages.put("black.chess.Horse", newChessImage("chess/black_knight.png"));
        chessImages.put("black.chess.Rook", newChessImage("chess/black_rook.png"));
        chessImages.put("black.chess.Pawn", newChessImage("chess/black_pawn.png"));
        chessImages.put("black.chess.Knight", newChessImage("chess/black_advisor.png"));
        chessImages.put("red.chess.General", newChessImage("chess/red_general.png"));
        chessImages.put("red.chess.Cannon", newChessImage("chess/red_cannon.png"));
        chessImages.put("red.chess.Elephant", newChessImage("chess/red_elephant.png"));
        chessImages.put("red.chess.Horse", newChessImage("chess/red_knight.png"));
        chessImages.put("red.chess.Rook", newChessImage("chess/red_rook.png"));
        chessImages.put("red.chess.Pawn", newChessImage("chess/red_pawn.png"));
        chessImages.put("red.chess.Knight", newChessImage("chess/red_advisor.png"));
    }

    private Image getChessImage(ChessViewModel chess) {
        return chessImages.get(chess.chessName);
    }

    private Image newChessImage(String path) {
        return resize(new ImageIcon(path).getImage());
    }

    private Image resize(Image chess) {
        return new ImageIcon(chess.getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();
    }

    public static void main(String[] args) { //262, 20
        Chess[] chessList = {new General(ChessColor.RED, new Point(4, 0)),
                new General(ChessColor.BLACK, new Point(4, 9))};
        ChessBoard chessBoard = new StandardChessBoard();
        GUI view = new GUI();
        Presenter presenter = new Presenter(chessBoard, view);
        view.launch(presenter, toViewModel(chessBoard.getChessList()));
//        view.playSounds(Media.ERROR);
    }
}
