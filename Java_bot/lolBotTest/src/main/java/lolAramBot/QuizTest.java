package lolAramBot;

import java.util.Random;

public class QuizTest {

	// ����
	private int answer;// ���͂�������

	// �o��
	private String quiz;// �R�}���h�ŌĂяo�����N�C�Y

	// �R�}���h�𐧌䂷��t���O

	private String quizResultDisp;// ���ʂ̕\��

	private int ansNum;

	private boolean quizFlg = true;

	public String quizOut(int ansNum, int answer) {

		if (ansNum == answer) {
			quizFlg = false;
			quizResultDisp = "����!!";
		} else {
			quizFlg = true;
			quizResultDisp = "�c�O...";
		}

		return quizResultDisp;
	}

	public String quizDisp() {
		Random rand = new Random();
		int MAX_QUIZ_NUM = 5;
		int quizNum = rand.nextInt(MAX_QUIZ_NUM);
		switch (quizNum) {
		case 0:
			quiz = "���̓��u�ύt�̎�l�v�ł͂Ȃ��̂́H\r\n" + "1:�V�F���@2:�P�l���@3:�[�h";
			ansNum = 3;
			break;
		case 1:
			quiz = "�e�B�[���̒ʏ�U���̎˒��͎��̂����ǂꂪ�������H\r\n" + "1:500  2:525  3:600";
			ansNum = 1;
			break;
		case 2:
			quiz = "���̓��f�}�[�V�A�̃`�����v�ł͂Ȃ��̂͒N�ł��傤\r\n" + "1:���V�A���@2:�V���@�[�i�@3:�\���J";
			ansNum = 3;
			break;
		case 3:
			quiz = "�u���b�c�N�����N�̃p�b�V�u�̃V�[���h�ʂ͉��ɂ���đ�������H\r\n" + "1:�����̗́@2:�����h��́@3:�}�i";
			ansNum = 3;
			break;
		case 4:
			quiz = "���̂����T�C�����X���X�L���Ŏ����Ă���`�����v�́H\r\n" + " 1:�N�C���@2:�r�N�^�[�@3:�e�B�[��";
			ansNum = 2;
			break;
		}
		return quiz;
	}

	// �Q�b�^�[ �Z�b�^�[

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
