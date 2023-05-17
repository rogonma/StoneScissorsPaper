package rogonma.challenges.StoneScissorsPaper;

public enum SSPMove {
	STONE(0), SCISSORS(1), PAPER(2);

	private final int value;

	private SSPMove(int value) {
		this.value = value;
	}

	public static SSPMove resolve(SSPMove moveX, SSPMove moveY) {
		SSPMove winner = null;
		switch ((moveY.value - moveX.value) % 3) {
		case 1:
			winner = moveX;
			break;
		case 2:
			winner = moveY;
			break;
		}

		return winner;
	}
}
