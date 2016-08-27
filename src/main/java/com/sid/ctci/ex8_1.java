package com.sid.ctci;

import java.util.ArrayList;

public class ex8_1 {

	public abstract class card 
	{
		int face_Value;
		String suit;
		public abstract int value();
	}
	
	public class BlackJackCard extends card
	{

		@Override
		public int value() {
			// TODO Auto-generated method stub
			if (face_Value >=11 && face_Value < 13) return 10;
			else if (isAce()) return 1;
			else return face_Value;
		}
		
		public boolean isAce()
		{
			return face_Value == 1;
		}
		
	}
	
	public class Hand
	{
		ArrayList <card> cards = new ArrayList();
		public int score()
		{
			return 1;
		}
	}
	
	public class BlackJackHand extends Hand{
		
	}
	
}
