/*
 * ConfigObj.java
 *
 * Created on 22 de Marco de 2006, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package datasoul;

import datasoul.render.ContentManager;
import datasoul.render.SDLContentRender;
import datasoul.templates.TemplateManager;
import datasoul.util.SerializableObject;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.serialize.OutputFormat;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Administrador
 */
public class ConfigObj extends SerializableObject {
    
    static ConfigObj instance;
    
    private boolean mainOutput;
    private String mainOutputPositionLeft;
    private String mainOutputPositionTop;
    private String mainOutputSizeWidth;
    private String mainOutputSizeHeight;
    private boolean monitorOutput;
    private String monitorOutputPositionLeft;
    private String monitorOutputPositionTop;
    private String monitorOutputSizeWidth;
    private String monitorOutputSizeHeight;
    private String templateMonitor;
    private String templateText;
    private int videoInput;
    private int videoMode;
    private int videoDeintrelace;
    private int clockMode;    
    private boolean videoDebugMode;
    private String mainDisplayEngine;
    private String monitorDisplayEngine;
    private int slideTransitionTime;
    private int slideShowHideTime;
    private boolean monitorFollowMainControls;
    private BufferedImage mainBackgroundImg;
    private BufferedImage monitorBackgroundImg;
    private String monitorTemplateFilter;
    private String alertTemplateFilter;
    private String generalTemplateFilter;
    
    
    public static final int CLOCKMODE_24_SEC = 0;
    public static final int CLOCKMODE_24_NOSEC = 1;
    public static final int CLOCKMODE_12_SEC = 2;
    public static final int CLOCKMODE_12_NOSEC = 3;
    public static final String[] CLOCKMODE_TABLE = {"24 Hours with Seconds", "24 Hours without Seconds", "AM/PM with Seconds", "AM/PM without Seconds"};

    public static final int VIDEODEINTRELACE_NONE = 0;
    public static final int VIDEODEINTRELACE_BLEND = 1;
    public static final int VIDEODEINTRELACE_SMARTBLEND = 2;
    public static final int VIDEODEINTRELACE_SMOOTHBLEND = 3;
    public static final String[] VIDEODEINTRELACE_TABLE = {"None", "Blend", "Smart blend", "Smooth blend"};

    public static final int VIDEOMODE_PAL = 0;
    public static final int VIDEOMODE_NTSC = 1;
    public static final int VIDEOMODE_SECAM = 2;
    public static final String[] VIDEOMODE_TABLE = {"PAL", "NTSC", "SECAM"};

    public static final int VIDEOINPUT_TUNER = 0;
    public static final int VIDEOINPUT_COMPOSITE = 1;
    public static final int VIDEOINPUT_COMPSVIDEO = 2;
    public static final int VIDEOINPUT_SVIDEO = 3;
    public static final String[] VIDEOINPUT_TABLE = {"Tuner", "Composite", "Composite2/S-Video", "S-Video"};
    
    /** Creates a new instance of ConfigObj */
    private ConfigObj() {
        String path = System.getProperty("user.dir") + System.getProperty("file.separator") 
        + "config" + System.getProperty("file.separator") + "datasoul.config";

        File configFile = new File(path);

        Document dom=null;
        Node node = null;
        try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                //Using factory get an instance of document builder
                DocumentBuilder db = dbf.newDocumentBuilder();

                //parse using builder to get DOM representation of the XML file
                dom = db.parse(configFile);

                //node = dom.getDocumentElement().getChildNodes().item(0);
                node = dom.getElementsByTagName("ConfigObj").item(0);

        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error parsing config file\n"+e.getMessage(),"DataSoul Error",0);    
            e.printStackTrace();
            return;
        }        

