package com.gildedrose;

class GildedRose {
	Item[] items;

	static final int QUALITY_MAX = 50;
	static final int DAY_1 = 10;
	static final int DAY_2 = 5;

	static final String NAME_ITEM_1 = "Aged Brie";
	static final String NAME_ITEM_2 = "Backstage passes to a TAFKAL80ETC concert";
	static final String NAME_ITEM_3 = "Sulfuras, Hand of Ragnaros";

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (testNameItem1Item2(items[i].name)) {
				if (testQualityLowerMax(items[i].quality)) {
					items[i].quality++;

					if (items[i].name.equals(NAME_ITEM_2) && testSellInLowerDay1(items[i].sellIn)
							&& testQualityLowerMax(items[i].quality)) {
						addQuality(items[i].sellIn, items[i].quality);
					}
				}
			} else {
				if (items[i].quality > 0) {
					if (!items[i].name.equals(NAME_ITEM_3)) {
						items[i].quality--;
					}
				}
			}
			if (!items[i].name.equals(NAME_ITEM_3)) {
				items[i].sellIn--;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals(NAME_ITEM_1)) {
					if (!items[i].name.equals(NAME_ITEM_2)) {
						if (items[i].quality > 0 && !items[i].name.equals(NAME_ITEM_3)) {
							items[i].quality--;
						}
					} else {
						items[i].quality = 0;
					}
				} else {
					if (testQualityLowerMax(items[i].quality)) {
						items[i].quality++;
					}
				}
			}
		}
	}
	
	public boolean testNameItem1Item2(String name) {
		if (name.equals(NAME_ITEM_1) || name.equals(NAME_ITEM_2)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testSellInLowerDay1(int sellIn) {
		if (sellIn <= DAY_1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testQualityLowerMax(int quality) {
		if (quality < QUALITY_MAX) {
			return true;
		} else {
			return false;
		}
	}

	public void addQuality(int sellIn, int quality) {
		if (sellIn <= DAY_2) {
			quality = quality + 2;
		} else {
			quality++;
		}
	}
}
