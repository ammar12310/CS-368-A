
public void UpdateQuality() {
        for (var i = 0; i < Items.Count; i++) {
            if (Items[i].Name != "Aged Brie" && Items[i].Name != "Backstage passes to a TAFKAL80ETC concert") {
                checkHighQuality(i);
            } else {
                if (Items[i].Quality < 50) {
                    incrementQuality(i);

                    if (Items[i].Name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (Items[i].SellIn < 11) {
                            checkLowQuality(i);
                        }

                        if (Items[i].SellIn < 6) {
                            checkLowQuality(i);
                        }
                    }
                }
            }

            if (Items[i].Name != "Sulfuras, Hand of Ragnaros") {
                Items[i].SellIn = Items[i].SellIn - 1;
            }

            if (Items[i].SellIn < 0) {
                if (Items[i].Name != "Aged Brie") {
                    if (Items[i].Name != "Backstage passes to a TAFKAL80ETC concert") {
                        checkHighQuality(i);
                    } else {
                        Items[i].Quality = Items[i].Quality - Items[i].Quality;
                    }
                } else {
                    CheckSulfuras(i);
                }
            }
        }
    }

    private void checkHighQuality(int i) {
        if (Items[i].Quality > 0) {
            CheckSulfuras(i);
        }
    }

    private void CheckSulfuras(int i) {
        if (Items[i].Name != "Sulfuras, Hand of Ragnaros") {
            decrementOfQuality(i);
        }
    }

    private void incrementQuality(int i) {
            Items[i].Quality = Items[i].Quality + 1;
    }
    private void checkLowQuality(int i) {
        if (Items[i].Quality < 50) {
            incrementQuality(i);
        }
    }
    private void decrementOfQuality(int i) {
        Items[i].Quality = Items[i].Quality - 1;
    }
