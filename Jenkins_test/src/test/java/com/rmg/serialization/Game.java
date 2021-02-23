package com.rmg.serialization;

import java.io.Serializable;

public class Game implements Serializable
{
	String name;
	int level;
	int fuel;
	int boost;

	public Game(String na,int le,int fu,int bo)
	{
		this.name=na;
		this.level=le;
		this.fuel=fu;
		this.boost=bo;
	}
}
