import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;

/**
 * ArithmeticGameLayout
 * - Level 1: 1-100
 * - Level 2: 101-200
 * - Level 3: 201-300
 * - Operation and Level radio buttons regenerate a new problem when selected
 * - Correct / Incorrect counters cumulative across levels
 * - Motivational messages on correct answers (random)
 * - Roast messages on wrong answers (random)
 * - Pause, Continue, Skip implemented
 *
 * Note: put optional sound files "correct.wav" and "wrong.wav" in the working folder if you want sounds.
 */
public class ArithmeticGameLayout extends JFrame {

    // UI components
    private final JLabel num1Label = new JLabel("0", SwingConstants.CENTER);
    private final JLabel operatorLabel = new JLabel("+", SwingConstants.CENTER);
    private final JLabel num2Label = new JLabel("0", SwingConstants.CENTER);
    private final JTextField answerField = new JTextField();
    private final JButton submitButton = new JButton("SUBMIT");
    private final JButton pauseButton = new JButton("PAUSE");
    private final JButton skipButton = new JButton("SKIP");

    private final JLabel correctScoreLabel = new JLabel("Correct: 0", SwingConstants.CENTER);
    private final JLabel incorrectScoreLabel = new JLabel("Incorrect: 0", SwingConstants.CENTER);

    // Operation radios
    private final JRadioButton addRadio = new JRadioButton("Addition", true);
    private final JRadioButton subRadio = new JRadioButton("Subtraction");
    private final JRadioButton mulRadio = new JRadioButton("Multiplication");
    private final JRadioButton divRadio = new JRadioButton("Division");
    private final JRadioButton modRadio = new JRadioButton("Modulus");

    // Level radios
    private final JRadioButton lvl1Radio = new JRadioButton("Level 1: 1–10", true);
    private final JRadioButton lvl2Radio = new JRadioButton("Level 2: 11–20");
    private final JRadioButton lvl3Radio = new JRadioButton("Level 3: 21–30");

    // Game state
    private final Random random = new Random();
    private int num1 = 0;
    private int num2 = 0;
    private String operator = "+";
    private int correctCount = 0;
    private int incorrectCount = 0;
    private boolean paused = false;

    // Feedback messages
    private final String[] motivates = {
        "Great job!", "Nice work!", "Correct, keep it up!", "Well done!", "You nailed it!"
    };
    private final String[] roasts = {
        "Wrong. Try harder.", "Nope. That was weak.", "Oof, not even close.", "You missed that one.", "Nice try, fail."
    };

    // Optional sound clips (set to null if files not present)
    private Clip clipCorrect = null;
    private Clip clipWrong = null;
    private Clip clipBGM = null;
    private boolean bgmPlaying = false;
    private FloatControl volumeControl = null;

    public ArithmeticGameLayout() {
        super("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setMinimumSize(new Dimension(800, 600));
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(250, 250, 250));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buildUI();
        loadSounds();
        wireEvents();
        generateProblem();
        setLocationRelativeTo(null);
        setVisible(true);

        // start BGM when the game starts
        playBGMLoop();
    }

