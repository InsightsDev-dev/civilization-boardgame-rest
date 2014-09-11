package no.asgari.civilization.representations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * The item you pull for instance Great Person, Wonder, Civ etc
 * Most of them will not have type or description.
 * The @used attribute will determine if the item is available or not
 * ie:
 * <p/>
 * sheet = GREAT_PERSON
 * name = Leonidas
 * type = General
 * description = Battle: Each time you start a battle with fewer units in your battle force than your opponent,
 * your combat bonus is increased by 8 until the end of the battle.
 * used = true
 * hidden = false
 * <p/>
 * sheet = CIV
 * name = America
 * type = null
 * description = null
 * used = false
 * hidden = false;
 * <p/>
 * sheet = VILLAGES
 * name = Barbarian Encampment
 * type = null
 * description = Start of Turn : Choose an empty square not in the outskirts of a city. Place a village token on that square.
 * used = true
 * hidden = true;
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.WRAPPER_OBJECT, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Citystate.class, name="citystate"),
        @JsonSubTypes.Type(value=Civ.class, name="civ"),
        @JsonSubTypes.Type(value=CultureI.class, name="cultureI"),
        @JsonSubTypes.Type(value=CultureII.class, name="cultureII"),
        @JsonSubTypes.Type(value=CultureIII.class, name="cultureIII"),
        @JsonSubTypes.Type(value=GreatPerson.class, name="greatperson"),
        @JsonSubTypes.Type(value=Hut.class, name="hut"),
        @JsonSubTypes.Type(value=Tile.class, name="tile"),
        @JsonSubTypes.Type(value=Village.class, name="village"),
        @JsonSubTypes.Type(value=Wonder.class, name="wonder")
})
public interface Item<T> extends Spreadsheet {

    /**
     * Either the username or pbf name, both of which must be unique *
     */
    public String getName();

    public String getOwner();

    public boolean isHidden();

    public boolean isUsed();

    public String getDescription();

    public String getId();

    /**
     * For instance general
     */
    public String getType();

    public T getItem();

}
