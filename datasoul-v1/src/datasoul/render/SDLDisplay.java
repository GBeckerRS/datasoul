/*
 * SDLDisplay.java
 *
 * Created on March 11, 2006, 12:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package datasoul.render;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.nio.ByteBuffer;

/**
 *
 * @author samuelm
 */
public class SDLDisplay implements DisplayItf {

    static {
        // depois a gente arruma isso
        if (System.getProperty("os.name").equals("Linux")){
            System.load("/home/samuelm/cvs/datasoul-v1/src/native/libdatasoulsdl.so");
        }
        if (System.getProperty("os.name").contains("Windows")){
            String path = System.getProperty("user.dir") + System.getProperty("file.separator") 
            + "native"+System.getProperty("file.separator");
    
            System.load(path+"nativedll.dll");
        }
        
    }
    
    public static final int BACKGROUND_MODE_STATIC = 0;
    public static final int BACKGROUND_MODE_LIVE = 1;
    
    private BufferedImage overlay;
    private ByteBuffer overlayBuf;
    private BufferedImage background;
    private ByteBuffer backgroundBuf;
    
    private SDLContentRender contentRender;
    
    static private SDLDisplay instance = null;
    
    public SDLDisplay(){
        contentRender = new SDLContentRender(this);
    }
    
    public SDLContentRender getContentRender(){
        return contentRender;
    }
    
    public void initDisplay (final int width, final int height, final int top, final int left){
        
        overlay = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        overlayBuf = ByteBuffer.allocateDirect(width * height * 4);
        background = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        backgroundBuf = ByteBuffer.allocateDirect(width * height * 4);

        if (System.getProperty("os.name").equals("Linux")){
            Thread t = new Thread(){
                public void run(){
                    init(width, height, top, left);
                }
            };

            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
            try {
                t.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if (System.getProperty("os.name").contains("Windows")){
            init(width, height, top, left);        
        }
        
        paintBackgroundColor(Color.ORANGE);
        
    }
    
    @Override
    protected void finalize() throws Throwable {
        cleanup();
    }
            
    private native void init(int width, int height, int top, int left);
    private native void cleanup();
    private native void displayOverlay(ByteBuffer bb);
    private native void nativeSetBackground(ByteBuffer bb);
    public native void black(int active);
    public native void clear(int active);
    public native void setBackgroundMode(int mode);
    public native void setInputSrc(int src);
    public native void setInputMode(int mode);
    public native void setDeintrelaceMode(int mode);
    public native void setDebugMode (int mode);
    
    public void clear(){

        Graphics2D g = overlay.createGraphics();

        Composite oldComp = g.getComposite();
        g.setComposite( AlphaComposite.getInstance(AlphaComposite.CLEAR, 0) );
        g.fillRect(0, 0, overlay.getWidth(), overlay.getHeight());
        g.setComposite(oldComp);
        
    }

    public void paintOverlay(Paintable p){
        
        if (p == null) return;

        Graphics2D g = overlay.createGraphics();
        
        // paint it
        p.paint(g);
        
        
    }

    public void flip(){

        // send it to the native display
        overlayBuf.put( ((DataBufferByte)overlay.getRaster().getDataBuffer()).getData() ) ;
        overlayBuf.flip();
        this.displayOverlay(overlayBuf);
        overlayBuf.clear();
        
    }
    
    
    public void paintBackground(BufferedImage img){
        
        if (img == null) return;

        // we need to convert it to ensure that its on the correct format and dimensions
        Graphics2D g = background.createGraphics();
        g.drawImage(img, 0, 0, background.getWidth(), background.getHeight(), null);
        
        backgroundBuf.put(((DataBufferByte)background.getRaster().getDataBuffer()).getData() ) ;
        backgroundBuf.flip();
        this.nativeSetBackground(backgroundBuf);
        backgroundBuf.clear();
        
    }

    public void paintBackgroundColor(Color color){

        Graphics2D g = background.createGraphics();
        g.setColor(color);
        g.fillRect(0,0,background.getWidth(), background.getHeight());
        
        backgroundBuf.put(((DataBufferByte)background.getRaster().getDataBuffer()).getData() ) ;
        backgroundBuf.flip();
        this.nativeSetBackground(backgroundBuf);
        backgroundBuf.clear();
        
    }
    
}