package com.gildedrose;

class GildedRose {
    Item[] items;
    
    static final int QUALITY_MAX = 50 ;
    static final int DAY_1 = 10 ;
    static final int DAY_2 = 5 ;
    
    static final String NAME_ITEM_1 = "Aged Brie";
    static final String NAME_ITEM_2 = "Backstage passes to a TAFKAL80ETC concert" ;
    static final String NAME_ITEM_3 = "Sulfuras, Hand of Ragnaros" ;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	if(testNameItem1Item2(items[i].name)) {
        		if (testQualityLowerMax(items[i].quality)) {
                    items[i].quality ++;

                    if (items[i].name.equals(NAME_ITEM_2)) {
                        if (items[i].sellIn <= DAY_1) {
                            if (testQualityLowerMax(items[i].quality)) {
                                items[i].quality ++;
                            }
                        }

                        if (items[i].sellIn <= DAY_2) {
                            if (testQualityLowerMax(items[i].quality)) {
                                items[i].quality ++;
                            }
                        }
                    }
                }
        	}
        	else {
        		if (items[i].quality > 0) {
                    if (!items[i].name.equals(NAME_ITEM_3)) {
                        items[i].quality --;
                    }
                }        		
        	}
        	
        	//A mettre dans updateSellIn()
            if (!items[i].name.equals(NAME_ITEM_3)) {
                items[i].sellIn --;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(NAME_ITEM_1)) {
                    if (!items[i].name.equals(NAME_ITEM_2)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(NAME_ITEM_3)) {
                                items[i].quality --;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (testQualityLowerMax(items[i].quality)) {
                        items[i].quality ++;
                    }
                }
            }
        }
    }
    
    public void updateSellIn() {
    	
    }
    
    public boolean testNameItem1Item2(String name) {
    	if(name.equals(NAME_ITEM_1) || name.equals(NAME_ITEM_2)) {
    		return true ;
    	}
    	else {
    		return false ;
    	}
    }
    
    public boolean testQualityLowerMax(int quality) {
    	if(quality < QUALITY_MAX) {
    		return true ;
    	}else {
    		return false ;
    	}
    }
}