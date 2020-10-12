package com.lumbu.tradingsignalparser.pojo.trading;

public class Signal {
	private String instrument;

	private String instruction;

	public Signal() {

	}

	public Signal(String instrument, String instruction) {
		this.instrument = instrument;
		this.instruction = instruction;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Override
	public String toString() {
		return "Signal [instrument=" + instrument + ", instruction=" + instruction + "]";
	}

}
