package nl.tue.s2id90.draughts.player;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.game.Player;
import org10x10.dam.game.Move;

/**
 * Base class for draughts players. 
 * @author huub
 */
public abstract class DraughtsPlayer implements Player<Move,DraughtsState> {
    private static final Logger LOG = Logger.getLogger(DraughtsPlayer.class.getName());
    
    private static final String FOLDER="/nl/tue/s2id90/draughts/player/";
    private static final String ICON="unknown.png";
    private URL icon;

    /** constructs DraughtsPlayer with icon at given url. **/
    public DraughtsPlayer(URL icon) {
        this.icon = icon;
    }
    
    /** construct DraughtsPlayer with some default icon. **/
    public DraughtsPlayer() {
        this(FOLDER+ICON);
    }
    
    /** construct DraughtsPlayer with icon found at given path. This path is resolved
     * to an url using Class#getResource(String).
     * @param path location of icon
     **/
    public DraughtsPlayer(String path) {
        icon = getClass().getResource(path);
        if (icon==null) {
            LOG.log(Level.WARNING, "unable to locate icon: {0}", path);
        }
    }
    
    @Override
    public String toString() {
        return "["+getName()+"]";
    }
    
    @Override
    public ImageIcon getIcon() {
        if (icon==null) {
            return null;
        } else
            return new ImageIcon(icon);
    }
    
    @Override
    public Integer getValue() {
        return null;
    }
    
    @Override
    /** empty stop method, should be overridden by a method that stops complicated 
     * computations.
     */
    public void stop() {}
    
    @Override
    /** generate name for player based on class name. **/
    public String getName() {
        return getClass().getSimpleName();
    }
    
    @Override
    /** returns whether or not the current player is a human player.
     * This implementation returns false.
     **/
    public boolean isHuman() {
        return false;
    }
}