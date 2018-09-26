/*
 * copyright 2018
 * 
 */
package com.tutorialspoint;

import org.springframework.context.annotation.Description;

/**
 * @author jdl
 *
 *         time: 2018年9月26日 下午10:47:12
 */
public class TextEditor {
	private SpellChecker spellChecker;
	/*
	 * //构造器注入 public TextEditor(SpellChecker spellChecker) {
	 * System.out.println("Inside TextEditor constructor."); this.spellChecker =
	 * spellChecker; }
	 */

	/**
	 * 这是执行拼写检查
	 */
	public void spellCheck() {
		spellChecker.checkSpelling();
	}

	/**
	 * {@link Description} this is a getter of spellchecker
	 * 
	 * @return the spellChecker
	 */
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	/**
	 * 
	 * {@link Description} 通过setter来注入依赖
	 * 
	 * @param spellChecker the spellChecker to set
	 */
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside setSpellChecker.");
		this.spellChecker = spellChecker;
	}

}
