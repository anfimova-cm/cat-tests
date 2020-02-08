package cat_tests.model;

import java.io.File;

public class MarketEntityData {

    private String name;
    private String uid;
    private String marketOfferId;
    private File imageSmall;
    private File imageLarge;

    public String getName() {
        return name;
    }

    public MarketEntityData setName(String name) {
        this.name = name;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public MarketEntityData setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getMarketOfferId() {
        return marketOfferId;
    }

    public MarketEntityData setMarketOfferId(String marketOfferId) {
        this.marketOfferId = marketOfferId;
        return this;
    }

    public File getImageSmall() {
        return imageSmall;
    }

    public MarketEntityData setImageSmall(File imageSmall) {
        this.imageSmall = imageSmall;
        return this;
    }

    public File getImageLarge() {
        return imageLarge;
    }

    public MarketEntityData setImageLarge(File imageLarge) {
        this.imageLarge = imageLarge;
        return this;
    }
}