        try {
            this.readObject(node);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error parsing config file\nError: "+e.getMessage(),"DataSoul Error",0);    
            e.printStackTrace();
        }
    }
    
    public void save(){
        try{
            String path = System.getProperty("user.dir") + System.getProperty("file.separator") 
            + "config" + System.getProperty("file.separator") + "datasoul.config";

            Node node = this.writeObject();
            Document doc = node.getOwnerDocument();
            doc.appendChild( node);                        // Add Root to Document
            FileOutputStream fos = new FileOutputStream(path);
            org.apache.xml.serialize.XMLSerializer xs = new org.apache.xml.serialize.XMLSerializer();
            OutputFormat outFormat = new OutputFormat();
            outFormat.setIndenting(true);
            outFormat.setEncoding("ISO-8859-1");
            xs.setOutputFormat(outFormat);
            xs.setOutputByteStream(fos);
            xs.serialize(doc);

        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error writing file.\nError:"+e.getMessage(),"DataSoul Error",0);    
            e.printStackTrace();
        }
    }
    
    public static synchronized ConfigObj getInstance(){
        if(instance==null){
            instance = new ConfigObj();
        }
        return instance;
    }

    protected void registerProperties() {
        properties.add("MainDisplayEngine");
        properties.add("MonitorDisplayEngine");
        properties.add("MainOutputIdx");
        properties.add("MainOutputPositionLeft");
        properties.add("MainOutputPositionTop");
        properties.add("MainOutputSizeWidth");
        properties.add("MainOutputSizeHeight");
        properties.add("MonitorOutputIdx");
        properties.add("MonitorOutputPositionLeft");
        properties.add("MonitorOutputPositionTop");
        properties.add("MonitorOutputSizeWidth");
        properties.add("MonitorOutputSizeHeight");
        properties.add("TemplateMonitor");
        properties.add("TemplateText");
        properties.add("VideoInputIdx");
        properties.add("VideoModeIdx");
        properties.add("VideoDeintrelaceIdx");
        properties.add("ClockModeIdx");        
        properties.add("VideoDebugModeIdx");
        properties.add("SlideTransitionTime");
        properties.add("SlideShowHideTime");
        properties.add("MonitorFollowMainControlsIdx");
        properties.add("MainBackgroundImgStr");
        properties.add("MonitorBackgroundImgStr");
        properties.add("MonitorTemplateFilter");
        properties.add("AlertTemplateFilter");
        properties.add("GeneralTemplateFilter");
    }
    
    public ArrayList<String> getProperties(){
        return properties;
    }

    public boolean getMainOutput() {
        return mainOutput;
    }

    public String getMainOutputIdx() {
        if (mainOutput==false){
            return "0";
        }else{
            return "1";
        }
    }

    public void setMainOutput(boolean mainOutput) {
        this.mainOutput = mainOutput;
    }

    public void setMainOutputIdx(String mainOutput) {
        if (mainOutput.equals("0")){
            this.mainOutput = false;
        }else{
            this.mainOutput = true;
        }
    }
    
    public String getMainOutputPositionLeft() {
        return mainOutputPositionLeft;
    }

    public void setMainOutputPositionLeft(String mainOutputPositionLeft) {
        this.mainOutputPositionLeft = mainOutputPositionLeft;
    }

    public String getMainOutputPositionTop() {
        return mainOutputPositionTop;
    }

    public void setMainOutputPositionTop(String mainOutputPositionTop) {
        this.mainOutputPositionTop = mainOutputPositionTop;
    }

    public String getMainOutputSizeWidth() {
        return mainOutputSizeWidth;
    }

    public void setMainOutputSizeWidth(String mainOutputSizeWidth) {
        this.mainOutputSizeWidth = mainOutputSizeWidth;
    }

    public String getMainOutputSizeHeight() {
        return mainOutputSizeHeight;
    }

    public void setMainOutputSizeHeight(String mainOutputSizeHeight) {
        this.mainOutputSizeHeight = mainOutputSizeHeight;
    }

    public boolean getMonitorOutput() {
        return monitorOutput;
    }

    public String getMonitorOutputIdx() {
        if (monitorOutput==false){
            return "0";
        }else{
            return "1";
        }
    }

    public void setMonitorOutput(boolean monitorOutput) {
        this.monitorOutput = monitorOutput;
    }

    public void setMonitorOutputIdx(String monitorOutput) {
        if (monitorOutput.equals("0")){
            this.monitorOutput = false;
        }else{
            this.monitorOutput = true;
        }
    }

    public String getMonitorOutputPositionLeft() {
        return monitorOutputPositionLeft;
    }

    public void setMonitorOutputPositionLeft(String monitorOutputPositionLeft) {
        this.monitorOutputPositionLeft = monitorOutputPositionLeft;
    }

    public String getMonitorOutputPositionTop() {
        return monitorOutputPositionTop;
    }

    public void setMonitorOutputPositionTop(String monitorOutputPositionTop) {
        this.monitorOutputPositionTop = monitorOutputPositionTop;
    }
    
    public String getMonitorOutputSizeWidth() {
        return monitorOutputSizeWidth;
    }

    public void setMonitorOutputSizeWidth(String monitorOutputSizeWidth) {
        this.monitorOutputSizeWidth = monitorOutputSizeWidth;
    }

    public String getMonitorOutputSizeHeight() {
        return monitorOutputSizeHeight;
    }

    public void setMonitorOutputSizeHeight(String monitorOutputSizeHeight) {
        this.monitorOutputSizeHeight = monitorOutputSizeHeight;
    }

    public String getTemplateMonitor() {
        return templateMonitor;
    }

    public void setTemplateMonitor(String templateMonitor) {
        this.templateMonitor = templateMonitor;
    }

    public String getTemplateText() {
        return templateText;
    }

    public void setTemplateText(String templateText) {
        this.templateText = templateText;
    }

    public String getVideoInput() {
        return VIDEOINPUT_TABLE[videoInput];
    }
    
    public int getVideoInputIdx() {
        return videoInput;
    }

    public void setVideoInputIdx(String videoInput) {
        setVideoInputIdx(Integer.parseInt(videoInput));
    }
    
    public void setVideoInputIdx(int videoInput) {

        this.videoInput = videoInput;
        if ( this.getMainOutput() && ContentManager.getMainDisplay() instanceof SDLContentRender ){
            ((SDLContentRender)ContentManager.getMainDisplay()).setInputSrc(videoInput);
        }
        
    }
    
    public void setVideoInput(String str){
        for (int i=0; i<VIDEOINPUT_TABLE.length; i++){
            if (str.equalsIgnoreCase(VIDEOINPUT_TABLE[i]))
                setVideoInputIdx(i);
        }
    }
    
    

    public String getVideoMode() {
        return VIDEOMODE_TABLE[videoMode];
    }

    public int getVideoModeIdx() {
        return videoMode;
    }
    
    public void setVideoModeIdx(String videoMode) {
        setVideoModeIdx(Integer.parseInt(videoMode));
    }
    
    public void setVideoModeIdx(int videoMode) {
        this.videoMode = videoMode;
        if ( this.getMainOutput() &&  ContentManager.getMainDisplay() instanceof SDLContentRender ){
            ((SDLContentRender)ContentManager.getMainDisplay()).setInputMode(videoMode);
        }
    }

    public void setVideoMode(String str){
        for (int i=0; i<VIDEOMODE_TABLE.length; i++){
            if (str.equalsIgnoreCase(VIDEOMODE_TABLE[i]))
                setVideoModeIdx(i);
        }
    }
    
    
    public String getVideoDeintrelace() {
        return VIDEODEINTRELACE_TABLE[videoDeintrelace];
    }

    public int getVideoDeintrelaceIdx() {
        return videoDeintrelace;
    }

    public void setVideoDeintrelaceIdx(String videoDeintrelace) {
        setVideoDeintrelaceIdx(Integer.parseInt(videoDeintrelace));
    }
    
    public void setVideoDeintrelaceIdx(int videoDeintrelace) {
        this.videoDeintrelace = videoDeintrelace;
        if ( this.getMainOutput() && ContentManager.getMainDisplay() instanceof SDLContentRender ){
            ((SDLContentRender)ContentManager.getMainDisplay()).setDeintrelaceMode( videoDeintrelace );
        }        
        
    }

    public void setVideoDeintrelace(String str){
        for (int i=0; i<VIDEODEINTRELACE_TABLE.length; i++){
            if (str.equalsIgnoreCase(VIDEODEINTRELACE_TABLE[i]))
                setVideoDeintrelaceIdx(i);
        }
    }
    
    
    public int getClockModeIdx() {
        return clockMode;
    }

    public String getClockMode() {
        return CLOCKMODE_TABLE[clockMode];
    }
    
    public void setClockModeIdx(String clockMode) {
        setClockModeIdx(Integer.parseInt(clockMode));
    }
    
    public void setClockModeIdx(int clockMode) {
        this.clockMode = clockMode;
    }

    public void setClockMode(String cm){
        for (int i=0; i<CLOCKMODE_TABLE.length; i++){
            if (cm.equalsIgnoreCase(CLOCKMODE_TABLE[i]))
                setClockModeIdx(i);
        }
    }
    
    public boolean getVideoDebugMode() {
        return this.videoDebugMode;
    }

    public String getVideoDebugModeIdx() {
        if (videoDebugMode==false){
            return "0";
        }else{
            return "1";
        }
    }
    
    public void setVideoDebugMode(String videoDebugMode) {
        setVideoDebugModeIdx(videoDebugMode);
    }

    public void setVideoDebugModeIdx(String videoDebugMode) {
        setVideoDebugMode(videoDebugMode.equals("1"));
    }
        
    public void setVideoDebugMode(boolean videoDebugMode) {
        this.videoDebugMode = videoDebugMode;
        if (this.getMainOutput()){
            if (videoDebugMode){
                ContentManager.getMainDisplay().setDebugMode( 1 );
            }else{
                ContentManager.getMainDisplay().setDebugMode( 0 );
            }
        }
    }

    public String getMainDisplayEngine(){
        return this.mainDisplayEngine;
    }
    
    public void setMainDisplayEngine(String engine){
        this.mainDisplayEngine = engine;
        ContentManager.setMainDisplayEngine(engine);
    }
    
    public String getMonitorDisplayEngine(){
        return this.monitorDisplayEngine;
    }
    
    public void setMonitorDisplayEngine(String engine){
        this.monitorDisplayEngine = engine;
        ContentManager.setMonitorDisplayEngine(engine);
    }

    public int getSlideTransitionTime() {
        return slideTransitionTime;
    }

    public void setSlideTransitionTime(String slideTransitionTime) {
        int x = -1;
        try{
            x = Integer.parseInt(slideTransitionTime);
        }catch(Exception e){
            // do nothing
        }
        setSlideTransitionTime(x);
    }
    
    public void setSlideTransitionTime(int slideTransitionTime) {
        if (slideTransitionTime >= 0){
            this.slideTransitionTime = slideTransitionTime;
        }else{
            this.slideTransitionTime = 0;
        }
    }

    public int getSlideShowHideTime() {
        return slideShowHideTime;
    }

    public void setSlideShowHideTime(String slideShowHideTime) {
        int x = -1;
        try{
            x = Integer.parseInt(slideShowHideTime);
        }catch(Exception e){
            // do nothing
        }
        setSlideShowHideTime(x);
    }
    
    public void setSlideShowHideTime(int slideShowHideTime) {
        if (slideShowHideTime >= 0){
            this.slideShowHideTime = slideShowHideTime;
        }else{
            this.slideShowHideTime = 0;
        }
    }
    
    public boolean getMonitorFollowMainControls(){
        return monitorFollowMainControls;
    }

    public String getMonitorFollowMainControlsIdx(){
        if (monitorFollowMainControls==false){
            return "0";
        }else{
            return "1";
        }
    }
    
    public void setMonitorFollowMainControls(boolean b){
        monitorFollowMainControls = b;
    }
    
    public void setMonitorFollowMainControlsIdx(String str){
        setMonitorFollowMainControls( str.equals("1") );
    }

    public String getMainBackgroundImgStr(){
        return getImgStr(this.mainBackgroundImg);
    }    
    
    public String getMonitorBackgroundImgStr(){
        return getImgStr(this.monitorBackgroundImg);
    }    
    
    private String getImgStr(BufferedImage img){
        
        if (img == null)
            return "";
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write( img, "png", baos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        byte[] ba = baos.toByteArray();

        int len=ba.length,j;
        StringBuffer sb=new StringBuffer(len*2);
        for (j=0;j<len;j++) {
            String sByte=Integer.toHexString((int)(ba[j] & 0xFF));
            sb.append(stringAlign2chars(sByte));
        }
        return sb.toString();
    }

    private String stringAlign2chars(String str){
        if (str.length()!=2)
            return '0'+str;
        else
            return str;
    }
    
    public void setMainBackgroundImgStr(String strImage){
        setImgStr( 0, strImage );
    }
    
    public void setMonitorBackgroundImgStr(String strImage){
        setImgStr( 1, strImage );
    }

    /**
     * @param idx possible values: 0 for Main, 1 for monitor
     */
    private void setImgStr(int idx, String strImage){

        if (strImage.equals("")){
            if (idx == 0){
                this.mainBackgroundImg = null;
            }else if (idx == 1){
                this.monitorBackgroundImg = null;
            }
            return;
        }
        
        String str="";
        int intAux=0;
        byte[] bytes = new byte[strImage.length()/2];
        for(int i=0; i< strImage.length()-1;i=i+2){
            str = strImage.substring(i,i+2);
            intAux = Integer.parseInt(str,16);
            bytes[i/2]=(byte)intAux;
        }
        
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try {
            if (idx == 0){
                setMainBackgroundImg( ImageIO.read(bais) );
            }else if (idx == 1){
                setMonitorBackgroundImg( ImageIO.read(bais) );
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public BufferedImage getMainBackgroundImg(){
        return mainBackgroundImg;
    }
    
    public void setMainBackgroundImg(BufferedImage img){
        this.mainBackgroundImg = img;
        if ( this.getMainOutput() ){
            ContentManager.getMainDisplay().paintBackground(img);
        }
    }

    public BufferedImage getMonitorBackgroundImg(){
        return monitorBackgroundImg;
    }
    
    public void setMonitorBackgroundImg(BufferedImage img){
        this.monitorBackgroundImg = img;
        if ( this.getMonitorOutput() ){
            ContentManager.getMonitorDisplay().paintBackground(img);
        }
    }

    public void setMonitorTemplateFilter(String monitorTemplateFilter){
        this.monitorTemplateFilter = monitorTemplateFilter;
        TemplateManager.getInstance().tableModelChanged();
    }

    public String getMonitorTemplateFilter(){
        if (monitorTemplateFilter == null){
            return "";
        }else{
            return monitorTemplateFilter;
        }
    }
    
    public void setAlertTemplateFilter(String alertTemplateFilter){
        this.alertTemplateFilter = alertTemplateFilter;
        TemplateManager.getInstance().tableModelChanged();
    }
    
    public String getAlertTemplateFilter(){
        if (alertTemplateFilter == null){
            return "";
        }else{
            return alertTemplateFilter;
        }
    }

    public void setGeneralTemplateFilter(String generalTemplateFilter){
        this.generalTemplateFilter = generalTemplateFilter;
        TemplateManager.getInstance().tableModelChanged();
    }
    
    public String getGeneralTemplateFilter(){
        if (generalTemplateFilter == null){
            return "";
        }else{
            return generalTemplateFilter;
        }
    }
    
    

}
