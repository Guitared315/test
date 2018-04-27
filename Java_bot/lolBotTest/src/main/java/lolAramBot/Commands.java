package lolAramBot;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.rithms.riot.api.RiotApiException;

public class Commands extends ListenerAdapter {

	private int ansNum;
	private boolean quizFlg;

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String[] command = event.getMessage().getContent().split(" ");
		List<String> commandList = Arrays.asList(command);

		QuizTest quiz = new QuizTest();

		EmbedBuilder eb = new EmbedBuilder();
		SumInfo sumInfo = new SumInfo();

		if (!command[0].startsWith(Ref.PREFIX))
			return;

		if (command[0].equalsIgnoreCase("!ping")) {
			String msg = "Pong!'" + event.getJDA().getPing() + "ms'";
			if (command.length == 1) {
				event.getChannel().sendMessage(msg).queue();
			} else if (command.length == 2 && command[1].equalsIgnoreCase("-e")) {
				eb = new EmbedBuilder();
				eb.setColor(Color.CYAN);
				eb.setDescription(msg);
				event.getChannel().sendMessage(eb.build()).queue();
			}
		}

		// �N�C�Y

		if (command[0].equalsIgnoreCase("!q") && command.length == 1
				&& quizFlg == false) {
			event.getChannel().sendMessage(quiz.quizDisp()).queue();
			setAnsNum(quiz.getAnsNum());
			setQuizFlg(quiz.isQuizFlg());
			
		}

		if (command[0].equalsIgnoreCase("!a") && command.length == 2 
				&& quizFlg == true) {
			List<String> answerCommand = new ArrayList<>(commandList);
			int kotae = Integer.parseInt(answerCommand.get(1));
			String kekka = quiz.quizOut(ansNum, kotae);
			event.getChannel().sendMessage(kekka).queue();
			setQuizFlg(quiz.isQuizFlg());
		}
		
		if (command[0].equalsIgnoreCase("!i") && command.length == 2) {
			List<String> numberCommand = new ArrayList<>(commandList);
			int number = Integer.parseInt(numberCommand.get(1));
		
			String msg = "@everyone lol normal @" + number; 
			event.getChannel().sendMessage(msg).queue();
		}

		// �T���i�[���
		if (command[0].equalsIgnoreCase("!s") && command.length >= 2) {
			List<String> sumName = new ArrayList<>(commandList);
			sumName.remove(0);
			String sumFullName = String.join(" ", sumName);
			try {

				SumChampInfo sumChampInfo = new SumChampInfo(sumFullName);
				// �T���i�[��� LVL Solo/DuoRanked/FlexRanked
				sumInfo = new SumInfo();
				event.getChannel().sendMessage(sumInfo.SumInfo(command[1])).queue();

				// ���C�ɓ���̃`�����s�I���\��
				sumChampInfo.setSumChampInfo();

				String favoChamp = "���C�ɓ���̃`�����s�I�� : " + sumChampInfo.champName + "\r\n" + " �}�X�^���[�|�C���g : "
						+ sumChampInfo.champMasteryPoint;

				eb.setDescription(favoChamp);
				eb.setImage(sumChampInfo.champImageUrl);

				event.getChannel().sendMessage(eb.build()).queue();

			} catch (RiotApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getAnsNum() {
		return ansNum;
	}

	public void setAnsNum(int ansNum) {
		this.ansNum = ansNum;
	}

	public boolean isQuizFlg() {
		return quizFlg;
	}

	public void setQuizFlg(boolean quizFlg) {
		this.quizFlg = quizFlg;
	}
}
