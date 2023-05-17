package rogonma.challenges.StoneScissorsPaper;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssp")
public class GameServer {
	@GetMapping("/move")
	public String updateUser(@RequestParam String move) {
		try {
			SSPMove playerMove = SSPMove.valueOf(move);
			SSPMove machineMove = generateMove();
			SSPMove winner = SSPMove.resolve(playerMove, machineMove);

			if (winner == playerMove) {
				return "YOU WIN";
			}
			if (winner == machineMove) {
				return "YOU LOSE";
			}
			return "TIE";
		} catch (Exception e) {
			return "NOT VALID MOVE";
		}

	}

	private SSPMove generateMove() {
		Random random = new Random();

		SSPMove[] values = SSPMove.values();
		SSPMove move = values[random.nextInt(values.length)];
		return move;
	}
}