    private void buildUI() {
        // TOP PANEL: Problem display
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(new Color(250, 250, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        // num1Label
        num1Label.setFont(new Font("SansSerif", Font.BOLD, 48));
        num1Label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        num1Label.setOpaque(true);
        num1Label.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.25;
        gbc.weighty = 1.0;
        topPanel.add(num1Label, gbc);

        // operatorLabel
        operatorLabel.setFont(new Font("SansSerif", Font.BOLD, 48));
        gbc.gridx = 1;
        gbc.weightx = 0.15;
        topPanel.add(operatorLabel, gbc);

        // num2Label
        num2Label.setFont(new Font("SansSerif", Font.BOLD, 48));
        num2Label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        num2Label.setOpaque(true);
        num2Label.setBackground(Color.WHITE);
        gbc.gridx = 2;
        gbc.weightx = 0.25;
        topPanel.add(num2Label, gbc);

        // eqLabel
        JLabel eqLabel = new JLabel("=", SwingConstants.CENTER);
        eqLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        gbc.gridx = 3;
        gbc.weightx = 0.1;
        topPanel.add(eqLabel, gbc);

        // answerField
        answerField.setFont(new Font("SansSerif", Font.BOLD, 40));
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        gbc.gridx = 4;
        gbc.weightx = 0.25;
        topPanel.add(answerField, gbc);

        // MIDDLE PANEL: Controls
        JPanel midPanel = new JPanel(new GridBagLayout());
        midPanel.setBackground(new Color(250, 250, 250));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        // Operation panel
        JPanel opPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        opPanel.setBorder(BorderFactory.createTitledBorder("OPERATION"));
        opPanel.add(addRadio);
        opPanel.add(subRadio);
        opPanel.add(mulRadio);
        opPanel.add(divRadio);
        opPanel.add(modRadio);


        ButtonGroup opGroup = new ButtonGroup();
        opGroup.add(addRadio);
        opGroup.add(subRadio);
        opGroup.add(mulRadio);
        opGroup.add(divRadio);
        opGroup.add(modRadio);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        midPanel.add(opPanel, gbc);

        // Level panel
        JPanel levelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        levelPanel.setBorder(BorderFactory.createTitledBorder("LEVELS"));
        levelPanel.add(lvl1Radio);
        levelPanel.add(lvl2Radio);
        levelPanel.add(lvl3Radio);

        ButtonGroup lvlGroup = new ButtonGroup();
        lvlGroup.add(lvl1Radio);
        lvlGroup.add(lvl2Radio);
        lvlGroup.add(lvl3Radio);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        midPanel.add(levelPanel, gbc);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder("ACTIONS"));
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        pauseButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        skipButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        buttonsPanel.add(submitButton);
        buttonsPanel.add(pauseButton);
        buttonsPanel.add(skipButton);

        gbc.gridx = 2;
        gbc.weightx = 0.2;
        midPanel.add(buttonsPanel, gbc);

        // BOTTOM PANEL: Score
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("SCORE"));

        correctScoreLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        correctScoreLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        correctScoreLabel.setOpaque(true);
        correctScoreLabel.setBackground(Color.WHITE);
        bottomPanel.add(correctScoreLabel);

        incorrectScoreLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        incorrectScoreLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
        incorrectScoreLabel.setOpaque(true);
        incorrectScoreLabel.setBackground(Color.WHITE);
        bottomPanel.add(incorrectScoreLabel);

        // ADD ALL TO FRAME
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void wireEvents() {
        // regenerate when user changes level or operation
        ActionListener regenListener = e -> {
            if (!paused) generateProblem();
        };

        addRadio.addActionListener(regenListener);
        subRadio.addActionListener(regenListener);
        mulRadio.addActionListener(regenListener);
        divRadio.addActionListener(regenListener);
        modRadio.addActionListener(regenListener);

        lvl1Radio.addActionListener(regenListener);
        lvl2Radio.addActionListener(regenListener);
        lvl3Radio.addActionListener(regenListener);
        

        // submit -> check answer
        submitButton.addActionListener(regenListener);
        submitButton.addActionListener(e -> {
            if (paused) return;
            stopBGM();
            checkAnswer();
        });


        // skip -> generate new problem without affecting score
        skipButton.addActionListener(e -> {
            if (paused) return;
            generateProblem();
            answerField.setText("");
            answerField.requestFocusInWindow();
        });

        // pause toggles
        pauseButton.addActionListener(e -> togglePause());

        // Enter key submits
        answerField.addActionListener(e -> {
            if (!paused) {
                stopBGM();
                checkAnswer();
            }
        });
    }

    private void togglePause() {
        paused = !paused;
        submitButton.setEnabled(!paused);
        skipButton.setEnabled(!paused);
        answerField.setEnabled(!paused);
        addRadio.setEnabled(!paused);
        subRadio.setEnabled(!paused);
        mulRadio.setEnabled(!paused);
        divRadio.setEnabled(!paused);
        modRadio.setEnabled(!paused);
        lvl1Radio.setEnabled(!paused);
        lvl2Radio.setEnabled(!paused);
        lvl3Radio.setEnabled(!paused);
        pauseButton.setText(paused ? "RESUME" : "PAUSE");

        if (paused) {
            stopBGM();
        } else {
            playBGMLoop();
        }
    }

    private void generateProblem() {
        // determine level range
        int min = 1, max = 10;
        if (lvl2Radio.isSelected()) { min = 11; max = 20; }
        else if (lvl3Radio.isSelected()) { min = 21; max = 30; }

        // pick operation
        if (addRadio.isSelected()) operator = "+";
        else if (subRadio.isSelected()) operator = "-";
        else if (mulRadio.isSelected()) operator = "*";
        else if (divRadio.isSelected()) operator = "/";
        else operator = "%";

        // pick numbers
        // For division/modulus ensure there is always a valid num2 < num1
        if (operator.equals("/") || operator.equals("%")) {
            // ensure num1 is at least min+1 so there's room for a smaller num2
            num1 = randInRange(Math.max(min + 1, min), max);
            // pick num2 in [min, num1-1]
            int low = Math.max(min, 1);
            int high = Math.max(Math.min(num1 - 1, max), low);
            num2 = randInRange(low, high);
            if (num2 == 0) num2 = 1;
        } else {
            num1 = randInRange(min, max);
            num2 = randInRange(min, max);
        }

        // set labels
        num1Label.setText(String.valueOf(num1));
        num2Label.setText(String.valueOf(num2));
        operatorLabel.setText(operatorSymbol(operator));
    }

    private int randInRange(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    // try to find divisor of n within [min,max]
    private int findNonZeroDivisorInRange(int n, int min, int max) {
        for (int d = Math.max(1, min); d <= Math.min(n, max); d++) {
            if (d != 0 && n % d == 0) return d;
        }
        return -1;
    }

    private String operatorSymbol(String op) {
        return switch (op) {
            case "*" -> "×";
            case "/" -> "÷";
            default -> op;
        };
    }

    private void checkAnswer() {
        String text = answerField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter an answer.");
            // resume BGM immediately if no SFX available
            if (clipCorrect == null && clipWrong == null) playBGMLoop();
            return;
        }

        try {
            // use integer arithmetic for this game
            long userAns = Long.parseLong(text);
            long correctAns;
            switch (operator) {
                case "+" -> correctAns = (long) num1 + num2;
                case "-" -> correctAns = (long) num1 - num2;
                case "*" -> correctAns = (long) num1 * num2;
                case "/" -> correctAns = (long) (num1 / num2); // integer division; generation ensures valid divisor
                case "%" -> correctAns = (long) (num1 % num2);
                default -> correctAns = 0;
            }

            if (userAns == correctAns) {
                correctCount++;
                correctScoreLabel.setText("Correct: " + correctCount);
                // play SFX; BGM will resume after SFX finishes via LineListener in playClip
                playClip(clipCorrect);
                String msg = motivates[random.nextInt(motivates.length)];
                JOptionPane.showMessageDialog(this, msg);
                // auto-generate next problem
                generateProblem();
                answerField.setText("");
                // if no SFX available, resume immediately
                if (clipCorrect == null) playBGMLoop();
            } else {
                incorrectCount++;
                incorrectScoreLabel.setText("Incorrect: " + incorrectCount);
                playClip(clipWrong);
                String roast = roasts[random.nextInt(roasts.length)];
                JOptionPane.showMessageDialog(this, roast);
                // keep current problem so player can try again or skip
                if (clipWrong == null) playBGMLoop();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid integer answer.");
            if (clipCorrect == null && clipWrong == null) playBGMLoop();
        }
    }

    private void loadSounds() {
        // attempt to load three optional wav files
        try {
            File f1 = new File("correct.wav");
            File f2 = new File("Incorrect.wav");
            File f3 = new File("Quiz.wav");
            
            if (f1.exists()) {
                clipCorrect = AudioSystem.getClip();
                clipCorrect.open(AudioSystem.getAudioInputStream(f1));
            }
            if (f2.exists()) {
                clipWrong = AudioSystem.getClip();
                clipWrong.open(AudioSystem.getAudioInputStream(f2));
            }
            if (f3.exists()) {
                clipBGM = AudioSystem.getClip();
                clipBGM.open(AudioSystem.getAudioInputStream(f3));
                // setup volume control for BGM
                if (clipBGM.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    volumeControl = (FloatControl) clipBGM.getControl(FloatControl.Type.MASTER_GAIN);
                    // set initial volume to 80% (-2.5 dB)
                    setBGMVolume(0.8f);
                }
            }
        } catch (Exception ignored) {
        }
    }

    private void setBGMVolume(float volume) {
        if (volumeControl != null) {
            // volume range: 0.0 to 1.0
            // convert to dB: -80 to 0
            float dB = 2.0f * (float) Math.log10(Math.max(0.0001f, volume));
            volumeControl.setValue(dB);
        }
    }

    private void playBGMLoop() {
        if (clipBGM != null && !bgmPlaying && !paused) {
            try {
                clipBGM.setFramePosition(0);
                clipBGM.loop(Clip.LOOP_CONTINUOUSLY);
                bgmPlaying = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void stopBGM() {
        if (clipBGM != null && bgmPlaying) {
            try {
                clipBGM.stop();
                bgmPlaying = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void playClip(Clip clip) {
        if (clip != null) {
            try {
                // stop any existing playback and reset
                if (clip.isRunning()) clip.stop();
                clip.setFramePosition(0);

                // add a one-time LineListener to resume BGM after SFX ends
                LineListener[] holder = new LineListener[1];
                holder[0] = event -> {
                    if (event.getType() == LineEvent.Type.STOP || event.getType() == LineEvent.Type.CLOSE) {
                        // remove listener
                        clip.removeLineListener(holder[0]);
                        // resume BGM only if not paused
                        if (!paused) {
                            // small delay to ensure SFX system released resources before restarting BGM
                            SwingUtilities.invokeLater(this::playBGMLoop);
                        }
                    }
                };
                clip.addLineListener(holder[0]);

                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
                // fallback: resume BGM if something goes wrong
                if (!paused) playBGMLoop();
            }
        } else {
            // if there's no SFX clip, resume BGM immediately
            if (!paused) playBGMLoop();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArithmeticGameLayout::new);
    }
}
