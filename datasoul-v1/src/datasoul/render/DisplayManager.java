/*
 * DisplayManager.java
 *
 * Created on March 20, 2006, 9:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package datasoul.render;

import datasoul.ConfigObj;

/**
 *
 * @author root
 */
public class DisplayManager {
    
    static private DisplayItf mainDisplay;
    static private DisplayItf monitorDisplay;
    static private String mainDisplayEngine = "SwingDisplay";
    static private String monitorDisplayEngine = "SwingDisplay";
    
    static public DisplayItf getMainDisplay(){

        if (mainDisplay == null ){
            try{
                mainDisplay = (DisplayItf) Class.forName( "datasoul.render." + mainDisplayEngine ).newInstance();
            }catch(Exception e){
                e.printStackTrace();
                mainDisplay = new SwingDisplay();
            }
            
            int width, height, top, left;
            try{
                width = Integer.parseInt(ConfigObj.getInstance().getMainOutputSizeWidth());
            }catch(Exception e){
                width = 640;
            }
            try{
                height = Integer.parseInt(ConfigObj.getInstance().getMainOutputSizeHeight());
            }catch(Exception e){
                height = 480;
            }
            try{
                top = Integer.parseInt(ConfigObj.getInstance().getMainOutputPositionTop());
            }catch(Exception e){
                top = 0;
            }
            try{
                left = Integer.parseInt(ConfigObj.getInstance().getMainOutputPositionLeft());
            }catch(Exception e){
                left = 0;
            }
            
            mainDisplay.initDisplay(width, height, top, left);
        }
        return mainDisplay;
    }
    
    static public DisplayItf getMonitorDisplay(){
        
        if (monitorDisplay == null  ){

            try{
                monitorDisplay = (DisplayItf) Class.forName( "datasoul.render." + monitorDisplayEngine ).newInstance();
            }catch(Exception e){
                e.printStackTrace();
                monitorDisplay = new SwingDisplay();
            }
            
            int width, height, top, left;
            try{
                width = Integer.parseInt(ConfigObj.getInstance().getMonitorOutputSizeWidth());
            }catch(Exception e){
                width = 640;
            }
            try{
                height = Integer.parseInt(ConfigObj.getInstance().getMonitorOutputSizeHeight());
            }catch(Exception e){
                height = 480;
            }
            try{
                top = Integer.parseInt(ConfigObj.getInstance().getMonitorOutputPositionTop());
            }catch(Exception e){
                top = 0;
            }
            try{
                left = Integer.parseInt(ConfigObj.getInstance().getMonitorOutputPositionLeft());
            }catch(Exception e){
                left = 0;
            }

            monitorDisplay.getContentRender().setMonitor(true);
            monitorDisplay.getContentRender().setTemplate("monitor");
            monitorDisplay.initDisplay(width, height, top, left);
        }
        return monitorDisplay;
    }

    static public void setMainDisplayEngine(String engine){
        mainDisplayEngine = engine;
    }
    
    static public void setMonitorDisplayEngine(String engine) {
        monitorDisplayEngine = engine;
    }
    
}
