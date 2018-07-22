package com.carfax.dataobjects;

/**
 * Kata data object to store input file values.
 * 
 * @author Mallikarjun Nuti
 *
 */
public class KataDO {
	public KataDO() {
		this(null, null, null, null);
	}

	public KataDO(String vin, String state, String model, String make) {
		super();
		this.vin = vin;
		this.state = state;
		this.model = model;
		this.make = make;

	}

	/*
	 * Vin Number
	 */
	private String vin;
	/*
	 * Car make
	 */
	private String make;
	/*
	 * Car model
	 */
	private String model;
	/*
	 * State which it belongs to
	 */
	private String state;

	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * @param vin
	 *            the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 *            the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Vin #: " + this.vin + "  State :: " + this.state + "  Model :: " + this.model + " Make :: " + this.make;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof KataDO)) {
			return false;
		}

		KataDO vinDo = (KataDO) obj;

		return vinDo.vin.equals(vin) && vinDo.make.equals(make) && vinDo.model.equals(model)
				&& vinDo.state.equals(state);
	}

	public int hashcode() {
		int result = 17;
		result = 31 * result + vin.hashCode();
		result = 31 * result + state.hashCode();
		result = 31 * result + model.hashCode();
		result = 31 * result + make.hashCode();
		return result;

	}
}
