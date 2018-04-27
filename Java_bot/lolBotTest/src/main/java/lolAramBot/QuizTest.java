package lolAramBot;

import java.util.Random;

public class QuizTest {

	// 入力
	private int answer;// 入力した答え

	// 出力
	private String quiz;// コマンドで呼び出されるクイズ

	// コマンドを制御するフラグ

	private String quizResultDisp;// 結果の表示

	private int ansNum;

	private boolean quizFlg = true;

	public String quizOut(int ansNum, int answer) {

		if (ansNum == answer) {
			quizFlg = false;
			quizResultDisp = "正解!!";
		} else {
			quizFlg = true;
			quizResultDisp = "残念...";
		}

		return quizResultDisp;
	}

	public String quizDisp() {
		Random rand = new Random();
		int MAX_QUIZ_NUM = 5;
		int quizNum = rand.nextInt(MAX_QUIZ_NUM);
		switch (quizNum) {
		case 0:
			quiz = "次の内「均衡の守人」ではないのは？\r\n" + "1:シェン　2:ケネン　3:ゼド";
			ansNum = 3;
			break;
		case 1:
			quiz = "ティーモの通常攻撃の射程は次のうちどれが正しい？\r\n" + "1:500  2:525  3:600";
			ansNum = 1;
			break;
		case 2:
			quiz = "次の内デマーシアのチャンプではないのは誰でしょう\r\n" + "1:ルシアン　2:シヴァーナ　3:ソラカ";
			ansNum = 3;
			break;
		case 3:
			quiz = "ブリッツクランクのパッシブのシールド量は何によって増加する？\r\n" + "1:増加体力　2:物理防御力　3:マナ";
			ansNum = 3;
			break;
		case 4:
			quiz = "次のうちサイレンスをスキルで持っているチャンプは？\r\n" + " 1:クイン　2:ビクター　3:ティーモ";
			ansNum = 2;
			break;
		}
		return quiz;
	}

	// ゲッター セッター

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String getKekka() {
		return quizResultDisp;
	}

	public void setKekka(String quizResultDisp) {
		this.quizResultDisp = quizResultDisp;
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
