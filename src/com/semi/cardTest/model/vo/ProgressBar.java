package com.semi.cardTest.model.vo;

public class ProgressBar {
	
	private int wholeQuestion;
	private int solvedQuestion;
	private int correctAnswer;
	private int wrongAnswer;

	
	
	public ProgressBar() {
		// TODO Auto-generated constructor stub
	}

	public ProgressBar(int wholeQuestion, int solvedQuestion, int correctAnswer, int wrongAnswer) {
		super();
		this.wholeQuestion = wholeQuestion;
		this.solvedQuestion = solvedQuestion;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer = wrongAnswer;
	}

	

	public int getWholeQuestion() {
		return wholeQuestion;
	}

	public void setWholeQuestion(int wholeQuestion) {
		this.wholeQuestion = wholeQuestion;
	}

	public int getSolvedQuestion() {
		return solvedQuestion;
	}

	public void setSolvedQuestion(int solvedQuestion) {
		this.solvedQuestion = solvedQuestion;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getWrongAnswer() {
		return wrongAnswer;
	}

	public void setWrongAnswer(int wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}

	@Override
	public String toString() {
		return "ProgressBar [wholeQuestion=" + wholeQuestion + ", solvedQuestion=" + solvedQuestion + ", correctAnswer="
				+ correctAnswer + ", wrongAnswer=" + wrongAnswer + "]";
	}


}
