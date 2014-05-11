package com.kunhong.design.FlyWeight;

import java.util.Hashtable;

public class CharactorFactory {
	private Hashtable<String, Charactor> charactors = new Hashtable<String, Charactor>();

	/**
	 *  构造函数
	 */
	public CharactorFactory() {
		charactors.put("A", new CharactorA());
		charactors.put("B", new CharactorB());
	}

	/**
	 *  获得指定字符实例,实现共享的核心，避免开销
	 * @param key
	 * @return
	 */
	public Charactor getCharactor(String key) {
		Charactor charactor = (Charactor) charactors.get(key);
		if (charactor == null) {
			if (key.equals("A")) {
				charactor = new CharactorA();
			} else if (key.equals("B")) {
				charactor = new CharactorB();
			}
			charactors.put(key, charactor);
		}
		return charactor;
	}
}