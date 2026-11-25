package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] collectibles;
	private int actualSize;

	public NaiveInventory() {
		this.collectibles = new Collectible[INITIAL_CAPACITY];
		this.actualSize = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (actualSize == collectibles.length) {
			Collectible[] newCollectibles = new Collectible[collectibles.length * 2];
			for (int i = 0; i < collectibles.length; i++) {
				newCollectibles[i] = collectibles[i];
			}
			collectibles = newCollectibles;
		}
		collectibles[actualSize] = collectible;
		actualSize++;
	}

	@Override
	public float getTotalWeight() {
		float totalWeight = 0;
		for (int i = 0; i < actualSize; i++) {
			totalWeight += collectibles[i].getWeight();
		}
		return totalWeight;
	}

	@Override
	public int getCurrentCount() {
		return actualSize;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return collectibles;
	}
}
