package vidis.ui.vis;

import javax.media.opengl.GL;

import org.apache.log4j.Logger;

public class Light {
	private static Logger logger = Logger.getLogger(Light.class);

    /**
     * GL_LIGHT0 Links
     * - directional light source
     * - no ambient
     * - blue diffuse
     */
    public static void initLinkLight( GL gl ) {
    	logger.debug( "initLinkLight()" );
        float noAmbient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float blueDiffuse[] = {0.0f, 0.0f, 1.0f, 1.0f};
        /*
         * Directional light source (w = 0)
         * The light source is at an infinite distance,
         * all the ray are parallel and have the direction (x, y, z).
         */
        float position[] = {0.0f, 1.0f, 0.0f, 0.0f};
       
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, noAmbient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, blueDiffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position, 0);
    }
    
    /**
     * GL_LIGHT1 Node
     * - directional light source
     * - no ambient
     * - blue diffuse
     */
    public static void initNodeLight( GL gl ) {
    	logger.debug( "initNodeLight()" );
        float noAmbient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float redDiffuse[] = {1.0f, 0.0f, 0.0f, 1.0f};
        /*
         * Directional light source (w = 0)
         * The light source is at an infinite distance,
         * all the ray are parallel and have the direction (x, y, z).
         */
        float position[] = {0.0f, 1.0f, 0.0f, 0.0f};
       
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_AMBIENT, noAmbient, 0);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_DIFFUSE, redDiffuse, 0);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, position, 0);
    }
   
    /**
     * GL_LIGHT2 Packet
     * - directional light source
     * - no ambient
     * - blue diffuse
     */
    public static void initPacketLight( GL gl ) {
    	logger.debug( "initPacketLight()" );
        float noAmbient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float greenDiffuse[] = {0.0f, 1.0f, 0.0f, 1.0f};
        /*
         * Directional light source (w = 0)
         * The light source is at an infinite distance,
         * all the ray are parallel and have the direction (x, y, z).
         */
        float position[] = {0.0f, 1.0f, 0.0f, 0.0f};
       
        gl.glLightfv(GL.GL_LIGHT2, GL.GL_AMBIENT, noAmbient, 0);
        gl.glLightfv(GL.GL_LIGHT2, GL.GL_DIFFUSE, greenDiffuse, 0);
        gl.glLightfv(GL.GL_LIGHT2, GL.GL_POSITION, position, 0);
    }
    /**
     * GL_LIGHT1
     * - positional light source
     * - yellow ambient
     * - yellow diffuse
     *
     * Rem:
     * To have a "real" effect, set the ambient and diffuse to the same color.
     */
    public static void initPosLight( GL gl ) {
        float yellowAmbientDiffuse[] = {1.0f, 1.0f, 0.0f, 1.0f};
        /*
         * Positional light source (w = 1)
         * The light source is positioned at (x, y, z).
         * The ray come from this particular location (x, y, z) and goes towards all directions.
         */
        float position[] = {-2.0f, 2.0f, -5.0f, 1.0f};
       
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_AMBIENT, yellowAmbientDiffuse, 0);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_DIFFUSE, yellowAmbientDiffuse, 0);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, position, 0);
    }
}
