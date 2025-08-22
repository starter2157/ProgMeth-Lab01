package logic;

import java.util.Objects;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		this.setName(name);
		this.setBloodCost(bloodCost);
		this.setPower(power);
		this.setHealth(health);
		this.setFlavorText(flavorText);
	}

	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Creature";
		} else {
			this.name = name;
		}
	}

	public void setBloodCost(int bloodCost) {
		if (bloodCost < 0){
			this.bloodCost = 0;
		} else {
		this.bloodCost = bloodCost;
		}
	}

	public void setPower(int power) {
		if (power < 0){
			this.power = 0;
		} else {
			this.power = power;
		}
	}

	public void setHealth(int health) {
		if (health < 1){
			this.health = 1;
		} else {
			this.health = health;
		}
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		UnitCard unitCard = (UnitCard) o;
		return Objects.equals(name, unitCard.name);
	}

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

	public String getName() {
		return name;
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public int getPower() {
		return power;
	}

	public int getHealth() {
		return health;
	}

	public String getFlavorText() {
		return flavorText;
	}
}
