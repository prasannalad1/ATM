package com.atm.entities;

public class AtmMachine {
	 int AtmId; //Camel  Case
		String AtmName;
		String password;
		
		public AtmMachine(int atmId, String atmName, String password) {
			super();
			AtmId = atmId;
			AtmName = atmName;
			this.password = password;
		}
		public AtmMachine() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getAtmId() {
			return AtmId;
		}
		public void setAtmId(int atmId) {
			AtmId = atmId;
		}
		public String getAtmName() {
			return AtmName;
		}
		public void setAtmName(String atmName) {
			AtmName = atmName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
}
